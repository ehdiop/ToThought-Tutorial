package com.xyz.myproject.GUI.presentation.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.xyz.myproject.GUI.controller.InfoGenProjetCheckBoxController;
import com.xyz.myproject.GUI.controller.InfoGenProjetCheckBoxController.AutreLieuDevController;
import com.xyz.myproject.GUI.controller.InfoGenProjetCheckBoxController.AutrePreuveController;
import com.xyz.myproject.GUI.controller.InfoGenProjetCheckBoxController.ConsultantController;
import com.xyz.myproject.GUI.controller.InfoGenProjetCheckBoxController.RedacteurAutreController;
import com.xyz.myproject.GUI.controller.InfoGenProjetCheckBoxController.RedacteurImpliqueController;
import com.xyz.myproject.GUI.controller.InfoGenProjetCheckBoxController.TypeRechercheController;
import com.xyz.myproject.GUI.controller.InfoProjetController;
import com.xyz.myproject.GUI.controller.ValideInfoGenProjetController;
import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.ButTravaux;
import com.xyz.myproject.model.projet.CodeDomaineScience;
import com.xyz.myproject.model.projet.Employee;
import com.xyz.myproject.model.projet.InfoGeneralesProjet;
import com.xyz.myproject.model.projet.LieuDeveloppement;
import com.xyz.myproject.model.projet.ObjectifProjet;
import com.xyz.myproject.model.projet.PreuvesAppui;
import com.xyz.myproject.model.projet.Projet;
import com.xyz.myproject.model.projet.RenseignementsRedac;

