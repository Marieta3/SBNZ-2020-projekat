package sbnz.SBNZbackendapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.SBNZbackendapp.services.RegionService;

@RestController
@RequestMapping(value = "/region")
public class RegionController {
	
	@Autowired
	RegionService regionService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(regionService.findAll());
	}

}
