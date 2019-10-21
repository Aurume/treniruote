package bandymas;

//import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * @author User
 *
 */

//@Repository
public class PatiekalaiRekomenduojami {														//šita dalį padaryti kai jau turėsiu mėgstamiausius patiekalus.
	 
	  protected Session em;
	  
	  protected EntityManagerFactory factory;	
		
	  public SessionFactory sessionFactory() {
			
	        if (this.factory.unwrap(SessionFactory.class) == null) {
	            throw new NullPointerException("factory is not a hibernate factory");
	        }
		        return this.factory.unwrap(SessionFactory.class);
		}	
	  
	  public PatiekalaiRekomenduojami(EntityManagerFactory factory) {
		  
		  this.factory = factory; 
		  this.em = this.sessionFactory().openSession(); 
				
	  }				
	
	  
	  public List<KlientaiPatiekalai> mazDaznPatiekalai( Integer klientai_id ) {
		  
		  	String qw_top_patiekalai =
		  			
		  			
		  	// atrodo lyg ir pataisyta pavadinimai pagal mane		
		  
		  			 " ( " + 
		  			"SELECT "
		  			  		+ 	"patiekalai.id AS id, "
		  			  		+ 	"patiekalai.pav AS pavadinimas, "
		  			  		+ 	"COUNT(*) AS uzsakymu "
		  			  		+ "FROM "
		  			  		+ 	"klientai_patiekalai AS klientai_patiekalai "
		  			  		+ "LEFT JOIN "
		  			  		+ 	"patiekalai ON (patiekalai.id=klientai_patiekalai.patiekalai_id) "
		  			  		+ "WHERE klientai_patiekalai.klientai_id=" + klientai_id + " "
		  			  		+ "GROUP BY "
		  			  		+ 	"klientai_patiekalai.patiekalai_id "
		  			  		+ "ORDER BY uzsakymu DESC LIMIT 1 " 
		  			  		+ " ) UNION ("
		  			  		+ "SELECT "
		  			  		+ 	"patiekalai.id AS id, "
		  			  		+ 	"patiekalai.pav AS pavadinimas, "
		  			  		+ 	"COUNT(klientai_patiekalai.id) AS uzsakymu "
		  			  		+ "FROM "
		  			  		+ 	"patiekalai "
		  			  		+ "LEFT JOIN "
		  			  		+ 	"klientai_patiekalai ON ("
		  			  		+ 		"patiekalai.id=klientai_patiekalai.patiekalai_id"
		  			  		+     " AND "
		  			  		+       "klientai_patiekalai.klientai_id=" + klientai_id + " "
		  			  		+ ") "
		  					+ "LEFT JOIN "
		  					+ "		`klientai` ON ( "
		  					
		  					+ 			"`klientai`.`id`=" + klientai_id 
		  					+ 		" ) "	  		
		  			  		+ " WHERE"
		  			  		+ " ( NOT  IFNULL(klientai.flag_alerg_riesutai,0) ) OR ( NOT IFNULL(patiekalai.flag_yra_riesutai,0) )"
		  			  		+ " AND "
		  			  		+ "	( NOT IFNULL(klientai.flag_alerg_pieno,0 ) ) OR ( NOT IFNULL(patiekalai.flag_yra_pieno,0) )"
		  			  		+ " GROUP BY "
		  			  		+ 	"patiekalai.id "
		  			  		+ " ORDER BY uzsakymu ASC LIMIT 1 "
		  			  		+ ")"
		  			  		+ ""
		  						;
		  			  	System.out.println ( qw_top_patiekalai );
		  			    Query<KlientaiPatiekalai> query = em.createNativeQuery ( qw_top_patiekalai );

		  			    return (List<KlientaiPatiekalai>) query.getResultList();
		  		  }	  					
		  	    
	  }	  