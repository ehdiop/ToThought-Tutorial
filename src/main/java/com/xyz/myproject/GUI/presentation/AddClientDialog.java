package com.xyz.myproject.GUI.presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.ListClient;
import com.xyz.myproject.model.general.Province;
/**
 * Fenêtre d'ajout d'un client (clic gauche sur bouton ajouter/clic droit>editer sur un client pour un edit)
 * @author Raoul
 *
 */
public class AddClientDialog extends JDialog {
	
	private Container pane;
	private static Dimension dimensionFields = PARAMETERS_IHM.dimensionTextField;
	private JTextField fieldEntreprise, villeField, CPField, NETextField, idProvField;
	private JTextArea fieldAdresse;
	private JComboBox<Province> comboProvince;
	private ListClient model;
	private boolean edit;
	private JButton valider;

	public AddClientDialog(JFrame owner, ListClient model, boolean edit){
		super(owner, true);
		this.edit=edit;
		this.setTitle("Ajout d'un client");
		this.model=model;
		this.pane = this.getContentPane();
		this.pane.setPreferredSize(new Dimension(450,300));
		this.pane.setLayout(new BorderLayout());
		this.buildPanel1();
		this.buildPanel2();
		
	}
	
	private void buildPanel1(){

		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints bagCons = new GridBagConstraints();
		bagCons.ipadx = 5;
		bagCons.ipady = 5;
		bagCons.anchor = GridBagConstraints.LINE_START;
		bagCons.weighty=0.01;

		
		JPanel panel = new JPanel();
		this.pane.add(panel, BorderLayout.CENTER);
		panel.setLayout(gridBagLayout);
		panel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(),"Informations sur la société"));
		
		
		//Nom de l'entreprise

		JLabel labelEntreprise = new JLabel("Nom de l'entreprise");
		this.fieldEntreprise = new JTextField();
		fieldEntreprise.setPreferredSize(dimensionFields);
		bagCons.gridx = 0;
		bagCons.gridy =0;
		bagCons.gridwidth = 1;
		bagCons.gridheight = 1;
	
		panel.add(labelEntreprise,bagCons);
		
		bagCons.gridx = 1;
		panel.add(fieldEntreprise, bagCons);
		
		
		//Adresse
		JLabel labelAdresse = new JLabel("Adresse");
		this.fieldAdresse = new JTextArea();
		fieldAdresse.setWrapStyleWord(true);
		fieldAdresse.setLineWrap(true);
		fieldAdresse.setBorder(fieldEntreprise.getBorder());
		Dimension dimensionAdresseField = new Dimension((int)dimensionFields.getWidth(), 60);
		
		fieldAdresse.setPreferredSize(dimensionAdresseField);
		bagCons.gridx=0;
		bagCons.gridy=1;
		panel.add(labelAdresse,bagCons);
		bagCons.gridx=1;
		panel.add(fieldAdresse,bagCons);
		
		
		//Ville

		JLabel labelVille = new JLabel("Ville");
		this.villeField = new JTextField();
		villeField.setPreferredSize(dimensionFields);
		bagCons.gridx=0;
		bagCons.gridy=2;
		panel.add(labelVille, bagCons);
		bagCons.gridx=1;
		panel.add(villeField,bagCons);
		
		
		//Province
		
		JLabel labelProvince = new JLabel("Province :");
		this.comboProvince = new JComboBox<Province>(Province.values());
		bagCons.gridx=0;
		bagCons.gridy=3;
		panel.add(labelProvince,bagCons);
		bagCons.gridx=1;
		panel.add(comboProvince,bagCons);
		
		
		//Code postal
	
		JLabel labelCP = new JLabel("Code postal :");
		this.CPField = new JTextField();
		Dimension CPDimension = new Dimension(60,(int) dimensionFields.getHeight());
		CPField.setPreferredSize(CPDimension);
		bagCons.gridx=0;
		bagCons.gridy=4;
		panel.add(labelCP,bagCons);
		bagCons.gridx=1;
		panel.add(CPField,bagCons);
		
		
		
		//Numéro d'entreprise
		
		JLabel NELabel = new JLabel("Numéro d'entreprise :");
		this.NETextField = new JTextField();
		NETextField.setPreferredSize(dimensionFields);
		bagCons.gridx=0;
		bagCons.gridy=5;
		panel.add(NELabel,bagCons);
		bagCons.gridx=1;
		panel.add(NETextField,bagCons);
		
		
		
		//Numéro d'identification provincial
	
		JLabel idProvLabel = new JLabel("Numéro d'identification provincial :");
		this.idProvField = new JTextField();
		idProvField.setPreferredSize(dimensionFields);
		bagCons.gridx=0;
		bagCons.gridy=6;
		panel.add(idProvLabel,bagCons);
		bagCons.gridx=1;
		panel.add(idProvField,bagCons);
		
		
		
		
	}
	
	private void buildPanel2(){
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		this.valider = new JButton("valider");
		valider.setAlignmentX(CENTER_ALIGNMENT);
		valider.setAlignmentY(CENTER_ALIGNMENT);
		panel2.add(valider);
		this.pane.add(panel2,BorderLayout.SOUTH);
		
	}

	public JTextField getFieldEntreprise() {
		return fieldEntreprise;
	}

	public void setFieldEntreprise(JTextField fieldEntreprise) {
		this.fieldEntreprise = fieldEntreprise;
	}

	public JTextField getVilleField() {
		return villeField;
	}

	public void setVilleField(JTextField villeField) {
		this.villeField = villeField;
	}

	public JTextField getCPField() {
		return CPField;
	}

	public void setCPField(JTextField cPField) {
		CPField = cPField;
	}

	public JTextField getNETextField() {
		return NETextField;
	}

	public void setNETextField(JTextField nETextField) {
		NETextField = nETextField;
	}

	public JTextField getIdProvField() {
		return idProvField;
	}

	public void setIdProvField(JTextField idProvField) {
		this.idProvField = idProvField;
	}

	public JTextArea getFieldAdresse() {
		return fieldAdresse;
	}

	public void setFieldAdresse(JTextArea fieldAdresse) {
		this.fieldAdresse = fieldAdresse;
	}

	public JComboBox<Province> getComboProvince() {
		return comboProvince;
	}

	public void setComboProvince(JComboBox<Province> comboProvince) {
		this.comboProvince = comboProvince;
	}
	
	public void fillWith(Client client){
		this.getFieldEntreprise().setText(client.getEntreprise());
		this.getFieldAdresse().setText(client.getAdresse());
		this.getVilleField().setText(client.getVille());
		this.getComboProvince().setSelectedItem(client.getProvince());
		this.getCPField().setText(client.getCp().getCp_value());
		this.getNETextField().setText(client.getNE().getNe());
		this.getIdProvField().setText(client.getNumProv().getNumProv());
	}

	public JButton getValider() {
		return valider;
	}


	
	
	
	
	
}
