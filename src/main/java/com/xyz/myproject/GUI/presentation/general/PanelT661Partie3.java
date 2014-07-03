package com.xyz.myproject.GUI.presentation.general;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.GUI.presentation.general.DialogT661.PanelOnglet;
import com.xyz.myproject.GUI.presentation.general.SpecialTextFields.SizedTextFieldInt;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.T661Partie3;

/**
 * Onglet partie 3 de la fenêtre de dialogue du formulaire T661
 * @author Raoul
 *
 */
public class PanelT661Partie3 extends PanelOnglet {
	private SizedTextFieldInt QCField, ontaInnovField, ontaParrainField,
			ontaRSDEField, colombField, albertaField, autresAidProvField;

	private SizedTextFieldInt aidGouvProvField, autreTypeGouvField, nonGouvField,
			CIIPasseField, ventesField, deducDemandeeField;

	private Model model;
	// STATIC
	private Dimension fieldDimension = PARAMETERS_IHM.dimensionSmallTextField;

	public PanelT661Partie3(Model model) {
		this.model = model;
		JPanel wrapperGTitre = new JPanel(new FlowLayout());
		JLabel labelGrandTitre = new JLabel(
				"Section C : Calcul du montant de dépenses de RS&DE déductibles");
		wrapperGTitre.add(labelGrandTitre);
		labelGrandTitre.setFont(PARAMETERS_IHM.font);
		JPanel wrapperLegende = new JPanel(new FlowLayout());
		JLabel labelLegende = new JLabel(
				"Sont soustraits aux dépenses de RS&DE déductibles :");
		wrapperLegende.add(labelLegende);
		this.panelCentral.add(wrapperGTitre);
		this.panelCentral.add(wrapperLegende);
		this.buildListeCredit();
		this.buildAutresAides();
		this.fillWith();
	}

	private void buildListeCredit() {
		JPanel panel = new JPanel(new GridBagLayout());
		this.panelCentral.add(panel);
		JLabel QCLabel = new JLabel("crédit d'impôt de R-D du Québec");
		JLabel ontaInnovLab = new JLabel(
				"<html>crédit d'impôt à l'innovation de l'Ontario (CIIO) excluant la<br> portion provenant du montant de remplacement<html>");
		JLabel ontaParrainLab = new JLabel(
				"<html>crédit d'impôt de l'Ontario pour les entreprises parrainant les<br> instituts de recherche (CIOEPIR)<html>");
		JLabel ontaRSDELab = new JLabel(
				"<html>crédit d'impôt de l'Ontario pour la RS&DE (CIORD) excluant la<br> portion provenant du montant de remplacement<html>");
		JLabel colombLab = new JLabel(
				"<html>crédit d'impôt de RS&DE de la Colombie-Britannique excluant la<br> portion provenant du montant de remplacement<html> ");
		JLabel albertaLab = new JLabel(
				"<html>crédit d'impôt de l'Alberta pour la RS&DE excluant la portion<br> provenant du montant de remplacement <html>");
		JLabel autresAidProvLab = new JLabel(
				"<html>autres aide gouvernementale provinciale relative aux dépenses<br> incluses à la ligne 400<html>");

		QCField = new SizedTextFieldInt();
		QCField.setPreferredSize(fieldDimension);
		ontaInnovField = new SizedTextFieldInt();
		ontaInnovField.setPreferredSize(fieldDimension);
		ontaParrainField = new SizedTextFieldInt();
		ontaParrainField.setPreferredSize(fieldDimension);
		ontaRSDEField = new SizedTextFieldInt();
		ontaRSDEField.setPreferredSize(fieldDimension);
		colombField = new SizedTextFieldInt();
		colombField.setPreferredSize(fieldDimension);
		albertaField = new SizedTextFieldInt();
		albertaField.setPreferredSize(fieldDimension);
		autresAidProvField = new SizedTextFieldInt();
		autresAidProvField.setPreferredSize(fieldDimension);

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0;
		cons.anchor = GridBagConstraints.LINE_START;
		cons.insets = new Insets(0, 0, 0, 5 * PARAMETERS_IHM.mesure);

		// QCLabel
		panel.add(QCLabel, cons);
		// ontaInnovLab
		cons.gridy++;
		panel.add(ontaInnovLab, cons);
		// ontaParrainLab
		cons.gridy++;
		panel.add(ontaParrainLab, cons);
		// ontaRSDELab
		cons.gridy++;
		panel.add(ontaRSDELab, cons);
		// colombLab
		cons.gridy++;
		panel.add(colombLab, cons);
		// albertaLab
		cons.gridy++;
		panel.add(albertaLab, cons);
		// autresAidProvLab
		cons.gridy++;
		panel.add(autresAidProvLab, cons);

		cons.gridy = 0;
		cons.gridx = 1;
		cons.weightx = 1;
		// QCField
		panel.add(QCField, cons);
		// ontaInnovField
		cons.gridy++;
		panel.add(ontaInnovField, cons);
		// ontaParrainField
		cons.gridy++;
		panel.add(ontaParrainField, cons);
		// ontaRSDEField
		cons.gridy++;
		panel.add(ontaRSDEField, cons);
		// colombField
		cons.gridy++;
		panel.add(colombField, cons);
		// albertaField
		cons.gridy++;
		panel.add(albertaField, cons);
		// autresAidProvField
		cons.gridy++;
		panel.add(autresAidProvField, cons);
	}

