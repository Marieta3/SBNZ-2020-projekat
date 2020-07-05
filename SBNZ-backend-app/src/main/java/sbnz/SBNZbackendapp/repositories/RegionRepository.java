package sbnz.SBNZbackendapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.SBNZbackendapp.facts.Region;

public interface RegionRepository extends JpaRepository<Region, Long>{

	Optional<Region> findOneByNaziv(String naziv);
}
