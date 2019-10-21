package bandymas;

import java.util.List;


//import javax.persistence.PersistenceContext;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
import javax.persistence.*;
import org.hibernate.Session;

//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

public class MegstamiPatiekalai { /*

	public List<MegstamiPatiekalai> megstamiPatiekalai( String laikotarpis_nuo, String laikotarpis_iki ) {
	  
  	String qw_top_patieklai =
  				
  		"SELECT SQL_CALC_FOUND_ROWS " 
			+ 	"`patiekalai`.`id` AS `pat_id` "
			+ 	", `patiekalai`.`pav` AS `patiekalas` "
			+ 	", `patiekalai`.`trukme_ruosimo` AS `ruosti` "
			+ 	", `patiekalai`.`trukme_kaitinimo` AS `kaitinti` "
			+ 	", `patiekalai`.`kaina` AS `kaina_patiek` "
			+ 	", COUNT(*) AS `uzsakymu` "
			+ 	", SUM(`uzsakymai`.`kaina`) AS `uz_suma` "
			+ 	", `uzsakymai`.`pav` AS `pav_uzsakymo` "
			+ "FROM "
			+ 		"`patiekalai` "  
			+ "LEFT JOIN "
			+ "		`uzsakymai` ON ( "
			
			+ 			"`uzsakymai`.`id_patiekalo`=`patiekalai`.`id` "
			+ 		") "
			+ "WHERE "
			+ 		"1 "
			+ "AND "
			+  		"SUBSTRING( `uzsakymai`.`laikas_uzsakymo`,1, 10 )" 
						+ " BETWEEN '" + laikotarpis_nuo + "' AND '" + laikotarpis_iki + "' " 	
		+ " GROUP BY" 
		+	   " `patiekalai`.`id` "
		+ " ORDER BY"
		+	   " `uzsakymu` DESC "
			;
  	System.out.println ( qw_top_patieklai );
    //Query query = em.createNativeQuery ( qw_top_patieklai );
    //return (List<TopPatiekalai>) query.getResultList();
	}	  */

}

