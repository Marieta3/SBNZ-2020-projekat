package sbnz.SBNZbackendapp.facts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import sbnz.SBNZbackendapp.facts.Zemljiste.calcCategory;
import sbnz.SBNZbackendapp.facts.Zemljiste.phCategory;

@Entity
public class Voce {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String opis;
	
	//idealne vremenske prilike
	@Column
	private double nadmorskaVisina;
	
	@Column
	private double minTemperatura;
	
	@Column
	private double maxTemperatura;
	
	
	@Column
	private double kolicinaPadavina;
	
	public phCategory getPhCategory() {
		return phCategory;
	}


	public void setPhCategory(phCategory phCategory) {
		this.phCategory = phCategory;
	}


	public calcCategory getCalcCategory() {
		return calcCategory;
	}


	public void setCalcCategory(calcCategory calcCategory) {
		this.calcCategory = calcCategory;
	}
	@Column 
	private double prosecnaGodisnjaTemperatura;
	
	//idealne karakteristike zemljista
	@Column 
	private phCategory phCategory;
	@Column 
    private calcCategory calcCategory;
	
	
	public Voce() {
		super();
	}
	

	public double getMinTemperatura() {
		return minTemperatura;
	}


	public void setMinTemperatura(double minTemperatura) {
		this.minTemperatura = minTemperatura;
	}


	public double getMaxTemperatura() {
		return maxTemperatura;
	}


	public void setMaxTemperatura(double maxTemperatura) {
		this.maxTemperatura = maxTemperatura;
	}



	public double getKolicinaPadavina() {
		return kolicinaPadavina;
	}


	public void setKolicinaPadavina(double kolicinaPadavina) {
		this.kolicinaPadavina = kolicinaPadavina;
	}


	public double getProsecnaGodisnjaTemperatura() {
		return prosecnaGodisnjaTemperatura;
	}


	public void setProsecnaGodisnjaTemperatura(double prosecnaGodisnjaTemperatura) {
		this.prosecnaGodisnjaTemperatura = prosecnaGodisnjaTemperatura;
	}




	@Override
	public String toString() {
		return "Voce [id=" + id + ", name=" + name + ", opis=" + opis + ", nadmorskaVisina=" + nadmorskaVisina
				+ ", minTemperatura=" + minTemperatura + ", maxTemperatura=" + maxTemperatura + ", kolicinaPadavina="
				+ kolicinaPadavina + ", prosecnaGodisnjaTemperatura=" + prosecnaGodisnjaTemperatura + ", phCategory="
				+ phCategory + ", calcCategory=" + calcCategory + "]";
	}


	public Voce(Long id, String name, String opis, double nadmorskaVisina, double minTemperatura, double maxTemperatura,
			 double kolicinaPadavina, double prosecnaGodisnjaTemperatura) {
		super();
		this.id = id;
		this.name = name;
		this.opis = opis;
		this.nadmorskaVisina = nadmorskaVisina;
		this.minTemperatura = minTemperatura;
		this.maxTemperatura = maxTemperatura;
		this.kolicinaPadavina = kolicinaPadavina;
		this.prosecnaGodisnjaTemperatura = prosecnaGodisnjaTemperatura;
	}

	public Voce(String name) {
		this.name = name;
		this.id = null;
	}
	public double getNadmorskaVisina() {
		return nadmorskaVisina;
	}
	public void setNadmorskaVisina(double nadmorskaVisina) {
		this.nadmorskaVisina = nadmorskaVisina;
	}
	public String getOpis() {
		return opis + "\n" + this.toString();
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
