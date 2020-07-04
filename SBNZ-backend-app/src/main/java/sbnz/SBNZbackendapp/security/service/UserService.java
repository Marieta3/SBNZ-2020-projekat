package sbnz.SBNZbackendapp.security.service;

import sbnz.SBNZbackendapp.config.WebSecurityConfig;
import sbnz.SBNZbackendapp.models.RegisteredUser;
import sbnz.SBNZbackendapp.models.User;
import sbnz.SBNZbackendapp.models.DTO.RegistrationUserDTO;
import sbnz.SBNZbackendapp.security.domain.Authority;
import sbnz.SBNZbackendapp.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authorityService;
    
    @Autowired
    private WebSecurityConfig webSecurityConfig;
    
    public RegisteredUser registerUser(RegistrationUserDTO dto) {
    	RegisteredUser user = new RegisteredUser();
    	user.setName(dto.getName());
    	user.setLastName(dto.getLastName());
    	user.setConfirmed(true);
    	user.setEmail(dto.getEmail());
    	user.setEnabled(true);
    	user.setUsername(dto.getUsername());
    	List<Authority> authorities = new ArrayList<>();
		Authority a = new Authority();
		a.setName("ROLE_USER");
		authorities.add(a);
		user.setAuthorities(authorities);
		user.setPassword(webSecurityConfig.passwordEncoder().encode(dto.getPassword()));
		
		return (RegisteredUser) save(user);
    }
    
    public User save(User user){
		return userRepository.save(user);
	}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByUsername(username);
        if(userDetails == null){
        	throw new UsernameNotFoundException("User with user name: " + username + " not found");
		}
		return userDetails;
    }

    public UserDetails loadUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Transactional
	public User enableUser(String email) {
		User u = userRepository.findByEmail(email);
		if (u != null) {
			
			if (u.isEnabled())
				u.setEnabled(false);
			else
				u.setEnabled(true);
			return userRepository.save(u);
		} 
		return null;
	}

	public User findById(Long id) {
		Optional<User> ou = userRepository.findById(id);
		if (ou.isPresent())
			return ou.get();
		return null;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Transactional
	public User update(User user) {
		User userOld = userRepository.findById(user.getId()).orElse(null);
		if (userOld != null) {
			userOld.setUsername(user.getUsername());
			userOld.setEmail(user.getEmail());
			PasswordEncoder pe = this.webSecurityConfig.passwordEncoder();
			userOld.setPassword(pe.encode(user.getPassword()));
			userOld.setEnabled(user.getEnabled());
			userOld.setName(user.getName());
			return userRepository.save(userOld);
		}
		return null;
	}

	public Boolean checkIfPasswordsMatch(String password, String email) {
		User u = userRepository.findByEmail(email);
		PasswordEncoder pe = this.webSecurityConfig.passwordEncoder();
		if (pe.matches(password, u.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
