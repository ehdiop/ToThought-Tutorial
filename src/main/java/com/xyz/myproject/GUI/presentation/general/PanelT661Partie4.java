package com.xyz.myproject.GUI.presentation.general;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.GUI.presentation.general.DialogT661.PanelOnglet;
import com.xyz.myproject.GUI.presentation.general.SpecialTextFields.SizedTextFieldInt;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.T661Partie4;

/**
 * Onglet partie 4 de la fenêtre de dialogue du formulaire T661
 * 
 * @author Raoul
 * 
 */
@SuppressWarnings("serial")
public class PanelT661Partie4 extends PanelOnglet {

	private SizedTextFieldInt QCcredFieldCourant, ontaInovFieldCourant,
			ontaInstFieldCourant, ontaRSDEFieldCourant, colBritaFieldCourant,
			albertaFieldCourant, autreGouvProvFieldCourant,
			aideGouvProvFieldCourant, autreTypeGouvFieldCourant,
			paieContracFieldCourant, depCour180joursFieldCourant,
			depAdmTransfCourant;
	private SizedTextFieldInt QCcredFieldCapital, ontaInovFieldCapital,
			ontaInstFieldCapital, ontaRSDEFieldCapital, colBritaFieldCapital,
			albertaFieldCapital, autreGouvProvFieldCapital,
			aideGouvProvFieldCapital, autreTypeGouvFieldCapital,
			depAdmTransfCapital, paieContracFieldCapital;
	private Model model;

	public PanelT661Partie4(Model model) {
		this.model = model;
		this.buildListeCredit();
		this.fillWith();

	}

