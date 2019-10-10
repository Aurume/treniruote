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
	  
	  public List<Patiekalai> pasiulymai( Integer id ) {       // ar tikrai patiekalu sarasas
		  
		  	String qw_pasiulymai =
		  				
		  		"SELECT SQL_CALC_FOUND_ROWS " 
					+ 	"`patiekalai`.*"
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
					+ "WHERE "
						+ 		"`klientai_patiekalai`.`id` IS NULL"
						+ " AND "
						+  		"`klientai`.`flag_alerg_pieno`=`patiekalai`.`flag_yra_pieno`" 
						+ " AND "	
						+		"`klientai`.`flag_alerg_riesutai`=`patiekalai`.`flag_yra_riesutu`"
						+ " AND "
						+  		"`klientai`.`flag_vartoja_alkoholi`=`patiekalai`.`flag_viskas_isk`" // kuom pakeisti viskas iskaiciuota???
						//+ " AND "	
						//+		"`klientai`.`flag_laisv_pasir`=`keliones`.`flag_laisv_pasir`"	
				+ " GROUP BY" 
				+	   " `patiekalai`.`id` "
					;
		  	System.out.println ( qw_pasiulymai );
		    Query query = em.createNativeQuery ( qw_pasiulymai );
		    return (List<Patiekalai>) query.getResultList();
	  }	  		  
	   
}