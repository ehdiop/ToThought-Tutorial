package com.xyz.myproject.model.general;



/**
 *Dépense de sous-traitance de soutien pour le dossier année.
 */
@javax.persistence.Entity
public class SousTraitanceSoutien extends SousTraitanceGenerale implements
		java.io.Serializable {
	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1820337070L;

	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	public SousTraitanceSoutien() {
		this(0);
	}
	
	public SousTraitanceSoutien(double montant){
		this.setMontant(montant);
	}

	/**
	 * @generated
	 */
	public String toString() {
		return "SousTraitanceSoutien" + " id=" + id;
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