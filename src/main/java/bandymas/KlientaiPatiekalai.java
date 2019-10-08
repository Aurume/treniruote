package bandymas;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
/**
 * @author User
 *
 */
@Entity
public class KlientaiPatiekalai {
	private static final long serialVersionUID = -6790693372846798580L;  //kam sitas skaicius reikalingas issiaiskinti???
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
    
	@Column(name="klientai_id")
	private Integer klientaiId;
	
	@Column(name="patiekalai_id")
	private Integer patiekalaiId;
	
	@JsonIgnoreProperties("klientaiPatiekalai")
    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
    private Klientai klientai;
	
	// @JsonIgnoreProperties("patiekalu_produktai")
    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
    private Patiekalai patiekalai;


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
	 * @return the klientaiId
	 */
	public Integer getKlientaiId() {
		return klientaiId;
	}

	/**
	 * @param klientai_id the klientaiId to set
	 */
	public void setKlientaiId(Integer klientaiId) {
		this.klientaiId = klientaiId;
	}

	/**
	 * @return the patiekalai_id
	 */
	public Integer getPatiekalaiId() {
		return patiekalaiId;
	}

	/**
	 * @param patiekalai_id the patiekalai_id to set
	 */
	public void setPatiekalaiId(Integer patiekalai_id) {
		this.patiekalaiId = patiekalai_id;
	}

	/**
	 * @return the klientai
	 */
	public Klientai getKlientai() {
		return klientai;
	}

	/**
	 * @param klientai the klientai to set
	 */
	public void setKlientai(Klientai klientai) {
		this.klientai = klientai;
	}

	/**
	 * @return the patiekalai
	 */
	public Patiekalai getPatiekalai() {
		return patiekalai;
	}

	/**
	 * @param patiekalai the patiekalai to set
	 */
	public void setPatiekalai(Patiekalai patiekalai) {
		this.patiekalai = patiekalai;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

