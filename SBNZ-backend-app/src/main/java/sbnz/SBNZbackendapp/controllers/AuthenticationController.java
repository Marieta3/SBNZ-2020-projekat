package sbnz.SBNZbackendapp.controllers;

import sbnz.SBNZbackendapp.models.RegisteredUser;
import sbnz.SBNZbackendapp.models.User;
import sbnz.SBNZbackendapp.models.DTO.RegistrationUserDTO;
import sbnz.SBNZbackendapp.models.converters.UserConverter;
import sbnz.SBNZbackendapp.security.TokenUtils;
import sbnz.SBNZbackendapp.security.auth.JwtAuthenticationRequest;
import sbnz.SBNZbackendapp.security.domain.Authority;
import sbnz.SBNZbackendapp.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    public TokenUtils tokenUtils;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public UserService userService;

    @Autowired
    public UserConverter userConverter;


    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity logOut(HttpServletRequest request) {
        SecurityContextHolder.getContext().setAuthentication(null);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> logIn(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        final Authentication authentication = authenticationManager
                                .authenticate(new UsernamePasswordAuthenticationToken(
                                        authenticationRequest.getUsername(),
                                        authenticationRequest.getPassword()
                                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User)authentication.getPrincipal();
        List<Authority> roles = user.getAuthList();
        String role = roles.get(0).getAuthority();
        return ResponseEntity.ok( userConverter.toDTO(user, tokenUtils.generateToken(user.getUsername(), role)));
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody RegistrationUserDTO userDTO){
        RegisteredUser new_user = null;
        
        new_user = userService.registerUser(userDTO);
        
        return ResponseEntity.ok(new_user);
    }

    @GetMapping(value = "/testAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String testAdmin(Principal p) {
//        certificateUtils.generateIssuerData();
        return "ADMIN WORKS " + p.getName();
    }
    
    @GetMapping(value = "/testUser")
    @PreAuthorize("hasRole('USER')")
    public String testUser(Principal p) {
//        certificateUtils.generateIssuerData();
        return "USER WORKS " + p.getName();
    }
    
    @GetMapping(value = "/test")
    public String test1() {
//        certificateUtils.generateIssuerData();
        return "APP WORKS ";
    }
    
    
}