	private void buildListeCredit() {
		JPanel panelCredit = new JPanel(new GridBagLayout());
		this.panelCentral.add(panelCredit);

		JLabel titre = new JLabel(
				"Le résultat sert à calculer vos CII remboursables et/ou non remboursables.");
		JLabel titreCourant = new JLabel("<html>Dépenses <br>courantes<html>");
		JLabel titreCapital = new JLabel("<html>Dépenses <br>en capital<html>");

		JLabel QCcredLab = new JLabel("crédit d'impôt de R&D du Québec");
		JLabel ontaInovLab = new JLabel(
				"crédit d'impôt à l'innovation de l'Ontario (CIIO) ");
		JLabel ontaInstLab = new JLabel(
				"crédit d'impôt de l'Ontario pour les entreprises parrainant les instituts de recherche (CIOEPIR)");
		JLabel ontaRSDELab = new JLabel(
				"crédit d'impôt de l'Ontario pour la RS&DE (CIORD)");
		JLabel colBritaLab = new JLabel(
				"crédit d'impôt de RS&DE de la Colombie-Britannique");
		JLabel albertaLab = new JLabel(
				"crédit d'impôt de l'Alberta pour la RS&DE");
		JLabel autreGouvProvLab = new JLabel(
				"autre aide gouvernementale provinciale");
		JLabel aideGouvProvLab = new JLabel("aide gouvernementale provinciale");
		JLabel autreTypeGouvLab = new JLabel(
				"autre type d'aide gouvernementale");
		JLabel paieContracLab = new JLabel(
				"aide non gouvernementale et paiements contractuels");
		JLabel depCour180jours = new JLabel(
				"<html>dépenses courantes (autres que les traitements ou salaires) qui<br> n'ont pas été payées dans les 180 jours suivant la fin de l'année<br> d'imposition<html>");
		JLabel depAdmTransfLab = new JLabel(
				"dépenses admissibles que vous avez transférées");
		QCcredFieldCourant = new SizedTextFieldInt();
		ontaInovFieldCourant = new SizedTextFieldInt();
		ontaInstFieldCourant = new SizedTextFieldInt();
		ontaRSDEFieldCourant = new SizedTextFieldInt();
		colBritaFieldCourant = new SizedTextFieldInt();
		albertaFieldCourant = new SizedTextFieldInt();
		autreGouvProvFieldCourant = new SizedTextFieldInt();
		aideGouvProvFieldCourant = new SizedTextFieldInt();
		autreTypeGouvFieldCourant = new SizedTextFieldInt();
		paieContracFieldCourant = new SizedTextFieldInt();
		depCour180joursFieldCourant = new SizedTextFieldInt();
		depAdmTransfCourant = new SizedTextFieldInt();

		QCcredFieldCapital = new SizedTextFieldInt();
		ontaInovFieldCapital = new SizedTextFieldInt();
		ontaInstFieldCapital = new SizedTextFieldInt();
		ontaRSDEFieldCapital = new SizedTextFieldInt();
		colBritaFieldCapital = new SizedTextFieldInt();
		albertaFieldCapital = new SizedTextFieldInt();
		autreGouvProvFieldCapital = new SizedTextFieldInt();
		aideGouvProvFieldCapital = new SizedTextFieldInt();
		autreTypeGouvFieldCapital = new SizedTextFieldInt();
		paieContracFieldCapital = new SizedTextFieldInt();
		depAdmTransfCapital = new SizedTextFieldInt();

		int debutTab;
		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0;
		cons.anchor = GridBagConstraints.LINE_START;
		cons.insets = new Insets(0, 0, PARAMETERS_IHM.mesure,
				PARAMETERS_IHM.mesure);

		// titre
		panelCredit.add(titre, cons);

		// LABELS
		// glue
		cons.gridy++;
		debutTab = cons.gridy;
		panelCredit.add(Box.createGlue());
		// QCcredLab
		cons.gridy++;
		panelCredit.add(QCcredLab, cons);
		// ontaInovLab
		cons.gridy++;
		panelCredit.add(ontaInovLab, cons);
		// ontaInstLab
		cons.gridy++;
		panelCredit.add(ontaInstLab, cons);
		// ontaRSDELab
		cons.gridy++;
		panelCredit.add(ontaRSDELab, cons);
		// colBrita
		cons.gridy++;
		panelCredit.add(colBritaLab, cons);
		// albertaLab
		cons.gridy++;
		panelCredit.add(albertaLab, cons);
		// autreGouvProvLab
		cons.gridy++;
		panelCredit.add(autreGouvProvLab, cons);
		// aideGouvProvLab
		cons.gridy++;
		panelCredit.add(aideGouvProvLab, cons);
		// autreTypeGouvLab
		cons.gridy++;
		panelCredit.add(autreTypeGouvLab, cons);
		// paieContracLab
		cons.gridy++;
		panelCredit.add(paieContracLab, cons);
		// depCour180jours
		cons.gridy++;
		panelCredit.add(depCour180jours, cons);
		// depAdmTransfLab
		cons.gridy++;
		panelCredit.add(depAdmTransfLab, cons);

		// SERIE DE FIELD DE GAUCHE
		// titreCourant
		cons.gridy = debutTab;
		cons.gridx = 1;
		panelCredit.add(titreCourant, cons);
		// QCcredFieldCourant
		cons.gridy++;
		panelCredit.add(QCcredFieldCourant, cons);
		// ontaInovFieldCourant
		cons.gridy++;
		panelCredit.add(ontaInovFieldCourant, cons);
		// ontaInstFieldCourant
		cons.gridy++;
		panelCredit.add(ontaInstFieldCourant, cons);
		// ontaRSDEFieldCourant
		cons.gridy++;
		panelCredit.add(ontaRSDEFieldCourant, cons);
		// colBritaFieldCourant
		cons.gridy++;
		panelCredit.add(colBritaFieldCourant, cons);
		// albertaFieldCourant
		cons.gridy++;
		panelCredit.add(albertaFieldCourant, cons);
		// autreGouvProvFieldCourant
		cons.gridy++;
		panelCredit.add(autreGouvProvFieldCourant, cons);
		// aideGouvProvFieldCourant
		cons.gridy++;
		panelCredit.add(aideGouvProvFieldCourant, cons);
		// autreTypeGouvFieldCourant
		cons.gridy++;
		panelCredit.add(autreTypeGouvFieldCourant, cons);
		// paieContracFieldCourant
		cons.gridy++;
		panelCredit.add(paieContracFieldCourant, cons);
		// depCour180joursFieldCourant
		cons.gridy++;
		panelCredit.add(depCour180joursFieldCourant, cons);
		// depAdmTransfCourant
		cons.gridy++;
		panelCredit.add(depAdmTransfCourant, cons);

		// SERIE DE JTEXTFIELD DE DROITE
		// titreCapital
		cons.gridy = debutTab;
		cons.gridx = 2;
		cons.weightx = 1;
		panelCredit.add(titreCapital, cons);
		// QCcredFieldCapital
		cons.gridy++;
		panelCredit.add(QCcredFieldCapital, cons);
		// ontaInovFieldCapital
		cons.gridy++;
		panelCredit.add(ontaInovFieldCapital, cons);
		// ontaInstFieldCapital
		cons.gridy++;
		panelCredit.add(ontaInstFieldCapital, cons);
		// ontaRSDEFieldCapital
		cons.gridy++;
		panelCredit.add(ontaRSDEFieldCapital, cons);
		// colBritaFieldCapital
		cons.gridy++;
		panelCredit.add(colBritaFieldCapital, cons);
		// albertaFieldCapital
		cons.gridy++;
		panelCredit.add(albertaFieldCapital, cons);
		// autreGouvProvFieldCapital
		cons.gridy++;
		panelCredit.add(autreGouvProvFieldCapital, cons);
		// aideGouvProvFieldCapital
		cons.gridy++;
		panelCredit.add(aideGouvProvFieldCapital, cons);
		// autreTypeGouvFieldCapital
		cons.gridy++;
		panelCredit.add(autreTypeGouvFieldCapital, cons);
		// paieContracFieldCapital
		cons.gridy++;
		panelCredit.add(paieContracFieldCapital, cons);
		// glue
		cons.gridy++;
		panelCredit.add(Box.createGlue(), cons);
		// depAdmTransfCapital
		cons.gridy++;
		panelCredit.add(depAdmTransfCapital, cons);

	}

