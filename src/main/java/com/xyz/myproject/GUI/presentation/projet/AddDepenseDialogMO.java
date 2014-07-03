package com.xyz.myproject.GUI.presentation.projet;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.xyz.myproject.GUI.controller.AddDepenseMOProjetCtrl;
import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.TSProjetCanada;
import com.xyz.myproject.model.projet.TSProjetEtr;

/**
 * Boite de dialog s'ouvrant lors d'un double clic sur "main d'oeuvre" dans
 * l'onglet dépense de l'onglet projet.
 * Permet de rajouter les dépenses de traitements et salaires pour un projet.
 * @author Raoul
 * 
 */
@SuppressWarnings("serial")
public class AddDepenseDialogMO extends AddDepenseDialog<TSProjetCanada> {

	private JTextField moNonDetField, moDetField, moSoutienField,
			moNonDetEtrField, moDetEtrField;
	private JLabel totalLabel;
	private JPanel panelCentral;
	private Model model;

	// STATIC
	private static final Dimension dimensionField = new Dimension(100,
			(int) PARAMETERS_IHM.dimensionTextField.getHeight());

	public AddDepenseDialogMO(String titre, TSProjetCanada depense, Model model) {
		super(titre, depense);
		this.model = model;
		panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		this.add(panelCentral);
		this.buildPanelCentral();

		JButton validerButton = new JButton("OK");
		validerButton.addMouseListener(new AddDepenseMOProjetCtrl(this.model,
				this));
		JPanel wrapper = new JPanel(new FlowLayout());
		wrapper.add(validerButton);
		panelCentral.add(wrapper);

	}

	public void buildPanelCentral() {
		JPanel panelTitre = new JPanel();
		panelTitre.setLayout(new BoxLayout(panelTitre, BoxLayout.X_AXIS));
		panelCentral.add(panelTitre);
		JLabel titreLabel = new JLabel("Depenses en main d'oeuvre");
		titreLabel.setFont(PARAMETERS_IHM.font);
		panelTitre.add(titreLabel);
		panelCentral.add(Box.createRigidArea(new Dimension(40, 10)));

		JPanel moCaPanel = new JPanel(new GridBagLayout());
		moCaPanel.setBorder(new TitledBorder(
				BorderFactory.createEtchedBorder(),
				"Dépenses de main d'oeuvre au Canada"));
		panelCentral.add(moCaPanel);

		JLabel moNonDetLabel = new JLabel("Main d'oeuvre non déterminée :");
		JLabel moDetermineeLabel = new JLabel("Main d'oeuvre déterminée :");
		JLabel moSoutienLabel = new JLabel("Main d'oeuvre de soutien :");
		JLabel totalLegendeLabel = new JLabel("total :");

		this.moNonDetField = new JTextField();
		moNonDetField.setPreferredSize(dimensionField);
		this.moDetField = new JTextField();
		moDetField.setPreferredSize(dimensionField);
		this.moSoutienField = new JTextField();
		this.moSoutienField.setPreferredSize(dimensionField);
		this.totalLabel = new JLabel();

		GridBagConstraints cons = new GridBagConstraints();

		// moNonDetLabel
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.LINE_START;
		cons.weightx = 0;
		moCaPanel.add(moNonDetLabel, cons);
		// moDetetermineeLabel
		cons.gridy++;
		moCaPanel.add(moDetermineeLabel, cons);
		// moSoutienLabel
		cons.gridy++;
		moCaPanel.add(moSoutienLabel, cons);
		// moNonDetField
		cons.gridx = 1;
		cons.gridy = 0;
		cons.weightx = 1;
		moCaPanel.add(moNonDetField, cons);
		// moDetermineeField
		cons.gridy++;
		moCaPanel.add(moDetField, cons);
		// moSoutienField
		cons.gridy++;
		moCaPanel.add(moSoutienField, cons);

		JPanel moEtrPanel = new JPanel(new GridBagLayout());
		moEtrPanel
				.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(),
						"Dépenses en main d'oeuvre à l'étranger"));
		panelCentral.add(moEtrPanel);

		JLabel moNonDetEtrLabel = new JLabel(
				"Main d'oeuvre non déterminée à l'étranger :");
		JLabel moDetEtrLabel = new JLabel(
				"Main d'oeuvre déterminée à l'étranger :");
		this.moNonDetEtrField = new JTextField();
		moNonDetEtrField.setPreferredSize(dimensionField);
		this.moDetEtrField = new JTextField();
		moDetEtrField.setPreferredSize(dimensionField);

		cons = new GridBagConstraints();

		// moNonDetEtrLabel
		cons.anchor = GridBagConstraints.LINE_START;
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		moEtrPanel.add(moNonDetEtrLabel, cons);
		// moDetEtrLabel
		cons.gridy++;
		moEtrPanel.add(moDetEtrLabel, cons);
		// moNonDetEtrField
		cons.weightx = 1;
		cons.gridx = 1;
		cons.gridy = 0;
		moEtrPanel.add(moNonDetEtrField, cons);
		// moDetEtrField
		cons.gridy++;
		moEtrPanel.add(moDetEtrField, cons);
	}

	public void fillWith() {
		TSProjetCanada tsProjetCa = this.model.getProjet().getDepenses()
				.getTsProjetCa();
		TSProjetEtr tsProjetEtr = this.model.getProjet().getDepenses()
				.getTsProjetEtr();
		moNonDetField.setText("" + tsProjetCa.getMo_non_determinee());
		moDetField.setText("" + tsProjetCa.getMo_determinee());
		moSoutienField.setText("" + tsProjetCa.getMo_soutien());
		moNonDetEtrField.setText("" + tsProjetEtr.getMo_non_determinee());
		moDetEtrField.setText("" + tsProjetEtr.getMo_determinee());
	}

	public JTextField getMoNonDetField() {
		return moNonDetField;
	}

	public JTextField getMoDetField() {
		return moDetField;
	}

	public JTextField getMoSoutienField() {
		return moSoutienField;
	}

	public JTextField getMoNonDetEtrField() {
		return moNonDetEtrField;
	}

	public JTextField getMoDetEtrField() {
		return moDetEtrField;
	}

	public JPanel getPanelCentral() {
		return panelCentral;
	}

}
