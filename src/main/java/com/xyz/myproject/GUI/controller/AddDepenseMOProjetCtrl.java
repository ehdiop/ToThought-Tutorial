package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.GUI.presentation.projet.AddDepenseDialogMO;
import com.xyz.myproject.model.Model;

/**
 * Mise à jour de l'objet DepenseProjet en instance de projet, avec les valeurs de la JDialog
 * 
 * @author Raoul
 * 
 */
public class AddDepenseMOProjetCtrl extends MouseAdapter {
	private Model model;
	private AddDepenseDialogMO dialog;
	
	

	public AddDepenseMOProjetCtrl(Model model, AddDepenseDialogMO dialog) {
		super();
		this.model = model;
		this.dialog = dialog;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			double mo_determinee = Double.parseDouble(dialog.getMoDetField()
					.getText());
			double mo_non_determinee = Double.parseDouble(dialog
					.getMoNonDetField().getText());
			double mo_determinee_etr = Double.parseDouble(dialog
					.getMoDetEtrField().getText());
			double mo_non_determinee_etr = Double.parseDouble(dialog
					.getMoNonDetEtrField().getText());
			double mo_soutien = Double.parseDouble(dialog.getMoSoutienField()
					.getText());

			this.model.getProjet().getDepenses()
					.setMoDetermineeCa(mo_determinee);
			this.model.getProjet().getDepenses()
					.setMoNonDetermineeCa(mo_non_determinee);
			this.model.getProjet().getDepenses()
					.setMoDetermineeEtr(mo_determinee_etr);
			this.model.getProjet().getDepenses()
					.setMoNonDetermineeEtr(mo_non_determinee_etr);
			this.model.getProjet().getDepenses().setMoSoutien(mo_soutien);
			this.dialog.dispose();
		} catch (NumberFormatException ex) {
			JOptionPane
					.showMessageDialog(
							dialog,
							PARAMETERS_IHM.formatException,
							"Problème de format", JOptionPane.WARNING_MESSAGE);
		}

	}
}
