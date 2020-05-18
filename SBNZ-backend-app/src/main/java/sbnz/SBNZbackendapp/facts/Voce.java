package sbnz.SBNZbackendapp.facts;

public class Voce {

	private Long id;
	private String name;
	
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
