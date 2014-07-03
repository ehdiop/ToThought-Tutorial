package com.xyz.myproject.GUI.presentation.general;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.GUI.presentation.general.DialogT661.PanelOnglet;
import com.xyz.myproject.GUI.presentation.general.SpecialTextFields.SizedTextFieldInt;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.RD1029;

/**
 * Onglet partie 3 de la fenêtre de dialogue du RD1029.7
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class PanelRD1029Partie3 extends PanelOnglet {
	
	private SizedTextFieldInt aContribField, bStDepField, cStNonDepField;
	
	private Model model;
	
	private JPanel panelDuCentre;
	
	public PanelRD1029Partie3(Model model){
		this.model = model;
		JLabel labelTitre = new JLabel("3- Dépenses admissibles");
		panelDuCentre = new JPanel();
		panelDuCentre.setLayout(new BoxLayout(panelDuCentre,BoxLayout.Y_AXIS));
		this.panelDuCentre.add(labelTitre);
		this.panelCentral.add(this.panelDuCentre);
		this.buildPanel();
		this.fillWith();
	}

	private void buildPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		this.panelDuCentre.add(panel);
		JLabel legende = new JLabel("Salaires et contreparties versées à un sous-traitant");
		JLabel contribLab = new JLabel("Contribuable");
		JLabel stDepLab = new JLabel("<html>Sous-traitant avec lien<br> de dépendance<html>");
		JLabel stNonDepLab = new JLabel("<html>Sous-traitant sans lien<br> de dépendance<html>");
		
		aContribField= new SizedTextFieldInt();
		bStDepField=new SizedTextFieldInt();
		cStNonDepField = new SizedTextFieldInt();
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx=0;
		cons.gridy=0;
		cons.weightx=0;
		cons.insets = new Insets(0,0,0,PARAMETERS_IHM.mesure);
		
		//glue
		panel.add(Box.createGlue(),cons);
		//legende
		cons.gridy++;
		panel.add(legende,cons);
		//contribLab
		cons.gridy=0;
		cons.gridx++;
		panel.add(contribLab,cons);
		//contribField
		cons.gridy++;
		panel.add(aContribField,cons);
		//stDepLab
		cons.gridy=0;
		cons.gridx++;
		panel.add(stDepLab,cons);
		//stDepField
		cons.gridy++;
		panel.add(bStDepField,cons);
		//stNonDepLab
		cons.gridy=0;
		cons.gridx++;
		panel.add(stNonDepLab,cons);
		//stNonDepField
		cons.gridy++;
		panel.add(cStNonDepField,cons);
	}
	
	public void fillWith(){
		RD1029 rd1029 = model.getDossierAnnee().getRd1029();
		aContribField.setText(""+rd1029.getPartie3().getaContribuable());
		bStDepField.setText(""+rd1029.getPartie3().getbSTDep());
		cStNonDepField.setText(""+rd1029.getPartie3().getcSTNonDep());
	}
	
	public void onClick(){
		RD1029 rd1029 = model.getDossierAnnee().getRd1029();
		rd1029.getPartie3().setaContribuable(aContribField.getIntValue());
		rd1029.getPartie3().setbSTDep(bStDepField.getIntValue());
		rd1029.getPartie3().setcSTNonDep(cStNonDepField.getIntValue());
	}
}
