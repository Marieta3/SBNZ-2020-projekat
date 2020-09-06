package sbnz.SBNZbackendapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.SBNZbackendapp.facts.Zemljiste;
import sbnz.SBNZbackendapp.models.DTO.ZemljisteDTO;
import sbnz.SBNZbackendapp.models.converters.ZemljisteConverter;

@RestController
@RequestMapping(value = "/suggest")
public class SuggestionController {
	
	@Autowired
	public ZemljisteConverter zemljisteConverter;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('USER')")
	public Zemljiste getQuestionsZemljiste(@RequestBody ZemljisteDTO dto) {

		Zemljiste newZemljiste = zemljisteConverter.toDTO(dto);

		System.out.println("Zemljiste request received for: " + newZemljiste);

		//Zemljiste z2 = sampleService.getClassifiedZemljiste(newZemljiste);

		return newZemljiste;
	}

}
