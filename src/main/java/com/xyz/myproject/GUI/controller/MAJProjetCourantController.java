package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.EVENT_DEP;
import com.xyz.myproject.model.projet.ListeProjet;
import com.xyz.myproject.model.projet.Projet;

/**
 * Met à jour le projet courant de la MainFrameDossier lors de l'ajout d'un
 * projet à la liste des projets, avec le nouveau projet ajouté
 * 
 * @author Raoul
 * 
 */
public class MAJProjetCourantController implements Observer {

	private Model model;
	private ListeProjet listeProjet;

	

	public MAJProjetCourantController(Model model, ListeProjet listeProjet) {
		super();
		this.model = model;
		this.listeProjet = listeProjet;
	}



	@Override
	public void update(Observable arg0, Object message) {
		if(message == EVENT_DEP.CHGT_PROJET){
			Projet newCourant = (this.listeProjet.size()>0)?this.listeProjet.get(this.listeProjet.size()-1):null;
			this.model.setProjet(newCourant);
		}
	}

}
