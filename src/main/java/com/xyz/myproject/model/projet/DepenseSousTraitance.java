package com.xyz.myproject.model.projet;

import java.util.UUID;

import com.xyz.myproject.model.general.SousTraitant;

/**
 * Dépense de sous-traitance à l'échelle du projet.
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
		return "Dépenses de sous-traitance";
	}
	

	
	@Override
	public int hashCode() {
		return uuid.hashCode();
	}
}