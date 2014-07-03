package com.xyz.myproject.model.projet;


/**
 * Les d�penses de mat�riel consomm�.
 */
@javax.persistence.Entity
public class MaterielConsomme extends DepenseAbstract implements java.io.Serializable {
	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1590052900L;

	public static String nom;

	
	
	/**
	 * @generated
	 */
	private Long id;

	

	/**
	 * @generated
	 */
	public MaterielConsomme() {
		this(0);
	}
	
	public MaterielConsomme(double montant){
		super("Mat�riel consomm�",montant);
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
	
	/**
	 * @generated
	 */
	public String toString() {
		return "MaterielConsomme" + " id=" + id;
	}
}