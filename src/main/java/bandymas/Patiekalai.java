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
	 
	 private Integer savybYraRiesutai;
	 
	 private Integer savybYraPieno;
	 
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
		 
		 savybYraRiesutai = savybe_yra_riesutu;
		 
		 savybYraPieno = savybe_yra_pieno; 
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
	 * @return the savyb_yra_riesutai
	 */
	public Integer getSavybYraRiesutai() {
		return savybYraRiesutai;
	}

	/**
	 * @param savyb_yra_riesutai the savyb_yra_riesutai to set
	 */
	public void setSavybYraRiesutai(Integer savyb_yra_riesutai) {
		this.savybYraRiesutai = savyb_yra_riesutai;
	}

	/**
	 * @return the savyb_yra_pieno
	 */
	public Integer getSavybYraPieno() {
		return savybYraPieno;
	}

	/**
	 * @param savyb_yra_pieno the savyb_yra_pieno to set
	 */
	public void setSavybYraPieno(Integer savyb_yra_pieno) {
		this.savybYraPieno = savyb_yra_pieno;
	}

	/**
	 * @return the klientai
	 *
	public List<Klientai> getKlientai() {
		return klientai;
	}

	/**
	 * @param klientai the klientai to set
	 *
	public void setKlientai(List<Klientai> klientai) {
		this.klientai = klientai;
	}

	/**
	 * @return the klientai_patiekalai
	 *
	public List<KlientaiPatiekalai> getKlientai_patiekalai() {
		return klientaiPatiekalai;
	}

	/**
	 * @param klientai_patiekalai the klientai_patiekalai to set
	 *
	public void setKlientai_patiekalai(List<KlientaiPatiekalai> klientaiPatiekalai) {
		this.klientaiPatiekalai = klientaiPatiekalai;
	}
	*/

	
	
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



