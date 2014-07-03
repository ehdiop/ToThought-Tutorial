package com.xyz.myproject.GUI.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;

import com.xyz.myproject.GUI.presentation.MainFrameDossier;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.Projet;

/**
 * Controle le couplage entre le projet courant du modèle (Model) de
 * MainFrameDossier, avec l'index sélectionné de la ComboBox.
 * 
 * @author Raoul
 * 
 */
public class MAJProjetCourantCombo implements ActionListener, Observer {

	private MainFrameDossier mainFrameDossier;

	public MAJProjetCourantCombo(MainFrameDossier mainFrameDossier, Model model) {
		super();
		this.mainFrameDossier = mainFrameDossier;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 == Model.MODEL.PROJET && this.mainFrameDossier.getModel().getProjet()!=null) {
			this.mainFrameDossier.getProjetsCombo().setSelectedItem(
					this.mainFrameDossier.getModel().getProjet());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unchecked")
		JComboBox<Projet> combo = ((JComboBox<Projet>) e.getSource());
		if (!combo.getSelectedItem().equals(
				this.mainFrameDossier.getProjetModel())) {
			this.mainFrameDossier.setProjetModel((Projet)combo.getSelectedItem());
		}
	}

}
