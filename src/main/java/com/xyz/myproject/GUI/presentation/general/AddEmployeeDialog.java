package com.xyz.myproject.GUI.presentation.general;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.xyz.myproject.GUI.controller.AddEmployeeValiderController;
import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.FonctionEnum;
/**
 * Fenêtre de dialogue d'ajout d'un employé
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class AddEmployeeDialog extends JDialog {

	private Container pane;

	private JTextField prenomField, nomField, courrielField;
	private JComboBox<FonctionEnum> fonctionBox;
	private JTextArea qualifArea;
	private JRadioButton determineButton, nonDetermineButton;
	private Client clientModel;
	private JTable table;

	// Dimensions
	public static final Dimension dimensionField = PARAMETERS_IHM.dimensionTextField;
	public static final Insets leftInset = new Insets(0, 5, 0, 0),
			rightInset = new Insets(0, 0, 0, 5);
	private static final Dimension sidesMargin = new Dimension(10, 300);
	private static final Dimension topBotMargin = new Dimension(400, 10);
	private static final Dimension sizePanneauCentral = new Dimension(400, 180);
	private static final Dimension sizeWindow = new Dimension(430, 200);

	public AddEmployeeDialog(Client clientM, boolean edit, JTable table) {
		super();
		this.table = table;
		this.clientModel=clientM;
		this.setTitle("Ajout d'un employé");
		this.pane = this.getContentPane();
		this.pane.setLayout(new BorderLayout());
		this.pane.setPreferredSize(sizePanneauCentral);
		this.setMinimumSize(sizeWindow);

		JPanel panelForm = new JPanel();
		panelForm.setLayout(new GridBagLayout());
		this.pane.add(panelForm);
		this.pane.add(Box.createRigidArea(sidesMargin), BorderLayout.WEST);
		this.pane.add(Box.createRigidArea(sidesMargin), BorderLayout.EAST);
		this.pane.add(Box.createRigidArea(topBotMargin), BorderLayout.NORTH);
		this.pane.add(Box.createRigidArea(topBotMargin), BorderLayout.SOUTH);

		// Creation des zones de textes
		this.prenomField = new JTextField();
		this.prenomField.setPreferredSize(dimensionField);
		this.nomField = new JTextField();
		this.nomField.setPreferredSize(dimensionField);
		this.fonctionBox = new JComboBox<FonctionEnum>(FonctionEnum.values());
		this.courrielField = new JTextField();
		this.courrielField.setPreferredSize(dimensionField);
		this.qualifArea = new JTextArea();
		this.qualifArea.setLineWrap(true);
		this.qualifArea.setWrapStyleWord(true);
		this.determineButton = new JRadioButton();
		this.nonDetermineButton = new JRadioButton();
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(determineButton);
		buttonGroup.add(nonDetermineButton);

		// Creation des labels
		JLabel prenomLabel = new JLabel("Prenom :");
		JLabel nomLabel = new JLabel("Nom :");
		JLabel courrielLabel = new JLabel("Courriel :");
		JLabel fonctionLabel = new JLabel("Fonction :");
		JLabel qualifLabel = new JLabel("Qualification/expérience :");
		JLabel determineLabel = new JLabel("Employé déterminé :");
		JLabel ouiLabel = new JLabel("oui");
		JLabel nonLabel = new JLabel("non");

		JButton valider = new JButton("valider");
		AddEmployeeValiderController controllerModification = new AddEmployeeValiderController(this, this.clientModel.getDossierClient(), edit, this.table);
		valider.addMouseListener(controllerModification);
		this.clientModel.getDossierClient().getEmployes().addObserver(controllerModification);
		GridBagConstraints cons = new GridBagConstraints();
		cons.weightx = 0.33;
		cons.weighty = 0.33;
		cons.anchor = GridBagConstraints.LINE_START;

		// prenomlabel
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.insets = leftInset;
		panelForm.add(prenomLabel, cons);

		// prenomField
		cons.gridx = 1;
		cons.gridwidth = 4;
		cons.insets = rightInset;
		panelForm.add(prenomField, cons);

		// nomLabel
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridwidth = 1;
		cons.insets = leftInset;
		panelForm.add(nomLabel, cons);

		// nomField
		cons.gridx = 1;
		cons.gridwidth = 4;
		cons.insets = rightInset;
		panelForm.add(nomField, cons);

		// fonctionLabel
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridwidth = 1;
		cons.insets = leftInset;
		panelForm.add(fonctionLabel, cons);

		// fonctionField
		cons.gridx = 1;
		cons.gridwidth = 4;
		cons.insets = rightInset;
		panelForm.add(fonctionBox, cons);

		// courrielLabel
		cons.gridx = 0;
		cons.gridy = 3;
		cons.gridwidth = 1;
		cons.insets = leftInset;
		panelForm.add(courrielLabel, cons);

		// courrielField
		cons.gridx = 1;
		cons.gridwidth = 4;
		cons.insets = rightInset;
		panelForm.add(courrielField, cons);

		// determineLabel
		cons.gridx = 0;
		cons.gridy = 4;
		cons.gridwidth = 1;
		cons.insets = leftInset;
		cons.weightx = 0;
		panelForm.add(determineLabel, cons);

		// ouiLabel
		cons.gridx = 1;
		cons.gridwidth = 1;
		panelForm.add(ouiLabel, cons);

		// determineButton
		cons.gridx = 2;
		this.determineButton.setSelected(true);
		panelForm.add(determineButton, cons);

		// nonLabel
		cons.gridx = 3;
		panelForm.add(nonLabel, cons);

		// nondeterminebutton
		cons.gridx = 4;
		cons.insets = rightInset;
		panelForm.add(nonDetermineButton, cons);

		// valider
		cons.gridx = 2;
		cons.gridy = 5;
		panelForm.add(valider, cons);
	}

	public JTextField getPrenomField() {
		return prenomField;
	}

	public JTextField getNomField() {
		return nomField;
	}

	public JTextField getCourrielField() {
		return courrielField;
	}

	public JTextArea getQualifArea() {
		return qualifArea;
	}

	public JRadioButton getDetermineButton() {
		return determineButton;
	}

	public JRadioButton getNonDetermineButton() {
		return nonDetermineButton;
	}
	
	

	public JComboBox<FonctionEnum> getFonctionBox() {
		return fonctionBox;
	}

	public void setFonctionBox(JComboBox<FonctionEnum> fonctionBox) {
		this.fonctionBox = fonctionBox;
	}

	
}
