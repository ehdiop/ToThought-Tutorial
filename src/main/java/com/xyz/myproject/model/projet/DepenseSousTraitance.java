package com.xyz.myproject.model.projet;

import java.util.UUID;

import com.xyz.myproject.model.general.SousTraitant;

/**
 * D�pense de sous-traitance � l'�chelle du projet.
 */
public class DepenseSousTraitance extends
		com.xyz.myproject.model.projet.DepenseAbstract {

	protected SousTraitant sousTraitant;
	protected UUID uuid;

	protected DepenseSousTraitance() {
		this(0, null);
	}

	protected DepenseSousTraitance(double montant, SousTraitant sousTraitant) {
		this.setMontant(montant);
		this.setSousTraitant(sousTraitant);
		this.uuid=UUID.randomUUID();
	}

	public SousTraitant getSousTraitant() {
		return sousTraitant;
	}

	public void setSousTraitant(SousTraitant sousTraitant) {
		this.sousTraitant = sousTraitant;
	}

	public String toString() {
		return "D�penses de sous-traitance";
	}
	

	
	@Override
	public int hashCode() {
		return uuid.hashCode();
	}
}