package com.xyz.myproject.GUI.presentation.projet;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.model.projet.DepenseAbstract;

/**
 * Fenêtre d'ajout d'une dépense s'ouvrant pour les dépenses simples, du type "matériel consommé" ou 
 * "équipement + 90%".
 * @author Raoul
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class AddDepenseDialogSimple<E extends DepenseAbstract> extends
		AddDepenseDialog<E> {


	private JTextField montantField;

	public AddDepenseDialogSimple(String titre, E depense) {
		super(titre,depense);
		JPanel panelCentral = new JPanel();
		this.add(panelCentral);
		panelCentral.setLayout(new GridBagLayout());
		JLabel legendeLabel = new JLabel("dépense de " + this.titre);
		this.montantField = new JTextField();
		this.montantField.setPreferredSize(new Dimension(100,
				(int) PARAMETERS_IHM.dimensionTextField.getHeight()));
		JLabel montantLabel = new JLabel("montant de la dépense :");
		JLabel dollar = new JLabel("$");
		JButton ok = new JButton("ok");

		GridBagConstraints cons = new GridBagConstraints();
		// legendeLabel
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.LINE_START;
		cons.weightx = 0;
		panelCentral.add(legendeLabel, cons);
		// montantLabel
		cons.gridy++;
		panelCentral.add(montantLabel, cons);
		//montantField
		cons.gridx=1;
		panelCentral.add(montantField,cons);
		// dollarLabel
		cons.gridx=2;
		panelCentral.add(dollar,cons);

	}

	public JTextField getMontantField() {
		return montantField;
	}

	public void setMontantField(JTextField montantField) {
		this.montantField = montantField;
	}
	
	public void setMontantField(double montant){
		this.montantField.setText(""+montant);
	}

}
