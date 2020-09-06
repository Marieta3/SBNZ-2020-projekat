package sbnz.SBNZbackendapp.models.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sbnz.SBNZbackendapp.facts.Region;
import sbnz.SBNZbackendapp.facts.Zemljiste;
import sbnz.SBNZbackendapp.facts.Zemljiste.calcCategory;
import sbnz.SBNZbackendapp.facts.Zemljiste.phCategory;
import sbnz.SBNZbackendapp.models.DTO.ZemljisteDTO;
import sbnz.SBNZbackendapp.services.RegionService;

@Component
public class ZemljisteConverter {
	
	@Autowired
	RegionService regionService;
	
	public Zemljiste toDTO(ZemljisteDTO dto) {
		Zemljiste z = new Zemljiste();
		z.setKalcijumKarbonat(dto.getKalcijumKarbonat());
		z.setPhVrednost(dto.getPhVrednost());
		z.setAzot(dto.getAzot());
		z.setFosfor(dto.getFosfor());
		z.setHumus(dto.getHumus());
		z.setKalijum(dto.getKalijum());
		
		z.setCalcCategory(calcCategory.NA);
		z.setPhCategory(phCategory.NA);
		
		Region r = regionService.findOneByNaziv(dto.getRegion());
		z.setRegion(r);
		return z;
	}

}
