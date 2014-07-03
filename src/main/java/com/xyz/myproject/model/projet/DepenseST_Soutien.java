package com.xyz.myproject.model.projet;

import com.xyz.myproject.model.general.SousTraitant;


/**
 * voir DepenseSousTraitance
 * @author Raoul
 *
 */
@javax.persistence.Entity
public class DepenseST_Soutien extends DepenseSousTraitance implements
		java.io.Serializable {
	public static String nom;

	static{
		nom="Sous traitance de soutien";
	}
	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1683371100L;
	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	public DepenseST_Soutien() {
		this(0);
	}
	
	public DepenseST_Soutien(double montant){
		this(montant, null);
	}
	
	public DepenseST_Soutien(double montant, SousTraitant sousTraitant){
		super(montant, sousTraitant);
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
		return "DepensesST_Soutien" + " id=" + id;
	}
}