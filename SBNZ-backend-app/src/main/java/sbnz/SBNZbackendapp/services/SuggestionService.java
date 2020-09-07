package sbnz.SBNZbackendapp.services;

import java.util.ArrayList;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.mvel2.optimizers.impl.refl.nodes.ArrayLength;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.SBNZbackendapp.SampleAppService;
import sbnz.SBNZbackendapp.facts.Item;
import sbnz.SBNZbackendapp.facts.Voce;
import sbnz.SBNZbackendapp.facts.Zemljiste;

@Service
public class SuggestionService {
	
	private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

	private final KieContainer kieContainer;
	
	@Autowired
	public SuggestionService(KieContainer kieContainer) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
	}
	
	@Autowired
	VoceService voceService;
	
	
	public Zemljiste getClassifiedZemljiste(Zemljiste z, int poklapanja) {
		ArrayList<Voce> all = (ArrayList<Voce>) voceService.findAll();
		KieSession kieSession = kieContainer.newKieSession();
		//kieSession.setGlobal("poklapanja", poklapanja);
		kieSession.insert(z);
		for(Voce v: all) {
			System.out.println(v);
			kieSession.insert(v);
		}
		kieSession.getAgenda().getAgendaGroup("classify").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		return z;
	}
	
	public Zemljiste getVoce(Zemljiste z) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(z);
		kieSession.fireAllRules();
		kieSession.dispose();
		return z;
	}

}
