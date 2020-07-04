package sbnz.SBNZbackendapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.SBNZbackendapp.facts.Voce;
import sbnz.SBNZbackendapp.repositories.VoceRepository;

@Service
public class VoceService {

	@Autowired
	private VoceRepository voceRepository;
	
	public Voce findOneByName(String name) {
		return voceRepository.findOneByName(name).orElse(null);
	}
	
	public List<Voce> findAll(){
		return voceRepository.findAll();
	}
	
	public Voce save(Voce voce) {
		return voceRepository.save(voce);
	}
}
