package com.xyz.myproject.model.projet;


/**
 * Les d�penses de mat�riel transform�.
 */
@javax.persistence.Entity
public class MaterielTransforme extends DepenseAbstract implements
		java.io.Serializable {
	public static String nom;

	
	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1938166966L;

	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	public MaterielTransforme() {
		this(0);
	}
	
	public MaterielTransforme(double montant){
		super("Mat�riel transform�", montant);
	}

	/**
	 * @generated
	 */
	public String toString() {
		return "MaterielTransforme" + " id=" + id;
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