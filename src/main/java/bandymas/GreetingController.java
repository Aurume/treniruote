package bandymas;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

/**
 * @author User
 *
 */

@Controller
public class GreetingController {
	
	@Autowired 
	EntityManagerFactory factory;	
	
	// @Bean
	public SessionFactory sessionFactory() {

		
	        if (factory.unwrap(SessionFactory.class) == null) {
	            throw new NullPointerException("factory is not a hibernate factory");
	        }
	        return factory.unwrap(SessionFactory.class);
	}	
	
    @GetMapping("/")
    public String pradzia(Model model) {
        model.addAttribute("lst_menu", Menu.values() );    	
        return "index";
    }	
	
    @GetMapping("/patiekalai")
    public String patiekalai(Model model) {
        model.addAttribute("lst_menu", Menu.values() );    	
        return "patiekalai";
    }	
    
    @GetMapping("/klientai")
    public String klientai(Model model) {
        model.addAttribute("lst_menu", Menu.values() );    //cia reikejo del menu.values prideti itemUrl is menu.java	
        return "klientai";
    }    

    @GetMapping("/klientas")
    public String klientas(@RequestParam Integer id, Model model) {
        model.addAttribute("lst_menu", Menu.values() );
        return "klientas";
    }  
   
    
	@GetMapping(path="/pasiulymai")
	public  String											
		getPasiulymai(
			@RequestParam Integer id
			, Model model
	) {

		Session session = this.sessionFactory().openSession(); 
		
		Pasiulymai pasiulymai =  new Pasiulymai( session );
        model.addAttribute("lst_pasiulymai", pasiulymai.pasiulymai( id ) );
        model.addAttribute("lst_menu", Menu.values() );        
		return "pasiulymai";
	}
	
		

}
  

