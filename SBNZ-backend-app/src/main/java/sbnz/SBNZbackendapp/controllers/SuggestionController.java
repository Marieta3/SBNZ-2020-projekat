package sbnz.SBNZbackendapp.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.SBNZbackendapp.SampleAppController;
import sbnz.SBNZbackendapp.SampleAppService;
import sbnz.SBNZbackendapp.facts.Voce;
import sbnz.SBNZbackendapp.facts.Zemljiste;
import sbnz.SBNZbackendapp.models.DTO.ZemljisteDTO;
import sbnz.SBNZbackendapp.models.converters.ZemljisteConverter;
import sbnz.SBNZbackendapp.services.SuggestionService;

@RestController
@RequestMapping(value = "/suggest")
public class SuggestionController {
	
	private static Logger log = LoggerFactory.getLogger(SampleAppController.class);
	
	@Autowired
	public ZemljisteConverter zemljisteConverter;
	
	private final SuggestionService suggestionService;

	@Autowired
	public SuggestionController(SuggestionService suggestionService) {
		this.suggestionService = suggestionService;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getQuestionsZemljiste(@RequestBody ZemljisteDTO dto) {

		Zemljiste newZemljiste = zemljisteConverter.toDTO(dto);

		System.out.println("Zemljiste request received for: " + newZemljiste);

		Zemljiste z2 = suggestionService.getClassifiedZemljiste(newZemljiste, dto.getPoklapanja());

		return new ResponseEntity<>(newZemljiste.getListaVoca(), HttpStatus.OK);
	}
	
	

}
