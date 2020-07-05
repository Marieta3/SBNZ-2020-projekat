package sbnz.SBNZbackendapp.facts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Region {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private double nadmorskaVisina;
	
	@Column 
	private double prosecnaGodisnjaTemperatura;
	
	@Column
	private double minTemperatura;
	
	@Column
	private double maxTemperatura;
	
	@Column
	private double kolicinaPadavina;
	
	
	
	
}
