package bandymas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;

@Entity
public class Klientai {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String vardas;
	
	private String pavarde;
	
	private Integer savybVartojaAlkoholi;
	
	private Integer savybAlergRiesutai;
	
	private Integer savybAlergPieno;
	
	 @JsonIgnoreProperties("klientai")    
	 @OneToMany(mappedBy="klientai",cascade=CascadeType.ALL)
	 private List<KlientaiPatiekalai> klientaiPatiekalai;  //uzsakymai ar kliento info ar kas cia turetu but???????????
	
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
	 * @return the vardas
	 */
	public String getVardas() {
		return vardas;
	}

	/**
	 * @param vardas the vardas to set
	 */
	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	/**
	 * @return the pavarde
	 */
	public String getPavarde() {
		return pavarde;
	}

	/**
	 * @param pavarde the pavarde to set
	 */
	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}

	/**
	 * @return the savybVartojaAlkoholi
	 */
	public Integer getSavybVartojaAlkoholi() {
		return savybVartojaAlkoholi;
	}

	/**
	 * @param savybVartojaAlkoholi the savybVartojaAlkoholi to set
	 */
	public void setSavybVartojaAlkoholi(Integer savybVartojaAlkoholi) {
		this.savybVartojaAlkoholi = savybVartojaAlkoholi;
	}

	/**
	 * @return the savybAlergRiesutai
	 */
	public Integer getSavybAlergRiesutai() {
		return savybAlergRiesutai;
	}

	/**
	 * @param savybAlergRiesutai the savybAlergRiesutai to set
	 */
	public void setSavybAlergRiesutai(Integer savybAlergRiesutai) {
		this.savybAlergRiesutai = savybAlergRiesutai;
	}

	/**
	 * @return the savybAlergPieno
	 */
	public Integer getSavybAlergPieno() {
		return savybAlergPieno;
	}

	/**
	 * @param savybAlergPieno the savybAlergPieno to set
	 */
	public void setSavybAlergPieno(Integer savybAlergPieno) {
		this.savybAlergPieno = savybAlergPieno;
	}
	
	
	public Iterable<KlientaiPatiekalai> getKlientaiPatiekalai() {
		return klientaiPatiekalai;
	}

	public void setKlientaiPatiekalai(List<KlientaiPatiekalai> klientaiPatiekalai) {
		this.klientaiPatiekalai = klientaiPatiekalai;
	}

	
	


	
	
	
}
