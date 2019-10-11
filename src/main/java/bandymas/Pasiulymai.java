package bandymas;

import java.util.List;


//import javax.persistence.PersistenceContext;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
import javax.persistence.*;
import org.hibernate.Session;

/**
 * @author User
 *
 */
public class Pasiulymai {

	protected Session em;	
	
	  public Pasiulymai(  Session em  ) {
		  
		    this.em = em;
	  }
	  
	  public List<Patiekalai> pasiulymai( Integer id ) {       // ar tikrai patiekalu sarasas?????
		  
		  	String qw_pasiulymai =
		  				
		  		"SELECT SQL_CALC_FOUND_ROWS " 
					+ 	"`patiekalai`.`id`,`patiekalai`.`pav`, `patiekalai`.`flag_yra_pieno`, `patiekalai`.`flag_yra_riesutai`"  
					+ "FROM "
					+ 		"`patiekalai` "  
					+ "LEFT JOIN "
					+ "		`klientai_patiekalai` ON ( "
					
					+ 				"`patiekalai`.`id`=`klientai_patiekalai`.`klientai_id` "
					+			" AND "
					+				"`klientai_patiekalai`.`klientai_id`=" + id
					+ 		") "
					+ "LEFT JOIN "
					+ "		`klientai` ON ( "
					
					+ 			"`klientai`.`id`=" + id
					+ 		") "					
					//+ "WHERE "
						//+ 		"`klientai_patiekalai`.`id` IS NULL"
					;
		  	System.out.println ( qw_pasiulymai );
		    Query query = em.createNativeQuery ( qw_pasiulymai );
		    return (List<Patiekalai>) query.getResultList();
	  }	  		  
	   
}