/**
 * Ze big class : panel des informations générales du projet.
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class PanelInfo extends JPanel {

	private Model model;
	private JPanel panelCentral;
	private JTextField titreField, numeroField, respoField, autreLieuField,
			consultantField, firmeField, autrePreuve;
	private JRadioButton premiereReclam, pasPremiereReclam, conjoint, nonConjoint, ouiSalaireEtranger,
			nonSalaireEtranger, ouiAutrePartie, nonAutrePartie,
			ouiAutreEmploye, nonAutreEmploye;
	private JDateChooser debutChooser, finChooser;
	private JComboBox<CodeDomaineScience> domaineCombo;
	private JComboBox<Employee> employeImpliqueCombo, autreEmployeCombo;
	private JCheckBox devMat, amMat, devProc, amProc, laboratoire, usineCom,
			rechDediee, autreLieu, employeImpliqueBox, autreEmployeBox,
			consultantBox,developpementExp,
			recherchePure;

	private JCheckBox aDocPlanif, bRegistreAttrib, cConcEssai, dRegProj,
			eCodeSource, fRegEssai, gRapProg, hProtEssai, iPhoto, jEchant,
			kContrat, lAutres;
	private JButton valider;

	// Static constants
	private static final Dimension margeVerticale = new Dimension(40, 20);
	private static final Dimension margeHorizontale = new Dimension(20, 20);
	private static final Dimension margeVerticaleScroll = new Dimension(40, 5);
	private static final Dimension margeHorizontaleScroll = new Dimension(5, 20);
	private static final Font font = new Font("Arial", Font.BOLD, 14);
	private static final Dimension dimensionField = new Dimension(130,
			(int) PARAMETERS_IHM.dimensionTextField.getHeight());
	private static int insetValue = 10;
	private static final Insets insetTitle = new Insets(insetValue, 0,
			insetValue, 0);

	public PanelInfo(Model leModel) {
		this.setLayout(new BorderLayout());
		this.model = leModel;

		this.add(Box.createRigidArea(margeHorizontale), BorderLayout.EAST);
		this.add(Box.createRigidArea(margeHorizontale), BorderLayout.WEST);
		this.add(Box.createRigidArea(margeVerticale), BorderLayout.NORTH);
		this.add(Box.createRigidArea(margeVerticale), BorderLayout.SOUTH);
		JPanel panelScroll = new JPanel(new BorderLayout());
		panelScroll.add(Box.createRigidArea(margeVerticaleScroll),
				BorderLayout.NORTH);
		panelScroll.add(Box.createRigidArea(margeVerticaleScroll),
				BorderLayout.SOUTH);
		panelScroll.add(Box.createRigidArea(margeHorizontaleScroll),
				BorderLayout.EAST);
		panelScroll.add(Box.createRigidArea(margeHorizontaleScroll),
				BorderLayout.WEST);

		this.panelCentral = new JPanel();
		panelScroll.add(panelCentral);

		this.panelCentral.setLayout(new BoxLayout(this.panelCentral,
				BoxLayout.Y_AXIS));
		JScrollPane scroll = new JScrollPane(panelScroll);
		this.add(scroll);
		this.buildPanelHaut();
		this.buildPanelMoyen();
		this.buildPanelSupplementaire1();
		this.buildPanelSupplementaire1Bis();
		this.buildPanelSupplementaire2();
		this.buildPanelBas();
		this.setControllers();
		if (this.model.getProjet() != null) {
			this.fillWith(this.model.getProjet());
		}

		valider = new JButton("valider");
		valider.setBackground(Color.red);
		valider.addMouseListener(new ValideInfoGenProjetController(this,
				this.model));
		JPanel wrapper = new JPanel();
		wrapper.add(valider);
		this.add(wrapper, BorderLayout.SOUTH);
	}

	private void setControllers() {

		// Mise à jour du modèle
		InfoGenProjetCheckBoxController.AutreLieuDevController lieuDevController = new AutreLieuDevController(
				this.model, this.autreLieu);
		InfoGenProjetCheckBoxController.AutrePreuveController preuveController = new AutrePreuveController(
				this.lAutres, this.model);
		InfoGenProjetCheckBoxController.ConsultantController consulController = new ConsultantController(
				consultantBox, model);
		InfoGenProjetCheckBoxController.RedacteurImpliqueController redacteurImpliqueController = new RedacteurImpliqueController(
				employeImpliqueBox, model);

		InfoGenProjetCheckBoxController.RedacteurAutreController redacteurAutreController = new RedacteurAutreController(
				autreEmployeBox, model);

		InfoGenProjetCheckBoxController.TypeRechercheController typeRechercheController = new TypeRechercheController(
				recherchePure, model);

		this.autreLieu.addItemListener(lieuDevController);
		this.lAutres.addItemListener(preuveController);
		this.consultantBox.addItemListener(consulController);
		this.employeImpliqueBox.addItemListener(redacteurImpliqueController);
		this.autreEmployeBox.addItemListener(redacteurAutreController);
//		this.recherchePure.addItemListener(typeRechercheController);
//		this.developpementExp.addItemListener(typeRechercheController);
		// Mise à jour de l'IHM
		if (this.model.getProjet() != null) {
			this.model.getProjet().getInformationsGenerales()
					.addObserver(new InfoProjetController(this, this.model));
		}

	}

	/**
	 * Haut du panel : du titre du projet à "projet conjoint" non inclus.
	 */
	private void buildPanelHaut() {
		JPanel panelHaut = new JPanel();
		this.panelCentral.add(panelHaut);
		panelHaut.setLayout(new GridBagLayout());

		JLabel titreLabel = new JLabel("Titre du projet");
		JLabel numeroLabel = new JLabel("Numéro du projet");
		JLabel respoLabel = new JLabel("Responsable du projet");
		JLabel reclamLabel = new JLabel(
				"Est ce que ce projet a fait l'objet d'une première réclamation ?");
		JLabel debutLabel = new JLabel("Date de début du projet");
		JLabel finLabel = new JLabel("Date de fin réelle ou prévue");
		JLabel domaineLabel = new JLabel(
				"Domaine de la science ou de la technologie");
		JLabel butLabel = new JLabel("But des travaux");
		JLabel objectifLabel = new JLabel("Objectif du progrès technologique :");

		titreField = new JTextField();
		titreField.setEditable(false);
		titreField.setPreferredSize(PARAMETERS_IHM.dimensionTextField);

		numeroField = new JTextField();
		numeroField.setEditable(false);
		numeroField.setPreferredSize(PARAMETERS_IHM.dimensionTextField);

		respoField = new JTextField();
		respoField.setPreferredSize(PARAMETERS_IHM.dimensionTextField);

		premiereReclam = new JRadioButton("oui");
		pasPremiereReclam = new JRadioButton("non");
		pasPremiereReclam.setSelected(true);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(premiereReclam);
		buttonGroup.add(pasPremiereReclam);

		debutChooser = new JDateChooser(null, PARAMETERS_IHM.dateFormat);
		finChooser = new JDateChooser(null, PARAMETERS_IHM.dateFormat);

		domaineCombo = new JComboBox<CodeDomaineScience>(
				CodeDomaineScience.values());
		developpementExp = new JCheckBox("Développement expérimental");
		recherchePure = new JCheckBox("Recherche pure et appliquée");
		ButtonGroup buttonGroupBut = new ButtonGroup();
		buttonGroupBut.add(developpementExp);
		buttonGroupBut.add(recherchePure);

		devMat = new JCheckBox(
				"<html>Développement de matériaux,<br> dispositifs ou produits<html>");
		amMat = new JCheckBox(
				"<html>Amélioration de matériaux,<br> dispositifs ou produits<html>");
		devProc = new JCheckBox("Développement de procédé");
		amProc = new JCheckBox("Amélioration d'un procédé");

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.anchor = GridBagConstraints.LINE_START;

		// titreLabel
		panelHaut.add(titreLabel, cons);

		// titreField
		cons.gridx = 1;
		cons.gridwidth = 2;
		panelHaut.add(titreField, cons);

		// numeroLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(numeroLabel, cons);

		// numeroField
		cons.gridx = 1;
		cons.gridwidth = 2;
		panelHaut.add(numeroField, cons);

		// respoLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(respoLabel, cons);

		// respoField
		cons.gridx = 1;
		cons.gridwidth = 2;
		panelHaut.add(respoField, cons);

		// reclamLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		cons.weightx = 0;
		panelHaut.add(reclamLabel, cons);

		// premiereReclam
		cons.gridx = 1;
		cons.weightx = 0;
		panelHaut.add(premiereReclam, cons);

		// pasPremiereReclam
		cons.gridx = 2;
		cons.weightx = 1;
		panelHaut.add(pasPremiereReclam, cons);

		// debutLabel
		cons.gridx = 0;
		cons.gridy++;
		panelHaut.add(debutLabel, cons);

		// debutChooser
		cons.gridx = 1;
		cons.gridwidth = 2;
		panelHaut.add(debutChooser, cons);

		// finLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(finLabel, cons);

		// finChooser
		cons.gridx = 1;
		cons.gridwidth = 2;
		panelHaut.add(finChooser, cons);

		// domaineLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(domaineLabel, cons);

		// domaineCombo
		cons.gridx = 1;
		cons.gridwidth = 2;
		panelHaut.add(domaineCombo, cons);

		// butLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(butLabel, cons);

		// developpementExp
		cons.gridx = 1;
		cons.weightx = 0;
		panelHaut.add(developpementExp, cons);

		// recherchePure
		cons.gridx = 2;
		cons.gridwidth = 2;
		cons.weightx = 1;
		panelHaut.add(recherchePure, cons);

		//

		// objectifLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(objectifLabel, cons);

		// devMat
		cons.gridy++;
		panelHaut.add(devMat, cons);

		// amMat
		cons.gridx = 1;
		cons.gridwidth = 2;
		panelHaut.add(amMat, cons);

		// devProc
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 1;
		panelHaut.add(devProc, cons);

		// amProc
		cons.gridx = 1;
		cons.gridwidth = 2;
		panelHaut.add(amProc, cons);

	}

	/**
	 * Construit le panel regroupant les questions de l'onglet
	 * "informations générales" de l'onglet projet, allant de :
	 * "projet conjoint" à "lieu de développement" tout inclus
	 */
	private void buildPanelMoyen() {
		JPanel panelMoyen = new JPanel();
		this.panelCentral.add(panelMoyen);
		panelMoyen.setLayout(new BoxLayout(panelMoyen, BoxLayout.Y_AXIS));

		// Projet conjoint
		JPanel panelProjetConjoint = new JPanel(new GridBagLayout());
		panelMoyen.add(panelProjetConjoint);
		JLabel conjointTitleLabel = new JLabel("Projet conjoint");
		conjointTitleLabel.setFont(font);
		JLabel conjointLabel = new JLabel(
				"<html>Est-ce un projet mené, en tout ou en partie <br> conjointement"
						+ " ou en collaboration avec d'autres entreprises ? :<html>");

		conjoint = new JRadioButton("oui");
		nonConjoint = new JRadioButton("non");
		nonConjoint.setSelected(true);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(conjoint);
		buttonGroup.add(nonConjoint);
		GridBagConstraints consConjoint = new GridBagConstraints();
		// conjointTitleLabel
		consConjoint.gridx = 0;
		consConjoint.gridy = 0;
		consConjoint.gridwidth = 1;
		consConjoint.weightx = 0;
		consConjoint.anchor = GridBagConstraints.LINE_START;
		consConjoint.insets = insetTitle;
		panelProjetConjoint.add(conjointTitleLabel, consConjoint);
		// conjointLabel
		consConjoint.gridy++;
		consConjoint.insets = new Insets(0, 0, 0, 10);
		panelProjetConjoint.add(conjointLabel, consConjoint);
		// conjoint (radio)
		consConjoint.gridx++;
		consConjoint.insets = new Insets(0, 0, 0, 0);
		consConjoint.weightx = 0.1;
		panelProjetConjoint.add(conjoint, consConjoint);
		// nonConjoint (radio)
		consConjoint.gridx++;
		consConjoint.weightx = 0.9;
		panelProjetConjoint.add(nonConjoint, consConjoint);

		// Lieu de développement
		JPanel panelLieu = new JPanel();
		panelLieu.setLayout(new GridBagLayout());
		panelMoyen.add(panelLieu);
		JLabel lieuLabel = new JLabel("Lieu de développement");
		lieuLabel.setFont(font);
		JLabel lieuLegendeLabel = new JLabel("Les travaux ont été effectués :");
		this.laboratoire = new JCheckBox("Dans un laboratoire");
		this.usineCom = new JCheckBox("Dans une usine commerciale");
		this.rechDediee = new JCheckBox(
				"Dans une installation de recherche dédiée");
		this.autreLieu = new JCheckBox("Autre, précisez :");
		this.autreLieuField = new JTextField();
		autreLieuField.setPreferredSize(dimensionField);
		autreLieuField.setEditable(false);
		// lieuLabel
		consConjoint.gridx = 0;
		consConjoint.gridy++;
		consConjoint.gridwidth = 1;
		consConjoint.weightx = 0;
		consConjoint.insets = new Insets(10, 0, 10, 0);
		panelLieu.add(lieuLabel, consConjoint);
		// lieuLegendeLabel
		consConjoint.gridy++;
		consConjoint.insets = new Insets(0, 0, 0, 0);
		panelLieu.add(lieuLegendeLabel, consConjoint);
		// laboratoire
		consConjoint.gridy++;
		consConjoint.weightx = 0.01;
		panelLieu.add(laboratoire, consConjoint);
		// usineCom
		consConjoint.gridx = 1;
		consConjoint.weightx = 0.99;
		consConjoint.gridwidth = 2;
		panelLieu.add(usineCom, consConjoint);
		// rechDediee
		consConjoint.gridx = 0;
		consConjoint.weightx = 0.01;
		consConjoint.gridy++;
		consConjoint.gridwidth = 1;
		panelLieu.add(rechDediee, consConjoint);
		// autreLieu
		consConjoint.gridx = 1;
		consConjoint.weightx = 0.01;
		consConjoint.gridwidth = 1;
		panelLieu.add(autreLieu, consConjoint);
		// autreLieuField
		consConjoint.gridx = 2;
		consConjoint.weightx = 0.98;
		consConjoint.gridwidth = 1;
		panelLieu.add(autreLieuField, consConjoint);

	}

	/**
	 * Renseignements supplémentaires : qui a rédigé les réponses de la section
	 * B ou de la section C ?
	 */
	private void buildPanelSupplementaire1() {
		JPanel panel = new JPanel(new GridBagLayout());
		this.panelCentral.add(panel);
		JLabel titreLabel = new JLabel("Renseignements supplémentaires");
		titreLabel.setFont(font);
		JLabel legendeLabel = new JLabel(
				"Qui a rédigé les réponses de la section B ou de la section C (cochez puis précisez le nom) ?");
		employeImpliqueBox = new JCheckBox(
				"Employé directement impliqué dans le projet");
		autreEmployeBox = new JCheckBox("Autre employé de l'entreprise");
		consultantBox = new JCheckBox("Consultant externe");

		Vector<Employee> emplImp = new Vector<Employee>();
		employeImpliqueCombo = new JComboBox<Employee>(emplImp);
		employeImpliqueCombo.setEnabled(false);
		autreEmployeCombo = new JComboBox<Employee>();
		autreEmployeCombo.setEnabled(false);

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.LINE_START;
		// titreLabel
		cons.insets = insetTitle;
		panel.add(titreLabel, cons);
		// legendeLabel
		cons.gridwidth = 2;
		cons.insets = new Insets(0, 0, 0, 0);
		cons.gridy++;
		panel.add(legendeLabel, cons);
		// employeImpliqueBox
		cons.gridwidth = 1;
		cons.gridy++;
		panel.add(employeImpliqueBox, cons);
		// autreEmployeBox
		cons.gridy++;
		panel.add(autreEmployeBox, cons);
		// employeImpliqueCombo
		cons.gridwidth = 2;
		cons.gridy = 2;
		cons.gridx++;
		cons.weightx = 1;
		panel.add(employeImpliqueCombo, cons);
		// autreEmployeCombo
		cons.gridy++;
		panel.add(autreEmployeCombo, cons);

	}

	private void buildPanelSupplementaire1Bis() {
		JLabel nomConsultantLabel = new JLabel("nom :");
		JLabel nomFirmeLabel = new JLabel("firme :");
		consultantField = new JTextField();
		consultantField.setPreferredSize(dimensionField);
		consultantField.setEditable(false);
		firmeField = new JTextField();
		firmeField.setPreferredSize(dimensionField);
		firmeField.setEditable(false);

		JPanel panelConsultant = new JPanel(new GridBagLayout());
		this.panelCentral.add(panelConsultant);
		GridBagConstraints cons = new GridBagConstraints();
		cons.weightx = 0;
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.insets = new Insets(0, 0, 0, insetValue);
		cons.anchor = GridBagConstraints.LINE_START;

		// consultantBox
		panelConsultant.add(consultantBox, cons);
		// consultantNomLabel
		cons.gridx++;
		panelConsultant.add(nomConsultantLabel, cons);
		// consultantField
		cons.gridx++;
		panelConsultant.add(consultantField, cons);
		// nomFirmeLabel
		cons.gridx++;
		panelConsultant.add(nomFirmeLabel, cons);
		// firmeField
		cons.gridx++;
		cons.weightx = 1;
		panelConsultant.add(this.firmeField, cons);
	}

	/**
	 * Dépenses de traitements ou salaires pour la RSDE à l'étranger ou le
	 * compte d'une autre partie ?
	 */
	private void buildPanelSupplementaire2() {

		JPanel panel = new JPanel(new GridBagLayout());
		this.panelCentral.add(panel);
		JLabel quEtrangerLabel = new JLabel(
				"Demandez vous des dépenses de traitements ou salaires pour la RSDE exercée à l'étranger ?");
		JLabel quPartieLabel = new JLabel(
				"Demandez vous des dépenses pour la RS&DE exercée pour le compte d'une autre partie ?");
		JLabel quAutreEmployeLabel = new JLabel(
				"Demandez vous des dépenses pour la RS&DE effectuée par des personnes autres que vos employés ?");
		ouiSalaireEtranger = new JRadioButton("oui");
		nonSalaireEtranger = new JRadioButton("non");
		nonSalaireEtranger.setSelected(true);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(ouiSalaireEtranger);
		buttonGroup.add(nonSalaireEtranger);
		ouiAutrePartie = new JRadioButton("oui");
		nonAutrePartie = new JRadioButton("non");
		nonAutrePartie.setSelected(true);
		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(ouiAutrePartie);
		buttonGroup2.add(nonAutrePartie);
		ouiAutreEmploye = new JRadioButton("oui");
		nonAutreEmploye = new JRadioButton("non");
		nonAutreEmploye.setSelected(true);
		ButtonGroup buttonGroup3 = new ButtonGroup();
		buttonGroup3.add(ouiAutreEmploye);
		buttonGroup3.add(nonAutreEmploye);

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 3;
		cons.weightx = 1;
		cons.anchor = GridBagConstraints.LINE_START;
		cons.insets = new Insets(insetValue, 0, 0, 0);

		// quEtrangerLabel
		panel.add(quEtrangerLabel, cons);
		// ouiSalaireEtranger
		cons.insets = new Insets(0, 0, 0, 0);
		cons.gridy++;
		cons.gridwidth = 1;
		cons.weightx = 0;
		panel.add(ouiSalaireEtranger, cons);
		// nonSalaireEtranger
		cons.gridx++;
		cons.weightx = 1;
		panel.add(nonSalaireEtranger, cons);
		// quPartieLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 3;
		cons.weightx = 1;
		panel.add(quPartieLabel, cons);
		// ouiAutrePartie
		cons.gridy++;
		cons.gridwidth = 1;
		cons.weightx = 0;
		panel.add(ouiAutrePartie, cons);
		// nonAutrePartie
		cons.gridx++;
		cons.weightx = 1;
		panel.add(nonAutrePartie, cons);
		// quAutreEmployeLabel
		cons.gridx = 0;
		cons.gridy++;
		cons.gridwidth = 3;
		panel.add(quAutreEmployeLabel, cons);
		// ouiAutreEmploye
		cons.gridx = 0;
		cons.gridy++;
		cons.weightx = 0;
		cons.gridwidth = 1;
		panel.add(ouiAutreEmploye, cons);
		// nonAutreEmploye
		cons.gridx++;
		cons.weightx = 1;
		panel.add(nonAutreEmploye, cons);
	}

	/**
	 * Quelles preuves sont disponibles à l'appui des travaux visés par la
	 * demande ?
	 */
	private void buildPanelBas() {
		JPanel panel = new JPanel(new GridBagLayout());
		this.panelCentral.add(panel);
		JLabel questionLabel = new JLabel(
				"Quelles preuves sont disponibles à l'appui des travaux visés par la demande ?");
		this.aDocPlanif = new JCheckBox("Documents de planification");
		this.bRegistreAttrib = new JCheckBox(
				"Registre d'attribution des ressources au projet, feuilles de temps");
		this.cConcEssai = new JCheckBox("Conceptions d'essais");
		this.dRegProj = new JCheckBox(
				"Registre du projet, carnet de laboratoire");
		this.eCodeSource = new JCheckBox(
				"Conception, architecture du système et code source");
		this.fRegEssai = new JCheckBox("Registre des essais");
		this.gRapProg = new JCheckBox(
				"Rapport de progrès et comptes rendus de rencontres de projet");
		this.hProtEssai = new JCheckBox(
				"Protocoles d'essais, données d'essais, analyse des résultats d'essais, conclusion");
		this.iPhoto = new JCheckBox("Photographies et vidéos");
		this.jEchant = new JCheckBox(
				"Echantillons, prototypes, rebuts ou autres artefacts");
		this.kContrat = new JCheckBox("Contrats");
		this.lAutres = new JCheckBox("Autres, précisez :");
		this.autrePreuve = new JTextField();
		this.autrePreuve.setPreferredSize(dimensionField);
		this.autrePreuve.setEditable(false);

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.LINE_START;

		// questionLabel
		panel.add(questionLabel, cons);

		// aDocPlanif
		cons.gridy++;
		panel.add(aDocPlanif, cons);

		// bRegistreAttrib
		cons.gridy++;
		panel.add(bRegistreAttrib, cons);
		// cConcEssai
		cons.gridy++;
		panel.add(cConcEssai, cons);
		// dRegProj
		cons.gridy++;
		panel.add(dRegProj, cons);
		// eCodeSource
		cons.gridy++;
		panel.add(eCodeSource, cons);
		// fRegEssai
		cons.gridy++;
		panel.add(fRegEssai, cons);
		// NOUVELLE COLONNE
		// gRapPro
		cons.weightx = 1;
		cons.gridx = 1;
		cons.gridwidth = 2;
		cons.gridy = 1;
		panel.add(gRapProg, cons);
		// hProtEssai
		cons.gridy++;
		panel.add(hProtEssai, cons);
		// iPhoto
		cons.gridy++;
		panel.add(iPhoto, cons);
		// jEchant
		cons.gridy++;
		panel.add(jEchant, cons);
		// kContrat
		cons.gridy++;
		panel.add(kContrat, cons);
		// lAutres;
		cons.gridy++;
		cons.gridwidth = 1;
		cons.weightx = 0;
		panel.add(lAutres, cons);
		// autrePreuve
		cons.gridx++;
		cons.weightx = 1;
		panel.add(autrePreuve, cons);
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public JTextField getRespoField() {
		return respoField;
	}

	public void setRespoField(JTextField respoField) {
		this.respoField = respoField;
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

	public JTextField getAutreLieuField() {
		return autreLieuField;
	}

	public JTextField getFirmeField() {
		return firmeField;
	}

	public JTextField getConsultantField() {
		return consultantField;
	}

	public JTextField getAutrePreuve() {
		return autrePreuve;
	}

	public JComboBox<Employee> getEmployeImpliqueCombo() {
		return employeImpliqueCombo;
	}

	public JComboBox<Employee> getAutreEmployeCombo() {
		return autreEmployeCombo;
	}

	public JButton getValider() {
		return valider;
	}

	/**
	 * Fill the panel fields with the values of the project model.
	 * 
	 * @param projet
	 */
	public void fillWith(Projet projet) {

		// Remplissage des JComboBox
		if (this.model.getProjet() != null) {
			this.employeImpliqueCombo
					.setModel(new DefaultComboBoxModel<Employee>(
							new Vector<Employee>(this.model.getProjet()
									.getEmployesImp().getList())));
			this.autreEmployeCombo.setModel(new DefaultComboBoxModel<Employee>(
					this.model.getProjet().getEmployesNonImpliques()));
		}

		// Remplissage des champs avec les valeurs du modèle
		InfoGeneralesProjet infos = projet.getInformationsGenerales();
		this.titreField.setText(projet.getNomProjet());
		this.numeroField.setText("" + projet.getNumero());
		this.respoField.setText(projet.getResponsable());
		this.premiereReclam.setSelected(infos.isPremiere_reclam());
		this.pasPremiereReclam.setSelected(!infos.isPremiere_reclam());
		this.debutChooser.setDate(projet.getDebut().getTime());
		this.finChooser.setDate(projet.getFin().getTime());
		this.domaineCombo.setSelectedItem(infos.getCodeDomaineScience());
		this.developpementExp
				.setSelected(infos.getButTravaux() == ButTravaux.DEV_EXP);
		this.recherchePure
				.setSelected(infos.getButTravaux() == ButTravaux.RECH_PURE_APP);
		ObjectifProjet objectif = infos.getObjectifs_projet();
		this.devMat.setSelected(objectif.isDev_materiaux());
		this.amMat.setSelected(objectif.isAm_materiaux());
		this.devProc.setSelected(objectif.isDev_proc());
		this.amProc.setSelected(objectif.isAm_proc());
		this.conjoint.setSelected(infos.isProjetConjoint());
		this.nonConjoint.setSelected(!infos.isProjetConjoint());
		this.laboratoire.setSelected(infos.getLieu_dev().isLabo());
		this.usineCom.setSelected(infos.getLieu_dev().isUsine_comm());
		this.rechDediee.setSelected(infos.getLieu_dev().isInstall_dediee());
		this.autreLieu.setSelected(infos.getLieu_dev().isAutre());
		this.autreLieuField.setText(infos.getLieu_dev().getValueAutre());
		this.employeImpliqueBox.setSelected(infos.getRedacteurs()
				.isEmploye_implique_boolean());
		this.autreEmployeBox.setSelected(infos.getRedacteurs()
				.isAutre_employe_boolean());
		this.consultantBox.setSelected(infos.getRedacteurs().isConsultant());
		this.consultantField.setText(infos.getRedacteurs()
				.getConsultant_externe());
		this.firmeField.setText(infos.getRedacteurs().getFirme_consultant());
		ouiSalaireEtranger.setSelected(infos.isDepenses_etranger());
		nonSalaireEtranger.setSelected(!infos.isDepenses_etranger());
		ouiAutrePartie.setSelected(infos.isDepenses_autre_partie());
		nonAutrePartie.setSelected(!infos.isDepenses_autre_partie());
		ouiAutreEmploye.setSelected(infos.isDepenses_pas_employes());
		nonAutreEmploye.setSelected(!infos.isDepenses_pas_employes());

		PreuvesAppui evidence = infos.getPreuvesAppui();
		aDocPlanif.setSelected(evidence.isaDoc_planif());
		bRegistreAttrib.setSelected(evidence.isBRegistres_attrib());
		cConcEssai.setSelected(evidence.isCConcep_essais());
		dRegProj.setSelected(evidence.isDRegistre_carnet());
		eCodeSource.setSelected(evidence.isEConception());
		fRegEssai.setSelected(evidence.isFRegistre_essais());
		gRapProg.setSelected(evidence.isGRapports_progres());
		hProtEssai.setSelected(evidence.isHProtoc_essais());
		iPhoto.setSelected(evidence.isIPhoto_video());
		jEchant.setSelected(evidence.isJEchant_proto());
		kContrat.setSelected(evidence.isKContrats());
		lAutres.setSelected(evidence.isAutresBoolean());

		autrePreuve.setText(evidence.getAutresString());

	}

	/**
	 * Generates an InfoGeneralesProjet from the filled fields.
	 * 
	 * @return
	 */
	public InfoGeneralesProjet generateInfo() {

		boolean premiereReclam = this.premiereReclam.isSelected();
		CodeDomaineScience code = (CodeDomaineScience) this.domaineCombo
				.getSelectedItem();
		ButTravaux but = this.developpementExp.isSelected() ? ButTravaux.DEV_EXP
				: ButTravaux.RECH_PURE_APP;
		ObjectifProjet objectif = new ObjectifProjet();
		objectif.setAm_materiaux(amMat.isSelected());
		objectif.setAm_proc(amProc.isSelected());
		objectif.setDev_materiaux(devMat.isSelected());
		objectif.setDev_proc(devProc.isSelected());
		boolean projetConjoint = this.conjoint.isSelected();
		LieuDeveloppement lieu = new LieuDeveloppement();
		lieu.setUsine_comm(usineCom.isSelected());
		lieu.setInstall_dediee(rechDediee.isSelected());
		lieu.setLabo(laboratoire.isSelected());
		lieu.setValueAutre(autreLieuField.getText());
		lieu.setAutre(autreLieu.isSelected());

		RenseignementsRedac rens = new RenseignementsRedac();
		rens.setAutre_employe_boolean(autreEmployeBox.isSelected());
		rens.setConsultant(consultantBox.isSelected());
		rens.setConsultant_externe(consultantField.getText());
		rens.setEmploye_implique_boolean(employeImpliqueBox.isSelected());
		rens.setFirme_consultant(firmeField.getText());
		rens.setAutre_employe((Employee) autreEmployeCombo.getSelectedItem());
		rens.setEmploye_implique((Employee) employeImpliqueCombo
				.getSelectedItem());

		boolean salaireEtranger = ouiSalaireEtranger.isSelected();
		boolean autrePartie = ouiAutrePartie.isSelected();
		boolean autreEmployeDepense = ouiAutreEmploye.isSelected();

		PreuvesAppui preuves = new PreuvesAppui();
		preuves.setADoc_planif(aDocPlanif.isSelected());
		preuves.setBRegistres_attrib(bRegistreAttrib.isSelected());
		preuves.setCConcep_essais(cConcEssai.isSelected());
		preuves.setDRegistre_carnet(dRegProj.isSelected());
		preuves.setEConception(eCodeSource.isSelected());
		preuves.setFRegistre_essais(fRegEssai.isSelected());
		preuves.setGRapports_progres(gRapProg.isSelected());
		preuves.setHProtoc_essais(hProtEssai.isSelected());
		preuves.setIPhoto_video(iPhoto.isSelected());
		preuves.setJEchant_proto(jEchant.isSelected());
		preuves.setKContrats(kContrat.isSelected());
		preuves.setAutresBoolean(lAutres.isSelected());
		preuves.setAutresString(autrePreuve.getText());

		InfoGeneralesProjet toRet = new InfoGeneralesProjet(premiereReclam,
				code, but, preuves, objectif, lieu, projetConjoint,
				salaireEtranger, autrePartie, autreEmployeDepense, rens);
		return toRet;
	}
}
