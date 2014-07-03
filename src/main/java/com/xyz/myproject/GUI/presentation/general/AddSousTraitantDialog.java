package com.xyz.myproject.GUI.presentation.general;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.xyz.myproject.GUI.controller.AddSousTraitantValiderController;
import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.model.general.Province;
import com.xyz.myproject.model.general.TypeEntite;
import com.xyz.myproject.model.general.TypeST;
import com.xyz.myproject.model.projet.DossierClient;

/**
 * Fenêtre de dialogue d'ajout d'un sous traitant.
 * 
 * @author Raoul
 * 
 */
@SuppressWarnings("serial")
public class AddSousTraitantDialog extends JDialog {

	private JTextField nomField, descriptionField, adresseField, villeField,
			cpField, neField, nProvField, neqField;
	private JComboBox<Province> provinceCombo;
	private JComboBox<TypeST> typeST;
	private JComboBox<TypeEntite> typeEntiteCombo;
	private Container pane;
	private JPanel panelCentral;
	private JRadioButton ouiField, nonField;

	// Dimensions
	private static final Dimension panelCentralDim = new Dimension(380, 330);
	private static final Dimension sidesMargin = new Dimension(10, 10);
	private static final Dimension topBotMargin = new Dimension(10, 10);
	private static final Dimension dimensionField = PARAMETERS_IHM.dimensionTextField;

	public AddSousTraitantDialog(boolean edit, JTable table, DossierClient model) {
		super();
		this.setTitle("Ajout d'un sous-traitant");
		this.pane = this.getContentPane();
		this.pane.setLayout(new BorderLayout());
		this.pane.add(Box.createRigidArea(topBotMargin), BorderLayout.WEST);
		this.pane.add(Box.createRigidArea(topBotMargin), BorderLayout.EAST);
		this.pane.add(Box.createRigidArea(sidesMargin), BorderLayout.NORTH);
		this.pane.add(Box.createRigidArea(sidesMargin), BorderLayout.SOUTH);

		// Panneau central contenant les deux panneaux (nécessaire pour ensuite
		// mettre au centre
		// de la BorderLayout et ajouter des marges
		this.panelCentral = new JPanel();
		this.panelCentral.setPreferredSize(panelCentralDim);
		this.pane.add(panelCentral);
		this.panelCentral.setLayout(new BoxLayout(panelCentral,
				BoxLayout.Y_AXIS));

		this.buildPanneauHaut();
		this.buildPanneauBas();
		JButton ok = new JButton("0K");
		AddSousTraitantValiderController controllerGeneral = new AddSousTraitantValiderController(
				table, edit, this, model);
		ok.addMouseListener(controllerGeneral);
		model.getSousTraitants().addObserver(controllerGeneral);
		JPanel wrapper = new JPanel(new FlowLayout());
		wrapper.add(ok);
		this.panelCentral.add(wrapper);

	}

	private void buildPanneauHaut() {
		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new TitledBorder(
				BorderFactory.createEtchedBorder(), "Informations générales"));
		this.panelCentral.add(panelHaut);
		panelHaut.setLayout(new GridBagLayout());

		JLabel nomLabel = new JLabel("Nom du sous-traitant :");
		JLabel descriptionLabel = new JLabel("Description :");
		JLabel adresseLabel = new JLabel("Adresse :");
		JLabel villeLabel = new JLabel("Ville :");
		JLabel provinceLabel = new JLabel("Province :");
		JLabel cpLabel = new JLabel("Code postal :");

		this.nomField = new JTextField();
		this.nomField.setPreferredSize(PARAMETERS_IHM.dimensionTextField);
		this.descriptionField = new JTextField();
		this.descriptionField
				.setPreferredSize(PARAMETERS_IHM.dimensionTextField);
		this.adresseField = new JTextField();
		this.adresseField.setPreferredSize(PARAMETERS_IHM.dimensionTextField);
		this.villeField = new JTextField();
		this.villeField.setPreferredSize(PARAMETERS_IHM.dimensionTextField);
		this.adresseField.setPreferredSize(PARAMETERS_IHM.dimensionTextField);
		this.provinceCombo = new JComboBox<Province>(Province.values());
		this.provinceCombo.setPreferredSize(PARAMETERS_IHM.dimensionTextField);
		this.cpField = new JTextField();
		this.cpField.setPreferredSize(PARAMETERS_IHM.dimensionTextField);

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.weightx = 0.33;
		cons.weighty = 0.33;
		cons.anchor = GridBagConstraints.LINE_START;

		// nomLabel
		panelHaut.add(nomLabel, cons);

		// nomField
		cons.gridx = 1;
		cons.gridwidth = 4;
		panelHaut.add(nomField, cons);

		// descriptionLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(descriptionLabel, cons);

		// descriptionField
		cons.gridx = 1;
		cons.gridwidth = 4;
		panelHaut.add(descriptionField, cons);

		// adresseLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(adresseLabel, cons);

		// adresseField
		cons.gridx = 1;
		cons.gridwidth = 4;
		panelHaut.add(adresseField, cons);

		// villeLabel
		cons.gridx = 0;
		cons.gridwidth = 1;
		cons.gridy++;
		panelHaut.add(villeLabel, cons);

		// villeField
		cons.gridx = 1;
		cons.gridwidth = 4;
		panelHaut.add(villeField, cons);

		// provinceLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(provinceLabel, cons);

		// provinceCombo
		cons.gridx = 1;
		cons.gridwidth = 4;
		panelHaut.add(provinceCombo, cons);

		// cpLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(cpLabel, cons);

