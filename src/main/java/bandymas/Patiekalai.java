package bandymas;

import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Patiekalai {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	 
	 private String pav;
	 
	 private Integer flagYraRiesutai;
	 
	 private Integer flagYraPieno;
	 
/*	 
	 @OneToMany(mappedBy = "patiekalai",cascade = CascadeType.ALL)
	 private List<KlientaiPatiekalai> klientaiPatiekalai;

	  @OneToMany(mappedBy = "patiekalai",cascade = CascadeType.ALL)
	private List<Klientai> klientai;    
*/
	 public Patiekalai () {
		 
	 }
	 
	 
	 public Patiekalai( String pavadinimas, Integer savybe_yra_riesutu, Integer savybe_yra_pieno ) {
		 
		 pav = pavadinimas;
		 
		 flagYraRiesutai = savybe_yra_riesutu;
		 
		 flagYraRiesutai = savybe_yra_pieno; 
	 }


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the pav
	 */
	public String getPav() {
		return pav;
	}


	/**
	 * @param pav the pav to set
	 */
	public void setPav(String pav) {
		this.pav = pav;
	}


	/**
	 * @return the flagYraRiesutai
	 */
	public Integer getFlagYraRiesutai() {
		return flagYraRiesutai;
	}


	/**
	 * @param flagYraRiesutai the flagYraRiesutai to set
	 */
	public void setFlagYraRiesutai(Integer flagYraRiesutai) {
		this.flagYraRiesutai = flagYraRiesutai;
	}


	/**
	 * @return the flagYraPieno
	 */
	public Integer getFlagYraPieno() {
		return flagYraPieno;
	}


	/**
	 * @param flagYraPieno the flagYraPieno to set
	 */
	public void setFlagYraPieno(Integer flagYraPieno) {
		this.flagYraPieno = flagYraPieno;
	}
	
	
	/*
	/**
	 * @return the uzsakymai
	 */
	//public List<Uzsakymai> getUzsakymai() {
		//return uzsakymai;
	//} 

	///**
	 //* @param uzsakymai the uzsakymai to set
	 //*/
	//public void setUzsakymai(List<Uzsakymai> uzsakymai) {
		//this.uzsakymai = uzsakymai;
	//}	
 
}



