package com.xyz.myproject.model.projet;


/**
 *Location entre 50 et 90%
 */
@javax.persistence.Entity
public class Location50 extends DepenseAbstract implements java.io.Serializable {
	public static String nom;

	
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1651660982L;

	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	public Location50() {
		this(0);
	}
	
	public Location50(double montant){
		super("Location 50-90%",montant);
	}

	/**
	 * @generated
	 */
	public String toString() {
		return "Location50" + " id=" + id;
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