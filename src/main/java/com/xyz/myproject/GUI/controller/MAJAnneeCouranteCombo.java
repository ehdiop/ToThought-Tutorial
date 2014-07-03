package com.xyz.myproject.GUI.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;

import com.xyz.myproject.GUI.presentation.MainFrameDossier;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.Annee;

/**
 * COntroller couplant l'année courante (instance de Model) avec l'année
 * courante du combobox de MainFrameDossier
 * 
 * @author Raoul
 * 
 */
public class MAJAnneeCouranteCombo implements ActionListener, Observer {

	private Model model;
	private MainFrameDossier mainFrameDossier;

	public MAJAnneeCouranteCombo(Model model, MainFrameDossier mainFrameDossier) {
		super();
		this.model = model;
		this.mainFrameDossier = mainFrameDossier;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == Model.MODEL.ANNEE
				&& this.mainFrameDossier.getAnneeModel() != null) {
			this.mainFrameDossier.getAnneesCombo().setSelectedItem(
					this.mainFrameDossier.getAnneeModel());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unchecked")
		JComboBox<Annee> combo = ((JComboBox<Annee>) e.getSource());
		if (!combo.getSelectedItem().equals(
				this.mainFrameDossier.getAnneeModel())) {
			this.mainFrameDossier
					.setAnneeModel((Annee) combo.getSelectedItem());
		}

	}

}
