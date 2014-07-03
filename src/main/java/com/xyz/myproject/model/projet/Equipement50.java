package com.xyz.myproject.model.projet;


/**
 * Dépense d'équipement 50-90%
 */
@javax.persistence.Entity
public class Equipement50 extends DepenseAbstract implements java.io.Serializable {
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1122954584L;

	/**
	 * @generated
	 */
	private Long id;
	
	

	/**
	 * @generated
	 */
	public Equipement50() {
		
		this(0);
	}
	
	public Equipement50(double montant){
		super("Equipement 50-90%",montant);
	}
	

	/**
	 * @generated
	 */
	public String toString() {
		return "Equipement50" + " id=" + id;
	}

	/**
	 * @generated
	 */
	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	public Long getId() {
		return this.id;
	}

	/**
	 * @generated
	 */
	public void setId(Long id) {
		this.id = id;
	}
	

}