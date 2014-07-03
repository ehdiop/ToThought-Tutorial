package com.xyz.myproject.GUI.presentation.general;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xyz.myproject.GUI.controller.FraisGenerauxController;
import com.xyz.myproject.model.Model;

/**
 * Panel des frais généraux (onglet général dans le cas du calcul par méthode traditionnelle).
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class PanelFraisGeneraux extends JPanel {

	private Model model;
	private JTextField fraisGField;
	

	// Static variables
	private static final Dimension fieldDimension = new Dimension(100, 20);

	public PanelFraisGeneraux(Model model) {

		this.model = model;

		this.setLayout(new GridLayout(3, 3, 0, 0));
		this.setBorder(null);

		this.fillGrid();
		JPanel panelCentral = this.buildPanelCentral();
		panelCentral.setBorder(BorderFactory.createEtchedBorder());
		this.add(panelCentral);
		this.fillGrid();
		this.fraisGField.getDocument().addDocumentListener(new FraisGenerauxController(model, this));

	}

	private JPanel buildPanelCentral() {
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		this.fraisGField=new JTextField();
		fraisGField.setPreferredSize(fieldDimension);
		
		//labelFraisG
		JLabel labelFraisG = new JLabel("Montant des frais généraux :");
		cons.gridx=0;
		cons.gridy=0;
		cons.weightx=0;
		cons.insets=new Insets(0,0,0,10);
		cons.anchor=GridBagConstraints.CENTER;
		panelCentral.add(labelFraisG,cons);
		
		//fraisGField
		cons.gridx=1;
		panelCentral.add(fraisGField,cons);
		
		//label$
		JLabel label$ = new JLabel("$");
		cons.gridx++;
		panelCentral.add(label$,cons);

		return panelCentral;

	}

	private void fillGrid() {
		for (int i = 0; i < 4; i++) {
			this.add(new JPanel());
		}
	}

	public JTextField getFraisGField() {
		return fraisGField;
	}

	public void setFraisGField(JTextField fraisGField) {
		this.fraisGField = fraisGField;
	}
}
