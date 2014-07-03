package com.xyz.myproject.model.controllers;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.Model.MODEL;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.projet.ListeProjet;

/**
 * COntroller mettant à jour les composantes du model lors de changement de paramètres.
 * Ex : si l'année courante change, la liste des projets change, ainsi que le projet courant
 * @author Raoul
 *
 */
public class ModelChangeController implements Observer {
	
	private Model model;
	
	

	public ModelChangeController(Model model) {
		super();
		this.model = model;
	}



	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 instanceof Model.MODEL){
			MODEL message = (MODEL)arg1;
			switch(message){
			case ANNEE : this.changeAnnee();
			}
		}
	}



	private synchronized void changeAnnee() {
		Annee annee= this.model.getAnnee();
		//MAJ dossier année
		if(annee!=null)this.model.setDossierAnnee(this.model.getDossierClient().getDossierAnnee(this.model.getAnnee()));
		//Mise à jour de la liste de projets
		if(this.model.getDossierAnnee()!=null)this.model.setListeProjets(this.model.getDossierAnnee().getProjets());
		
		//Mise à jour du projet courant
		ListeProjet projets = this.model.getListeProjets();
		if(projets!=null)this.model.setProjet((projets.size()!=0)?projets.get(0):null);
			
	}

}
