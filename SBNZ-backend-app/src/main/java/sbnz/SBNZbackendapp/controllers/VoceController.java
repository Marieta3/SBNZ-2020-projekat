package sbnz.SBNZbackendapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.SBNZbackendapp.facts.Voce;
import sbnz.SBNZbackendapp.services.VoceService;

@RestController
@RequestMapping(value = "/voce")
public class VoceController {
	
	@Autowired
	private VoceService voceService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(voceService.findAll());
	}
	
	@GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public ResponseEntity<?> getOneByName(@PathVariable(value = "name") String name){
		Voce voce = voceService.findOneByName(name);
		if(voce!=null) {
			return ResponseEntity.ok(voce);
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	@GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public ResponseEntity<?> getOneById(@PathVariable(value = "id") Long id){
		Voce voce = voceService.findOneById(id);
		if(voce!=null) {
			return ResponseEntity.ok(voce);
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addVoce(@RequestBody Voce voce) {
		
		voceService.save(voce);
		return ResponseEntity.ok("Successfully added fruit");
	}
}
