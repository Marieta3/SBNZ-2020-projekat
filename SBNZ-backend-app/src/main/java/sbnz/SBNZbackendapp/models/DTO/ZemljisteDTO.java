package sbnz.SBNZbackendapp.models.DTO;

public class ZemljisteDTO {
	
	private double phVrednost;
    private double kalcijumKarbonat;
    private double azot;
    private double fosfor;
    private double kalijum;
    private double humus;
    private String region;
    private String voce;
    private int poklapanja;
    
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public double getPhVrednost() {
		return phVrednost;
	}
	public void setPhVrednost(double phVrednost) {
		this.phVrednost = phVrednost;
	}
	public double getKalcijumKarbonat() {
		return kalcijumKarbonat;
	}
	public void setKalcijumKarbonat(double kalcijumKarbonat) {
		this.kalcijumKarbonat = kalcijumKarbonat;
	}
	public double getAzot() {
		return azot;
	}
	public void setAzot(double azot) {
		this.azot = azot;
	}
	public double getFosfor() {
		return fosfor;
	}
	public void setFosfor(double fosfor) {
		this.fosfor = fosfor;
	}
	public double getKalijum() {
		return kalijum;
	}
	public void setKalijum(double kalijum) {
		this.kalijum = kalijum;
	}
	public double getHumus() {
		return humus;
	}
	public void setHumus(double humus) {
		this.humus = humus;
	} 
	public ZemljisteDTO(double phVrednost, double kalcijumKarbonat, double azot, double fosfor, double kalijum,
			double humus, String region) {
		super();
		this.phVrednost = phVrednost;
		this.kalcijumKarbonat = kalcijumKarbonat;
		this.azot = azot;
		this.fosfor = fosfor;
		this.kalijum = kalijum;
		this.humus = humus;
		this.region = region;
	}
	public ZemljisteDTO() {
		super();
	}
    
    

}