	private void buildAutresAides() {
		JPanel panel = new JPanel(new GridBagLayout());
		this.panelCentral.add(panel);
		JLabel aidGouvProvLab = new JLabel(
				"<html>aide gouvernementale provinciale relative aux dépenses incluses<br> à la ligne 400<html>");
		JLabel autreTypeGouvLab = new JLabel(
				"<html>autres type d'aide gouvernementale relative aux dépenses incluses à<br> la ligne 400<html>");
		JLabel nonGouvLab = new JLabel(
				"<html>aide non gouvernementale relative aux dépenses incluses à la ligne<br> 400<html>");
		JLabel CIIPasseLab = new JLabel(
				"montant de CII récupéré l'année passée");
		JLabel ventesLab = new JLabel(
				"vente de biens en capital de RS&DE et autres déductions");
		JLabel deducDemandeeLab = new JLabel(
				"Déduction demandée pour l'année courante");

		this.aidGouvProvField = new SizedTextFieldInt();
		aidGouvProvField.setPreferredSize(fieldDimension);
		autreTypeGouvField = new SizedTextFieldInt();
		autreTypeGouvField.setPreferredSize(fieldDimension);
		nonGouvField = new SizedTextFieldInt();
		nonGouvField.setPreferredSize(fieldDimension);
		CIIPasseField = new SizedTextFieldInt();
		CIIPasseField.setPreferredSize(fieldDimension);
		ventesField = new SizedTextFieldInt();
		ventesField.setPreferredSize(fieldDimension);
		deducDemandeeField = new SizedTextFieldInt();
		deducDemandeeField.setPreferredSize(fieldDimension);

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0;
		cons.insets = new Insets(0, 0, PARAMETERS_IHM.mesure,
				5 * PARAMETERS_IHM.mesure);
		cons.anchor = GridBagConstraints.LINE_START;

		// aidGouvProvLab
		panel.add(aidGouvProvLab, cons);
		// autreTypeGouvLab
		cons.gridy++;
		panel.add(autreTypeGouvLab, cons);
		// nonGouvLab
		cons.gridy++;
		panel.add(nonGouvLab, cons);
		// CIIPasseLab
		cons.gridy++;
		panel.add(CIIPasseLab, cons);
		// ventesLab
		cons.gridy++;
		panel.add(ventesLab, cons);
		// deducDemandeeLab
		cons.gridy++;
		panel.add(deducDemandeeLab, cons);

		cons.weightx = 1;
		cons.gridx = 1;
		cons.gridy = 0;
		// aidGouvProvField
		panel.add(aidGouvProvField, cons);
		// autreTypeGouvField
		cons.gridy++;
		panel.add(autreTypeGouvField, cons);
		// nonGouvField
		cons.gridy++;
		panel.add(nonGouvField, cons);
		// CIIPasseField
		cons.gridy++;
		panel.add(CIIPasseField, cons);
		// ventesField
		cons.gridy++;
		panel.add(ventesField, cons);
		// deducDemandeeField
		cons.gridy++;
		panel.add(deducDemandeeField, cons);

	}

	

