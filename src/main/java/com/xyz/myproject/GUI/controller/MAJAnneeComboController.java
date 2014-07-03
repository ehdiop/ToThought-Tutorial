package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;

import com.xyz.myproject.GUI.presentation.MainFrameDossier;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.projet.DossierClient.DOSSIERCLIENT;

/**
 * Controller mettant à jour la JComboBox de mainFrameDossier lors de l'ajout
 * d'une nouvelle année. Le update est appelé lorsqu'un nouveau DossierAnnee est
 * ajouté à DossierClient
 * 
 * @author Raoul
 * 
 */
public class MAJAnneeComboController implements Observer {

	private MainFrameDossier mainFrameDossier;
	private Model model;

	public MAJAnneeComboController(MainFrameDossier mainFrameDossier,
			Model model) {
		super();
		this.mainFrameDossier = mainFrameDossier;
		this.model = model;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == DOSSIERCLIENT.ANNEE) {
			this.mainFrameDossier.getAnneesCombo().setModel(
					new DefaultComboBoxModel<Annee>(this.model
							.getDossierClient().getAnnees()));
		
		}
		
		if(this.model.getAnnee()!=null){
			this.mainFrameDossier.getAnneesCombo().setSelectedItem(this.model.getAnnee());
		}
	}

}
