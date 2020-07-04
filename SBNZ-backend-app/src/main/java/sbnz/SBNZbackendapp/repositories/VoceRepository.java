package sbnz.SBNZbackendapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.SBNZbackendapp.facts.Voce;


public interface VoceRepository extends JpaRepository<Voce, Long> {
	
	Optional<Voce> findOneByName(String name);

}
