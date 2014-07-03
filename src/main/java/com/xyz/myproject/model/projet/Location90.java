package com.xyz.myproject.model.projet;


/**
 * Location > 90%
 */
@javax.persistence.Entity
public class Location90 extends DepenseAbstract implements java.io.Serializable {
	public static String nom;

	
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1651660858L;

	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	public Location90() {
		this(0);
	}
	
	public Location90(double montant){
		super("Location 90% et plus",montant);
	}

	/**
	 * @generated
	 */
	public String toString() {
		return "Location90" + " id=" + id;
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