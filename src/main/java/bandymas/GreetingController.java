package bandymas;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/greeting") // This means URL's start with /demo (after Application path)
public class GreetingController {

	@Autowired
	KlientaiRepository klientaiRepository;
	
	@Autowired
	PatiekalaiRepository patiekalaiRepository;	
	
	@Autowired
	KlientaiPatiekalaiRepository klientaiPatiekalaiRepository;
	
	@GetMapping(path="/saugoti-klienta") // Map ONLY GET Requests
	public @ResponseBody String saugotiKlienta (@RequestParam Integer id 
			, @RequestParam String vardas
			, @RequestParam String pavarde
			, @RequestParam Integer savybVartojaAlkoholi
			, @RequestParam Integer savybAlergRiesutai	
			, @RequestParam Integer savybAlergPieno	
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		Klientai n = new Klientai();
		
		if (id > 0) {
		
			Optional <Klientai> found = klientaiRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
		}
		
	    n.setVardas( vardas );
	    n.setPavarde(pavarde);
	    n.setSavybVartojaAlkoholi(savybVartojaAlkoholi);
	    n.setSavybAlergRiesutai(savybAlergRiesutai);
	    n.setSavybAlergPieno(savybAlergPieno);
	    klientaiRepository.save(n);	
	    res = "Saved";
	    
		return res;
	}
	
	@GetMapping(path="/salinti-patiekala") // Map ONLY GET Requests
	public @ResponseBody String salintiPatiekala (@RequestParam Integer id
			, @RequestParam String pav
			, @RequestParam Integer savyb_yra_riesutai	
			, @RequestParam Integer savyb_yra_pieno	
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Patiekalai> found = patiekalaiRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Patiekalai n = found.get();
			   patiekalaiRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}		

	@GetMapping(path="/lst-patiekalai")
	public @ResponseBody Iterable<Patiekalai> getAllPatiekalai() {
		// This returns a JSON or XML with the users
		return patiekalaiRepository.findAll();
	}	

	@GetMapping(path="/saugoti-patiekala") // Map ONLY GET Requests
	public @ResponseBody String saugotiPatiekala (@RequestParam Integer id 
			, @RequestParam String pav
			, @RequestParam Integer savyb_yra_riesutai
			, @RequestParam Integer savyb_yra_pieno	
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		Patiekalai n = new Patiekalai();
		
		if (id > 0) {
		
			Optional <Patiekalai> found = patiekalaiRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
		}
		
	    n.setPav( pav );
	    n.setSavybYraRiesutai(savyb_yra_riesutai);
	    n.setSavybYraPieno(savyb_yra_pieno);  
	    patiekalaiRepository.save(n);	
	    res = "Saved";
	    
		return res;
	}
			

	@GetMapping(path="/lst-klientai")
	public @ResponseBody Iterable<Klientai> getAllKlientai() {
		// This returns a JSON or XML with the users
		return klientaiRepository.findAll();
	}	
	
	@GetMapping(path="/klientas")
	public @ResponseBody Optional<Klientai> getKlientas(@RequestParam Integer id) {
		// This returns a JSON or XML with the users
		Optional <Klientai> found = klientaiRepository.findById( id );		
		/*
		if ( found.isPresent() ) {
			
			   Uzsakymai n = found.get();
		}		
		*/	
		return found;
	}	
	
	@GetMapping(path="/kliento-patiekalas") // Map ONLY GET Requests
	public @ResponseBody String saugotiKlientoPatiekalo (@RequestParam Integer id 
			, @RequestParam(defaultValue="0") Integer klientai_id
			, @RequestParam(defaultValue="0") Integer patiekalai_id
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		KlientaiPatiekalai n = new KlientaiPatiekalai();
		
		System.out.println ( "id: " + id + " kliento. id: " + klientai_id + " patiekalo. id " + patiekalai_id );
		
		if (id > 0) {
		
			Optional <KlientaiPatiekalai> found = klientaiPatiekalaiRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			  //  n.setId(id);
			}
			
		} else {
		
			if ( ( klientai_id > 0 ) && ( patiekalai_id > 0 ) ) {
				
				n.setKlientaiId ( klientai_id );
				n.setPatiekalaiId( patiekalai_id );
			}
		}
		
		System.out.println ( n.toString() );			   			   
		klientaiPatiekalaiRepository.save(n);	
		res = "Saved";
	    
		return res;
	}
	
	@GetMapping(path="/salinti-kliento-patiekala") // Map ONLY GET Requests
	public @ResponseBody String salintiKlientoPatiekala (@RequestParam Integer klientai_id
			, @RequestParam Integer id 
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <KlientaiPatiekalai> found = klientaiPatiekalaiRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   KlientaiPatiekalai n = found.get();
			   klientaiPatiekalaiRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}	
}

