package com.xyz.myproject.model.projet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.xyz.myproject.model.general.SousTraitant;

/**
 * voir DepenseSousTraitance
 * @author Raoul
 *
 */
@javax.persistence.Entity
@Table(name="sous_traitance_ac")
public class DepenseST_RD extends DepenseSousTraitance implements
		java.io.Serializable {
	
	public static String nom;

	static{
		nom="sous traitance R&D";
	}
	private static final long serialVersionUID = -712218227L;




	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sous_traitance_ac_id")
	private Long id;

	public DepenseST_RD() {
		this(0);
	}

	public DepenseST_RD(double montant) {
		this(montant,null);
	}
	
	public DepenseST_RD(double montant, SousTraitant sousTraitant){
		super(montant, sousTraitant);
	}

	public Long getId() {
		return this.id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="sous_traitant_id")
	public SousTraitant getSousTraitant() {
		return sousTraitant;
	}

	public void setSousTraitant(SousTraitant sousTraitant) {
		this.sousTraitant = sousTraitant;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String toString() {
		return "DepensesST_RD" + " id=" + id;
	}
	

}