package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.GUI.presentation.MainFrameDossier;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.Projet;

/**
 * Ce controleur gère la mise à jour de l'interface lors d'un changement de
 * projet courant. Notamment, il met à jour l'onglet projet.
 * 
 * @author Raoul
 * 
 */
public class ChangeProjetController implements Observer {

	private Model model;

	private MainFrameDossier mainFrameDossier;

	public ChangeProjetController(Model model, MainFrameDossier mainFrameDossier) {
		super();
		this.model = model;
		this.mainFrameDossier = mainFrameDossier;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 == Model.MODEL.PROJET) {
			Projet projet = mainFrameDossier.getProjetModel();
			this.mainFrameDossier.majProjetPane();
			this.mainFrameDossier.getLabelProjet().setText(
					"Projet : " + ((projet != null) ? projet : "aucun"));
		}

	}

	
}