		// cpField
		cons.gridx = 1;
		cons.gridwidth = 4;
		panelHaut.add(cpField, cons);
	}

	private void buildPanneauBas() {
		JPanel panelBas = new JPanel();
		this.panelCentral.add(panelBas);
		panelBas.setLayout(new GridBagLayout());
		panelBas.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(),
				"Informations financières"));
		this.neField = new JTextField();
		this.neField.setPreferredSize(dimensionField);
		this.nProvField = new JTextField();
		this.nProvField.setPreferredSize(dimensionField);
		this.neqField = new JTextField();
		this.neqField.setPreferredSize(dimensionField);
		this.typeST = new JComboBox<TypeST>(TypeST.values());
		this.typeEntiteCombo = new JComboBox<TypeEntite>(TypeEntite.values());
		this.typeEntiteCombo.setPreferredSize(dimensionField);
		this.ouiField = new JRadioButton();
		this.nonField = new JRadioButton();
		this.nonField.setSelected(true);

		JLabel typeLabel = new JLabel("Type :");
		JLabel typeEntiteLabel = new JLabel("De quel type d'entité s'agit-il ?");

		JLabel depLabel = new JLabel("Lien de dépendance :");
		JLabel ouiLabel = new JLabel("oui");
		JLabel nonLabel = new JLabel("non");
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(this.ouiField);
		buttonGroup.add(this.nonField);
		JLabel neLabel = new JLabel("Numéro d'entreprise :");
		JLabel nProvLabel = new JLabel("Numéro d'identification provincial :");
		JLabel neqLabel = new JLabel("Numéro d'entreprise du Québec :");

		GridBagConstraints cons = new GridBagConstraints();
		cons.anchor = GridBagConstraints.LINE_START;
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0.33;
		cons.weighty = 0.33;
		cons.gridwidth = 1;

		// typeLabel
		panelBas.add(typeLabel, cons);

		// typeCombo
		cons.gridx = 1;
		cons.gridwidth = 4;
		panelBas.add(this.typeST, cons);

		// typeEntiteLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelBas.add(typeEntiteLabel, cons);

		// typeEntiteCombo
		cons.gridx = 1;
		cons.gridwidth = 4;
		;
		panelBas.add(this.typeEntiteCombo, cons);

		// depLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelBas.add(depLabel, cons);

		// ouiLabel
		cons.gridx = 1;
		cons.weightx = 0;
		panelBas.add(ouiLabel, cons);

		// ouiField
		cons.gridx = 2;
		panelBas.add(ouiField, cons);

		// nonLabel
		cons.gridx = 3;
		panelBas.add(nonLabel, cons);

		// nonField
		cons.gridx = 4;
		panelBas.add(nonField, cons);

		// neLabel
		cons.weightx = 0.33;
		cons.gridy++;
		cons.gridx = 0;
		cons.gridwidth = 1;
		panelBas.add(neLabel, cons);

		// neField
		cons.gridx = 1;
		cons.gridwidth = 4;
		panelBas.add(neField, cons);

		// nProvLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelBas.add(nProvLabel, cons);

		// nProvField
		cons.gridx = 1;
		cons.gridwidth = 4;
		panelBas.add(nProvField, cons);

		// neqLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelBas.add(neqLabel, cons);

		// neqField
		cons.gridx = 1;
		cons.gridwidth = 4;
		panelBas.add(neqField, cons);

	}

	public JTextField getNomField() {
		return nomField;
	}

	public void setNomField(String nomField) {
		this.nomField.setText(nomField);
	}

	public JTextField getDescriptionField() {
		return descriptionField;
	}

	public void setDescriptionField(String descriptionField) {
		this.descriptionField.setText(descriptionField);
	}

	public JTextField getAdresseField() {
		return adresseField;
	}

	public void setAdresseField(String adresseField) {
		this.adresseField.setText(adresseField);
	}

	public JTextField getVilleField() {
		return villeField;
	}

	public void setVilleField(String villeField) {
		this.villeField.setText(villeField);
	}

	public JTextField getCpField() {
		return cpField;
	}

	public void setCpField(String cpField) {
		this.cpField.setText(cpField);
	}

	public JTextField getNeField() {
		return neField;
	}

	public void setNeField(String neField) {
		this.neField.setText(neField);
	}

	public JTextField getnProvField() {
		return nProvField;
	}

	public void setnProvField(String nProvField) {
		this.nProvField.setText(nProvField);
	}

	public JTextField getNeqField() {
		return neqField;
	}

	public void setNeqField(String neqField) {
		this.neqField.setText(neqField);
	}

	public JComboBox<Province> getProvinceCombo() {
		return provinceCombo;
	}

	public void setProvinceCombo(Province province) {
		this.provinceCombo.setSelectedItem(province);
	}

	public JComboBox<TypeST> getTypeST() {
		return typeST;
	}

	public void setTypeST(TypeST type) {
		this.typeST.setSelectedItem(type);
	}

	public JRadioButton getOuiField() {
		return ouiField;
	}

	public void setOuiField(boolean ouiField) {
		this.ouiField.setSelected(ouiField);
	}

	public JRadioButton getNonField() {
		return nonField;
	}

	public void setNonField(boolean nonField) {
		this.nonField.setSelected(nonField);
	}

	public JComboBox<TypeEntite> getTypeEntiteCombo() {
		return typeEntiteCombo;
	}

	public void setTypeEntiteCombo(JComboBox<TypeEntite> typeEntiteCombo) {
		this.typeEntiteCombo = typeEntiteCombo;
	}

}
