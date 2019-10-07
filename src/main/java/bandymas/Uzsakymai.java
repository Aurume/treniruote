package bandymas;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
/**
 * @author User
 *
 */
@Entity
public class Uzsakymai {
	private static final long serialVersionUID = -6790693372846798580L;  //kam sitas skaicius reikalingas issiaiskinti???
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	

	private Integer id;
    
	private Integer klientai_id;
	private Integer meniu_id;
	
	@JsonIgnoreProperties("uzsakymai")
    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
    private Uzsakymai uzsakymai;

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
	 * @return the klientai_id
	 */
	public Integer getKlientai_id() {
		return klientai_id;
	}

	/**
	 * @param klientai_id the klientai_id to set
	 */
	public void setKlientai_id(Integer klientai_id) {
		this.klientai_id = klientai_id;
	}

	/**
	 * @return the meniu_id
	 */
	public Integer getMeniu_id() {
		return meniu_id;
	}

	/**
	 * @param meniu_id the meniu_id to set
	 */
	public void setMeniu_id(Integer meniu_id) {
		this.meniu_id = meniu_id;
	}

	/**
	 * @return the uzsakymai
	 */
	public Uzsakymai getUzsakymai() {
		return uzsakymai;
	}

	/**
	 * @param uzsakymai the uzsakymai to set
	 */
	public void setUzsakymai(Uzsakymai uzsakymai) {
		this.uzsakymai = uzsakymai;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
