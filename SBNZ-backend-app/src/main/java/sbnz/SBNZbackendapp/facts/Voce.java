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
	
	
	@Override
	public String toString() {
		return "Voce [id=" + id + ", name=" + name + "]";
	}
	public Voce() {
		super();
	}
	public Voce(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Voce(String name) {
		this(null, name);
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
