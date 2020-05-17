package sbnz.SBNZbackendapp.facts;


public class Zemljiste {

	public enum phCategory {
        NA, ALKALNO, NEUTRALNO, SLABO_KISELO,
        KISELO, JAKO_KISELO
    };
    
    public enum calcCategory {
        NA, BESKARBONATNO, SLABO_KARBONATNO, SREDNJE_KARBONATNO, JAKO_KARBONATNO
    };
    
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    //private String name;
    private Double phVrednost;
    private Double kalcijumKarbonat;
    private phCategory phCategory;
    private calcCategory calcCategory;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getKalcijumKarbonat() {
		return kalcijumKarbonat;
	}
	public void setKalcijumKarbonat(Double kalcijumKarbonat) {
		this.kalcijumKarbonat = kalcijumKarbonat;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Zemljiste(Long id, Double pHVrednost, Double kalcijumKarbonat) {
		super();
		this.id = id;
		//this.name = name;
		this.phVrednost = pHVrednost;
		this.kalcijumKarbonat = kalcijumKarbonat;
		this.phCategory = phCategory.NA;
		this.calcCategory = calcCategory.NA;
	}
	
	public Zemljiste() {
		super();
	}
	
	public Zemljiste(Double phVrednost, Double kalcijumKarbonat) {
        this(null, phVrednost, kalcijumKarbonat);
    }
	
	@Override
	public String toString() {
		return "Zemljiste [id=" + id + ", pHVrednost=" + phVrednost + ", kalcijumKarbonat="
				+ kalcijumKarbonat + ", phKategorija=" + phCategory + ", kalcKarbKategorija=" + calcCategory
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((calcCategory == null) ? 0 : calcCategory.hashCode());
		result = prime * result + ((kalcijumKarbonat == null) ? 0 : kalcijumKarbonat.hashCode());
		result = prime * result + ((phVrednost == null) ? 0 : phVrednost.hashCode());
		result = prime * result + ((phCategory == null) ? 0 : phCategory.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zemljiste other = (Zemljiste) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (calcCategory != other.calcCategory)
			return false;
		if (kalcijumKarbonat == null) {
			if (other.kalcijumKarbonat != null)
				return false;
		} else if (!kalcijumKarbonat.equals(other.kalcijumKarbonat))
			return false;
		
		if (phVrednost == null) {
			if (other.phVrednost != null)
				return false;
		} else if (!phVrednost.equals(other.phVrednost))
			return false;
		if (phCategory != other.phCategory)
			return false;
		return true;
	}
	public Double getPhVrednost() {
		return phVrednost;
	}
	public void setPhVrednost(Double phVrednost) {
		this.phVrednost = phVrednost;
	}
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
	
    
    
}
