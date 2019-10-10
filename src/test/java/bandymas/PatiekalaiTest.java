package bandymas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
																						// import org.springframework.boot.test.autoconfigure.orm.jpa.*; - nereikia i� pvz. !
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
																						// @DataJpaTest											         - nereikia i� pvz. !
public class PatiekalaiTest {
	
    @Autowired
    private PatiekalaiRepository patiekalaiRepository;
   
    @Test
    public void testSaveGetPatiekalai() {

        																			     // System.out.println (" starting here test ! ");    	
        Patiekalai patiekalai = new Patiekalai("cepelinai", 1, 1 );
        Patiekalai patiekal = patiekalaiRepository.save(patiekalai);
        Patiekalai pat = patiekalaiRepository.findByPav("cepelinai");
        																			     // System.out.println (" kt1 : " + produkt.getId() );        
        assertNotNull(patiekalai);
        																			     // System.out.println (" kt2 ! ");        
        assertNotNull(pat);        
        																			     // System.out.println (" kt3 ! ");        
        assertEquals(pat.getPav(), patiekalai.getPav());
        																				 // System.out.println (" kt4 ! ");   
        																				 // -- neveiks kt4 nespaudina .. 
        assertEquals(pat.getFlagYraPieno(), patiekalai.getFlagYraPieno());
        																				 // System.out.println (" kt5 ! ");      
        
        patiekalaiRepository.deleteById(patiekal.getId());
	
        System.out.println (" ending here test ! ");																		         // System.out.println (" ending here test ! ");
    }
    
    @Test   
    public void testFindAllPatiekalai() {
        assertNotNull(patiekalaiRepository.findAll());
    }
    
    @Test    
    public void deleteFoundedByName() {
        																			// System.out.println (" kt6 ! ");       
        Patiekalai patiekalai = new Patiekalai( "Varškėčiai", 1, 1); 
        Patiekalai pat = patiekalaiRepository.save( patiekalai );        
		patiekalaiRepository.delete( pat );                  					    // -- pagal pavyzdi neveikia  :(  
        Patiekalai patiekal = patiekalaiRepository.findByPav("Varškėčiai");
        assertEquals( patiekal, null );		
    }    

    @Test
    public void deletByPatiekalaiIdTest() {
    	
		Patiekalai patiekal = null;
        Patiekalai patiekalai = new Patiekalai( "moliugų sriuba", 1, 1);    	
        Patiekalai pat = patiekalaiRepository.save(patiekalai);
        Integer id_pat = pat.getId();
        patiekalaiRepository.deleteById(id_pat); //ar patiekalai id?
        Optional <Patiekalai> found = patiekalaiRepository.findById ( id_pat );
        
		if ( found.isPresent() ) {
			
			   patiekal = found.get();
		}
        assertEquals( patiekal, null );        
    }   
}