	public SizedTextFieldInt getQCcredFieldCourant() {
		return QCcredFieldCourant;
	}

	public SizedTextFieldInt getOntaInovFieldCourant() {
		return ontaInovFieldCourant;
	}

	public SizedTextFieldInt getOntaInstFieldCourant() {
		return ontaInstFieldCourant;
	}

	public SizedTextFieldInt getOntaRSDEFieldCourant() {
		return ontaRSDEFieldCourant;
	}

	public SizedTextFieldInt getColBritaFieldCourant() {
		return colBritaFieldCourant;
	}

	public SizedTextFieldInt getAlbertaFieldCourant() {
		return albertaFieldCourant;
	}

	public SizedTextFieldInt getAutreGouvProvFieldCourant() {
		return autreGouvProvFieldCourant;
	}

	public SizedTextFieldInt getAideGouvProvFieldCourant() {
		return aideGouvProvFieldCourant;
	}

	public SizedTextFieldInt getAutreTypeGouvFieldCourant() {
		return autreTypeGouvFieldCourant;
	}

	public SizedTextFieldInt getPaieContracFieldCourant() {
		return paieContracFieldCourant;
	}

	public SizedTextFieldInt getDepCour180joursFieldCourant() {
		return depCour180joursFieldCourant;
	}

	public SizedTextFieldInt getDepAdmTransfCourant() {
		return depAdmTransfCourant;
	}

	public SizedTextFieldInt getQCcredFieldCapital() {
		return QCcredFieldCapital;
	}

	public SizedTextFieldInt getOntaInovFieldCapital() {
		return ontaInovFieldCapital;
	}

	public SizedTextFieldInt getOntaInstFieldCapital() {
		return ontaInstFieldCapital;
	}

	public SizedTextFieldInt getOntaRSDEFieldCapital() {
		return ontaRSDEFieldCapital;
	}

	public SizedTextFieldInt getColBritaFieldCapital() {
		return colBritaFieldCapital;
	}

	public SizedTextFieldInt getAlbertaFieldCapital() {
		return albertaFieldCapital;
	}

	public SizedTextFieldInt getAutreGouvProvFieldCapital() {
		return autreGouvProvFieldCapital;
	}

	public SizedTextFieldInt getAideGouvProvFieldCapital() {
		return aideGouvProvFieldCapital;
	}

	public SizedTextFieldInt getAutreTypeGouvFieldCapital() {
		return autreTypeGouvFieldCapital;
	}

	public SizedTextFieldInt getDepAdmTransfCapital() {
		return depAdmTransfCapital;
	}

	public SizedTextFieldInt getPaieContracFieldCapital() {
		return paieContracFieldCapital;
	}

