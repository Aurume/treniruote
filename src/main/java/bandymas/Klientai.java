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
	
	private Integer flagVartojaAlkoholi;
	
	private Integer flagAlergRiesutai;
	
	private Integer flagAlergPieno;
	
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
	 * @return the flagVartojaAlkoholi
	 */
	public Integer getFlagVartojaAlkoholi() {
		return flagVartojaAlkoholi;
	}

	/**
	 * @param flagVartojaAlkoholi the flagVartojaAlkoholi to set
	 */
	public void setFlagVartojaAlkoholi(Integer flagVartojaAlkoholi) {
		this.flagVartojaAlkoholi = flagVartojaAlkoholi;
	}

	/**
	 * @return the flagAlergRiesutai
	 */
	public Integer getFlagAlergRiesutai() {
		return flagAlergRiesutai;
	}

	/**
	 * @param flagAlergRiesutai the flagAlergRiesutai to set
	 */
	public void setFlagAlergRiesutai(Integer flagAlergRiesutai) {
		this.flagAlergRiesutai = flagAlergRiesutai;
	}

	/**
	 * @return the flagAlergPieno
	 */
	public Integer getFlagAlergPieno() {
		return flagAlergPieno;
	}

	/**
	 * @param flagAlergPieno the flagAlergPieno to set
	 */
	public void setFlagAlergPieno(Integer flagAlergPieno) {
		this.flagAlergPieno = flagAlergPieno;
	}

	/**
	 * @return the klientaiPatiekalai
	 */
	public Iterable<KlientaiPatiekalai> getKlientaiPatiekalai() {
		return klientaiPatiekalai;
	}

	/**
	 * @param klientaiPatiekalai the klientaiPatiekalai to set
	 */
	public void setKlientaiPatiekalai(List<KlientaiPatiekalai> klientaiPatiekalai) {
		this.klientaiPatiekalai = klientaiPatiekalai;
	}
	
	
}
