package com.xyz.myproject.GUI.presentation.projet;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xyz.myproject.GUI.controller.AddDepenseSTController;
import com.xyz.myproject.GUI.presentation.AddEDialog;
import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.projet.DepenseSousTraitance;

/**
 * JDialog s'ouvrant lorsque l'on clique sur le bouton "ajouter" de la jdialog AddSTDepDialog. C'est la 
 * petite interface qui permet de rajouter une dépense de sous traitance. Elle est étendue par AddDepenseSTRD
 * et AddDepenseSTSoutien. E est le type de dépense de soustraitance, F le controller à ajouter au bouton
 * ajouter selon le type de sous traitance.
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public abstract class AddDepenseST<E extends DepenseSousTraitance, F extends AddDepenseSTController<E>> extends AddEDialog {
	
	protected Window owner;
	protected JTextField montantField;
	protected JComboBox<SousTraitant> stCombo;
	protected Model model;
	protected JPanel panelCentral;
	
	
	public AddDepenseST(Window owner, Model model) {
		super();
		JPanel panelBox = new JPanel();
		this.add(panelBox);
		panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));

		this.model=model;
		this.owner = owner;
		this.setTitle("Ajout/édition d'une dépense de sous-traitance");
		this.panelCentral = new JPanel(new GridBagLayout());
		panelBox.add(panelCentral);
		this.buildPanel();
		JButton valider = new JButton("valider");
		valider.setEnabled(this.model.getDossierClient().getSousTraitants().size()>0);
		JPanel wrapper = new JPanel(new FlowLayout());
		wrapper.add(valider);
		panelBox.add(wrapper);
		valider.addActionListener(getController());
		
		
	}
	
	public abstract F getController();


	private void buildPanel() {
		JLabel stLabel = new JLabel("sous-traitant :");
		JLabel montantLabel = new JLabel("montant");
		JLabel dollar = new JLabel("$");
		
		this.montantField=new JTextField();
		this.montantField.setPreferredSize(PARAMETERS_IHM.dimensionSmallTextField);
		this.stCombo = new JComboBox<SousTraitant>(new Vector<SousTraitant>(this.model.getDossierClient().getSousTraitants().getList()));
		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx=0;
		cons.gridy=0;
		cons.anchor=GridBagConstraints.LINE_START;
		cons.weightx=0;
		cons.gridwidth=1;
		cons.insets = new Insets(3,0,0,0);
		
		//stLabel
		panelCentral.add(stLabel,cons);
		//montantLabel
		cons.gridy++;
		panelCentral.add(montantLabel,cons);
		//stCombo
		cons.gridx=1;
		cons.gridy=0;
		cons.weightx=0;
		panelCentral.add(this.stCombo,cons);
		//montantField
		cons.gridy++;
		cons.weightx=0;
		panelCentral.add(this.montantField,cons);
		//dollar
		cons.weightx=1;
		cons.gridx++;
		panelCentral.add(dollar,cons);
	}


	public JTextField getMontantField() {
		return montantField;
	}


	

	public JComboBox<SousTraitant> getStCombo() {
		return stCombo;
	}


	
	
	
	

}
