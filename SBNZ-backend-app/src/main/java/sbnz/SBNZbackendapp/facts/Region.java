package sbnz.SBNZbackendapp.facts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Region {

	@Override
	public String toString() {
		return "Region [id=" + id + ", naziv=" + naziv + ", nadmorskaVisina=" + nadmorskaVisina
				+ ", prosecnaGodisnjaTemperatura=" + prosecnaGodisnjaTemperatura + ", minTemperatura=" + minTemperatura
				+ ", maxTemperatura=" + maxTemperatura + ", kolicinaPadavina=" + kolicinaPadavina + "]";
	}

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

	public Region(Long id, String naziv, double nadmorskaVisina, double prosecnaGodisnjaTemperatura,
			double minTemperatura, double maxTemperatura, double kolicinaPadavina) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nadmorskaVisina = nadmorskaVisina;
		this.prosecnaGodisnjaTemperatura = prosecnaGodisnjaTemperatura;
		this.minTemperatura = minTemperatura;
		this.maxTemperatura = maxTemperatura;
		this.kolicinaPadavina = kolicinaPadavina;
	}

	public Region() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getNadmorskaVisina() {
		return nadmorskaVisina;
	}

	public void setNadmorskaVisina(double nadmorskaVisina) {
		this.nadmorskaVisina = nadmorskaVisina;
	}

	public double getProsecnaGodisnjaTemperatura() {
		return prosecnaGodisnjaTemperatura;
	}

	public void setProsecnaGodisnjaTemperatura(double prosecnaGodisnjaTemperatura) {
		this.prosecnaGodisnjaTemperatura = prosecnaGodisnjaTemperatura;
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
	
	
	
	
}
