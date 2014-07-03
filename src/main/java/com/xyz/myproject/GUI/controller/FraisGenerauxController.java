package com.xyz.myproject.GUI.controller;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.xyz.myproject.GUI.presentation.general.PanelFraisGeneraux;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.FraisGenerauxTrad;

/**
 * Controller de la JTextField des frais généraux. Pas pratique pour
 * l'utilisateur. A remplacer (voir word "note développeurs")
 * 
 * @author Raoul
 * 
 */
public class FraisGenerauxController implements DocumentListener {

	private Model model;

	private PanelFraisGeneraux panel;

	public FraisGenerauxController(Model model, PanelFraisGeneraux panel) {
		super();
		this.model = model;
		this.panel = panel;
	}

	public void updateModel() {
		FraisGenerauxTrad fraisG = ((FraisGenerauxTrad) this.model
				.getDossierAnnee().getInfos().getDepenses().getFraisGeneraux());
		String tmp = this.panel.getFraisGField().getText();
		if (!tmp.equals("" + fraisG.getMontant())) {
			if (tmp == null || tmp.trim().equals("")) {
				fraisG.setMontant(0);
			} else {
				writeNonEmptyValue();
			}
		}

	}

	private void writeNonEmptyValue() {
		FraisGenerauxTrad fraisG = ((FraisGenerauxTrad) this.model
				.getDossierAnnee().getInfos().getDepenses().getFraisGeneraux());
		String tmp = this.panel.getFraisGField().getText();

		String newCar = tmp.substring(tmp.length() - 1);

		try {
			Double.valueOf(newCar);
			double montant = Double.parseDouble(this.panel.getFraisGField()
					.getText());
			fraisG.setMontant(montant);
		} catch (NumberFormatException e) {
			this.fillPreviousValue();
		}
	}

	private void fillPreviousValue() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				FraisGenerauxController that = FraisGenerauxController.this;
				FraisGenerauxTrad fraisG = ((FraisGenerauxTrad) that.model
						.getDossierAnnee().getInfos().getDepenses()
						.getFraisGeneraux());
				;
				that.panel.getFraisGField().setText("" + fraisG.getMontant());

			}
		});
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateModel();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateModel();

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateModel();
	}

	public Model getModel() {
		return model;
	}

	public PanelFraisGeneraux getPanel() {
		return panel;
	}

}
