package com.xyz.myproject.model.projet;


/**
 * Dépenses d'équipement >90%
 */
@javax.persistence.Entity
public class Equipement90 extends DepenseAbstract implements java.io.Serializable {
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1122954460L;
	public static String nom;

	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	public Equipement90() {
		this(0);
	}
	
	public Equipement90(double montant){
		super("Equipement 90% et plus",montant);
	}

	/**
	 * @generated
	 */
	public String toString() {
		return "Equipement90" + " id=" + id;
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