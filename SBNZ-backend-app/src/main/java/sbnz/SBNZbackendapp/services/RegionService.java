package sbnz.SBNZbackendapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.SBNZbackendapp.facts.Region;
import sbnz.SBNZbackendapp.repositories.RegionRepository;

@Service
public class RegionService {

	@Autowired
	RegionRepository regionRepository;
	
	public Region findOneByNaziv(String naziv) {
		return regionRepository.findOneByNaziv(naziv).orElse(null);
	}
}
