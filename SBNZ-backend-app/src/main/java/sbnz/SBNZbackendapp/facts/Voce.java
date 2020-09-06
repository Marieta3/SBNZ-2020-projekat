package sbnz.SBNZbackendapp.facts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voce {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private double nadmorskaVisina;
	
	@Column
	private String opis;
	
	
	@Override
	public String toString() {
		return "Voce [id=" + id + ", name=" + name + ", nadmorskaVisina=" + nadmorskaVisina + ", opis=" + opis + "]";
	}
	public Voce() {
		super();
	}
	public Voce(Long id, String name, String opis) {
		super();
		this.id = id;
		this.name = name;
		this.opis = opis;
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
		return opis;
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
