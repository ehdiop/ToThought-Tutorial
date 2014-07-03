package com.xyz.myproject.GUI.presentation.projet;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;

import com.toedter.calendar.JDateChooser;
import com.xyz.myproject.GUI.controller.AddProjetValiderController;
import com.xyz.myproject.GUI.presentation.AddEDialog;
import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.model.Model;

/**
 * Boite de dialogue d'ajout d'un projet.
 * @author Raoul
 *
 */
public class AddProjetDialog extends AddEDialog{
	
	private JSpinner numSpinner;
	private JTextField titreField, respField;
	private JDateChooser debutChooser, finChooser;
	private JPanel panelCentral;
	private Model model;
	
	//COnstantes statiques
	private static final Dimension dimensionField = PARAMETERS_IHM.dimensionTextField;
	private static final Dimension dimensionPanel = new Dimension(350,200);
	
	public AddProjetDialog(Model modelM, Window parent){
		super(parent);
		this.model=modelM;
		this.setTitle("Ajout d'un projet");	
		this.pane.setPreferredSize(dimensionPanel);
		this.panelCentral = new JPanel();
		this.pane.add(panelCentral);
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		this.buildPanel();
		JButton ok = new JButton("OK");
		this.panelCentral.add(ok);
		//Controllers
		ok.addMouseListener(new AddProjetValiderController(this.model, this));
	}
	

	
	private void buildPanel() {
		JPanel panelForm = new JPanel();
		panelForm.setLayout(new GridBagLayout());
		this.panelCentral.add(panelForm);
		
		JLabel numLabel = new JLabel("Numéro du projet :");
		JLabel titreLabel = new JLabel("Titre du projet :");
		JLabel respLabel = new JLabel("Responsable du projet");
		JLabel debutLabel = new JLabel("Date de début du projet :");
		JLabel finLabel = new JLabel("Date de fin du projet :");
		
		this.numSpinner = new JSpinner(generateNumbers());
		this.numSpinner.setPreferredSize(new Dimension(40,20));
		this.titreField = new JTextField();
		this.titreField.setPreferredSize(dimensionField);
		this.respField = new JTextField();
		this.respField.setPreferredSize(dimensionField);
		this.debutChooser = new JDateChooser(null, PARAMETERS_IHM.dateFormat);
		this.finChooser = new JDateChooser(null, PARAMETERS_IHM.dateFormat);
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.anchor = GridBagConstraints.LINE_START;
		cons.gridwidth=1;
		cons.gridx=0;
		cons.gridy=0;
		cons.weightx=0.33;
		cons.weighty= 0.33;
		
		//numLabel
		panelForm.add(numLabel,cons);
		
		//numSpinner
		cons.gridx=1;
		panelForm.add(numSpinner,cons);
		
		//titreLabel
		cons.gridx=0;
		cons.gridy++;
		panelForm.add(titreLabel,cons);
		
		//titreField
		cons.gridx=1;
		panelForm.add(titreField,cons);
		
		//respLabel
		cons.gridx=0;
		cons.gridy++;
		panelForm.add(respLabel,cons);
		
		//respField
		cons.gridx=1;
		panelForm.add(respField,cons);
		
		//debutLabel
		cons.gridx=0;
		cons.gridy++;
		panelForm.add(debutLabel,cons);
		
		//debutChooser
		cons.gridx=1;
		panelForm.add(debutChooser,cons);
		
		//finLabel
		cons.gridx=0;
		cons.gridy++;
		panelForm.add(finLabel,cons);
		
		//finChooser
		cons.gridx=1;
		panelForm.add(finChooser,cons);
	}
	
	



	public JSpinner getNumSpinner() {
		return numSpinner;
	}



	public void setNumSpinner(JSpinner numSpinner) {
		this.numSpinner = numSpinner;
	}



	public JTextField getTitreField() {
		return titreField;
	}



	public void setTitreField(JTextField titreField) {
		this.titreField = titreField;
	}



	public JTextField getRespField() {
		return respField;
	}



	public void setRespField(JTextField respField) {
		this.respField = respField;
	}



	public JDateChooser getDebutChooser() {
		return debutChooser;
	}



	public void setDebutChooser(JDateChooser debutChooser) {
		this.debutChooser = debutChooser;
	}



	public JDateChooser getFinChooser() {
		return finChooser;
	}



	public void setFinChooser(JDateChooser finChooser) {
		this.finChooser = finChooser;
	}



	private static SpinnerModel generateNumbers(){
		Integer[] numbers = new Integer[100];
		for(int i=0;i<100;i++){
			numbers[i]=(i+1);
		}
		SpinnerModel spinnerModel = new SpinnerListModel(numbers);
		return spinnerModel;
	}
	
}
