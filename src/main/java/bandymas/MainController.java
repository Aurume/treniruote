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
public class MainController {
	
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
	
	@GetMapping(path="/top-patiekalai")
	public  String											// @ResponseBody Iterable<TopPatiekalai> 
		getTopPatiekalai(
			@RequestParam String laikotarpis_nuo
			, @RequestParam String laikotarpis_iki
			, Model model
	) {
		
//		 Map<String, String> properties = new HashMap<String, String>();
//		  properties.put("javax.persistence.jdbc.user", "root");
//		  properties.put("javax.persistence.jdbc.password", "");
//		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("TopPatiekalaiAtaskaita");   // Persistence.createEntityManagerFactory( "jdbc:mysql://localhost:3306/spring_jpa/kavine;user=root;password=");		
		
//	    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "TopPatiekalaiAtaskaita" ); // "Eclipselink_JPA" );
//		EntityManager entitymanager = emf.createEntityManager();
				
//		TopPatiekalaiAtaskaita tp = new TopPatiekalaiAtaskaita( entitymanager );

//		return tp.topPatiekalai(laikotarpis_nuo, laikotarpis_iki);
		
//	    HibernateUtil hibernateUtil = new HibernateUtil();
		
 
		/*      
		try {
			
			factory = new Configuration().configure().buildSessionFactory();
			
		} catch (Throwable ex) {
			
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}		
		*/
		Session session = this.sessionFactory().openSession(); // factory.getCurrentSession();
		// String sqlQuery = "select openmode from ";
		// Query query = session.createNativeQuery(sqlQuery);
		// List<Object[]> listResults = query.getResultList();
		
		PatiekalaiRekomenduojami patiekalai_rekomenduojami =  new PatiekalaiRekomenduojami( session );
        model.addAttribute("lst_top_patiekalai", patiekalai_rekomenduojami.megstamiPatiekalai(laikotarpis_nuo, laikotarpis_iki) ); 		
		return "toppatiekalai";
		// return top_patieklai_ataskaita.topPatiekalai(laikotarpis_nuo, laikotarpis_iki);
	}
	
  
}
