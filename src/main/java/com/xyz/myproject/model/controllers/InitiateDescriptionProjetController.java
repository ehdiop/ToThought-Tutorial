package com.xyz.myproject.model.controllers;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.projet.InfoGeneralesProjet.INFOSPROJET;
import com.xyz.myproject.model.projet.Projet;
import com.xyz.myproject.model.sectionsBC.DescriptionTechnique;

/**
 * Controller initialisant l'objet description (SectionB ou SectionC) en
 * instance de Projet, lors d'un changement de l'objet ButTravaux en instance de
 * InformationsGeneralesProjet
 * 
 * @author Raoul
 * 
 */
public class InitiateDescriptionProjetController implements Observer {

	private Projet projet;

	public InitiateDescriptionProjetController(Projet projet) {
		super();
		this.projet = projet;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 == INFOSPROJET.BUT_TRAVAUX) {
			this.projet.getInformationsGenerales().setDescTech(DescriptionTechnique.getDescription(this.projet.getInformationsGenerales().getButTravaux()));
		}
	}

}