	public SizedTextFieldInt getQCField() {
		return QCField;
	}

	public SizedTextFieldInt getOntaInnovField() {
		return ontaInnovField;
	}

	public SizedTextFieldInt getOntaParrainField() {
		return ontaParrainField;
	}

	public SizedTextFieldInt getOntaRSDEField() {
		return ontaRSDEField;
	}

	public SizedTextFieldInt getColombField() {
		return colombField;
	}

	public SizedTextFieldInt getAlbertaField() {
		return albertaField;
	}

	public SizedTextFieldInt getAutresAidProvField() {
		return autresAidProvField;
	}

	public SizedTextFieldInt getAidGouvProvField() {
		return aidGouvProvField;
	}

	public SizedTextFieldInt getAutreTypeGouvField() {
		return autreTypeGouvField;
	}

	public SizedTextFieldInt getNonGouvField() {
		return nonGouvField;
	}

	public SizedTextFieldInt getCIIPasseField() {
		return CIIPasseField;
	}

	public SizedTextFieldInt getVentesField() {
		return ventesField;
	}

	public SizedTextFieldInt getDeducDemandeeField() {
		return deducDemandeeField;
	}

	public Dimension getFieldDimension() {
		return fieldDimension;
	}

	public void fillWith() {
		T661Partie3 tsis = model.getDossierAnnee().getT661().getPartie3();
		QCField.setText("" + tsis.getQCCredit());
		ontaInnovField.setText("" + tsis.getOntaInnov());
		ontaParrainField.setText("" + tsis.getOntaParrain());
		ontaRSDEField.setText("" + tsis.getOntaRSDE());
		colombField.setText("" + tsis.getColomb());
		albertaField.setText("" + tsis.getAlberta());
		autresAidProvField.setText("" + tsis.getAutresAidProv());
		aidGouvProvField.setText("" + tsis.getAidGouvProv());
		autreTypeGouvField.setText("" + tsis.getAutreTypeGouv());
		nonGouvField.setText("" + tsis.getNonGouv());
		CIIPasseField.setText("" + tsis.getCIIPasse());
		ventesField.setText("" + tsis.getVentes());
		deducDemandeeField.setText("" + tsis.getDeducDemandee());
	}

	public void onClick() {
		T661Partie3 tsis = model.getDossierAnnee().getT661().getPartie3();
		tsis.setQCCredit(QCField.getIntValue());
		tsis.setOntaInnov(ontaInnovField.getIntValue());
		tsis.setOntaParrain(ontaParrainField.getIntValue());
		tsis.setOntaRSDE(ontaRSDEField.getIntValue());
		tsis.setColomb(colombField.getIntValue());
		tsis.setAlberta(albertaField.getIntValue());
		tsis.setAutresAidProv(autresAidProvField.getIntValue());
		tsis.setAidGouvProv(aidGouvProvField.getIntValue());
		tsis.setAutreTypeGouv(autreTypeGouvField.getIntValue());
		tsis.setNonGouv(nonGouvField.getIntValue());
		tsis.setCIIPasse(CIIPasseField.getIntValue());
		tsis.setVentes(ventesField.getIntValue());
		tsis.setDeducDemandee(deducDemandeeField.getIntValue());
		
	}

}