	public void fillWith() {
		T661Partie4 partie4 = model.getDossierAnnee().getT661().getPartie4();
		QCcredFieldCourant.setText("" + partie4.getQCcredCourant());
		ontaInovFieldCourant.setText("" + partie4.getOntaInovCourant());
		ontaInstFieldCourant.setText("" + partie4.getOntaInstCourant());
		ontaRSDEFieldCourant.setText("" + partie4.getOntaRSDECourant());
		colBritaFieldCourant.setText("" + partie4.getColBritaCourant());
		albertaFieldCourant.setText("" + partie4.getAlbertaCourant());
		autreGouvProvFieldCourant.setText(""
				+ partie4.getAutreGouvProvCourant());
		aideGouvProvFieldCourant.setText("" + partie4.getAideGouvProvCourant());
		autreTypeGouvFieldCourant.setText(""
				+ partie4.getAutreTypeGouvCourant());
		paieContracFieldCourant.setText("" + partie4.getPaieContracCourant());
		depCour180joursFieldCourant.setText(""
				+ partie4.getDepCour180joursCourant());
		depAdmTransfCourant.setText("" + partie4.getDepAdmTransfCourant());

		QCcredFieldCapital.setText("" + partie4.getQCcredCapital());
		ontaInovFieldCapital.setText("" + partie4.getOntaInovCapital());
		ontaInstFieldCapital.setText("" + partie4.getOntaInstCapital());
		ontaRSDEFieldCapital.setText("" + partie4.getOntaRSDECapital());
		colBritaFieldCapital.setText("" + partie4.getColBritaCapital());
		albertaFieldCapital.setText("" + partie4.getAlbertaCapital());
		autreGouvProvFieldCapital.setText(""
				+ partie4.getAutreGouvProvCapital());
		aideGouvProvFieldCapital.setText("" + partie4.getAideGouvProvCapital());
		autreTypeGouvFieldCapital.setText(""
				+ partie4.getAutreTypeGouvCapital());
		paieContracFieldCapital.setText("" + partie4.getPaieContracCapital());
		depAdmTransfCapital.setText("" + partie4.getDepAdmTransfCapital());

	}

	public void onClick() {
		T661Partie4 tsis = model.getDossierAnnee().getT661().getPartie4();

		tsis.setQCcredCourant(this.getQCcredFieldCourant().getIntValue());
		tsis.setOntaInovCourant(getOntaInovFieldCourant().getIntValue());
		tsis.setOntaInstCourant(getOntaInstFieldCourant().getIntValue());
		tsis.setOntaRSDECourant(getOntaRSDEFieldCourant().getIntValue());
		tsis.setColBritaCourant(getColBritaFieldCourant().getIntValue());
		tsis.setAlbertaCourant(getAlbertaFieldCourant().getIntValue());
		tsis.setAutreGouvProvCourant(getAutreGouvProvFieldCourant()
				.getIntValue());
		tsis.setAideGouvProvCourant(getAideGouvProvFieldCourant().getIntValue());
		tsis.setAutreTypeGouvCourant(getAutreTypeGouvFieldCourant()
				.getIntValue());
		tsis.setPaieContracCourant(getPaieContracFieldCourant().getIntValue());
		tsis.setDepCour180joursCourant(getDepCour180joursFieldCourant()
				.getIntValue());
		tsis.setDepAdmTransfCourant(getDepAdmTransfCourant().getIntValue());

		tsis.setQCcredCapital(getQCcredFieldCapital().getIntValue());
		tsis.setOntaInovCapital(getOntaInovFieldCapital().getIntValue());
		tsis.setOntaInstCapital(getOntaInstFieldCapital().getIntValue());
		tsis.setOntaRSDECapital(getOntaRSDEFieldCapital().getIntValue());
		tsis.setColBritaCapital(getColBritaFieldCapital().getIntValue());
		tsis.setAlbertaCapital(getAlbertaFieldCapital().getIntValue());
		tsis.setAutreGouvProvCapital(getAutreGouvProvFieldCapital()
				.getIntValue());
		tsis.setAideGouvProvCapital(getAideGouvProvFieldCapital().getIntValue());
		tsis.setAutreTypeGouvCapital(getAutreTypeGouvFieldCapital()
				.getIntValue());
		tsis.setPaieContracCapital(getPaieContracFieldCapital().getIntValue());
		tsis.setDepAdmTransfCapital(getDepAdmTransfCapital().getIntValue());
	}

}
