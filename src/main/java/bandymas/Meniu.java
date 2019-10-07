package bandymas;

import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Meniu {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	 
	 private String pav;
	 
	 private Integer savybYraRiešutai;
	 
	 private Integer savybYraPienoProd;
	 
	 /*
	 @OneToMany(mappedBy = "patiekalai",cascade = CascadeType.ALL)
	 private List<Patiekalu_produktai> patiekalu_produktai;

	 @OneToMany(mappedBy = "patiekalai",cascade = CascadeType.ALL)
	private List<Uzsakymai> uzsakymai;    // cia pridejus sujungia patiekalus su uzsakymais.
	*/
	 

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
	 * @return the savybYraRiešutai
	 */
	public Integer getSavybYraRiešutai() {
		return savybYraRiešutai;
	}

	/**
	 * @param savybYraRiešutai the savybYraRiešutai to set
	 */
	public void setSavybYraRiešutai(Integer savybYraRiešutai) {
		this.savybYraRiešutai = savybYraRiešutai;
	}

	/**
	 * @return the savybYraPienoProd
	 */
	public Integer getSavybYraPienoProd() {
		return savybYraPienoProd;
	}

	/**
	 * @param savybYraPienoProd the savybYraPienoProd to set
	 */
	public void setSavybYraPienoProd(Integer savybYraPienoProd) {
		this.savybYraPienoProd = savybYraPienoProd;
	}

	/* jeigu reikes sitos dalies
	
	public List<Patiekalu_produktai> getPatiekalu_produktai() {
		
		return patiekalu_produktai;
	}
	public void setPatiekalu_produktai (List<Patiekalu_produktai> patiekalu_produktai) {
		
		this.patiekalu_produktai = patiekalu_produktai;
	}
	 
	*/
}



