package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;

import com.xyz.myproject.GUI.presentation.MainFrameDossier;
import com.xyz.myproject.model.projet.EVENT_DEP;
import com.xyz.myproject.model.projet.ListeProjet;
import com.xyz.myproject.model.projet.Projet;

/**
 * COntroller gérant la mise à jour de la combo affichant les projets, lors de
 * l'ajout d'un projet à ListeProjet ou du changement de la liste de projet
 * 
 * @author Raoul
 * 
 */
public class MAJProjetComboController implements Observer {

	private MainFrameDossier mainFrame;

	public MAJProjetComboController(MainFrameDossier mainFrame,
			ListeProjet projets) {
		super();
		this.mainFrame = mainFrame;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == EVENT_DEP.CHGT_PROJET) {
			this.mainFrame.getProjetsCombo().setModel(
					new DefaultComboBoxModel<Projet>(this.mainFrame
							.getDossierAnneeModel().getProjets().getList()
							.toArray(new Projet[0])));
			if(this.mainFrame.getProjetModel()!=null){
				this.mainFrame.getProjetsCombo().setSelectedItem(this.mainFrame.getProjetModel());
			}
		}

	}

}
