package com.xyz.myproject.GUI.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.ButTravaux;

/**
 * Ces controlleurs mettent à jour le modèle dynamiquement lors de changement
 * dans l'onglet "informations générales", car on souhaite mettre à jour l'ihm
 * dynamiquement (avant le clic sur valider), en rendant éditables certaines
 * JTextField lors de clics sur des combo box.
 * 
 * Sont concernés : - La JCheckBox "autre" dans lieu de développement - La
 * JCheckBox consultantBox dans "qui à rédigé la section C ou D ?" - La
 * JCheckBox lautres dans "quelles preuves sont disponibles à l'appui..."
 * (question du bas)
 * 
 * @author Raoul
 * 
 */
public class InfoGenProjetCheckBoxController {

	private JTextField autrePreuve;

	/**
	 * Gère la mise à jour de InfoGeneraleProjet, instance de projet, lors de la
	 * modification de la JCheckBox "autre" dans lieu de développement.
	 * 
	 * @author Raoul
	 * 
	 */
	public static class AutreLieuDevController implements ItemListener {
		private Model model;
		private JCheckBox autreLieu;

		public AutreLieuDevController(Model model, JCheckBox autreLieu) {
			super();
			this.model = model;
			this.autreLieu = autreLieu;
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			this.model.getProjet().getInformationsGenerales().getLieu_dev()
					.setAutre(autreLieu.isSelected());
		}

	}

	/**
	 * 
	 */
	public static class ConsultantController implements ItemListener {
		private JCheckBox consultantBox;
		private Model model;

		public ConsultantController(JCheckBox consultantBox, Model model) {
			super();
			this.consultantBox = consultantBox;
			this.model = model;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			this.model.getProjet().getInformationsGenerales().getRedacteurs()
					.setConsultant(consultantBox.isSelected());
		}

	}

	public static class AutrePreuveController implements ItemListener {
		private JCheckBox lAutres;
		private Model model;

		public AutrePreuveController(JCheckBox lAutres, Model model) {
			super();
			this.lAutres = lAutres;
			this.model = model;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			this.model.getProjet().getInformationsGenerales().getPreuvesAppui()
					.setAutresBoolean(this.lAutres.isSelected());
		}

	}

	public static class RedacteurImpliqueController implements ItemListener {
		private JCheckBox employeImpliqueBox;
		private Model model;

		public RedacteurImpliqueController(JCheckBox employeImpliqueBox,
				Model model) {
			super();
			this.employeImpliqueBox = employeImpliqueBox;
			this.model = model;
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			this.model
					.getProjet()
					.getInformationsGenerales()
					.getRedacteurs()
					.setEmploye_implique_boolean(
							employeImpliqueBox.isSelected());

		}

	}

	public static class RedacteurAutreController implements ItemListener {
		private JCheckBox autreEmployeBox;

		private Model model;

		public RedacteurAutreController(JCheckBox autreEmployeBox, Model model) {
			super();
			this.autreEmployeBox = autreEmployeBox;
			this.model = model;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			this.model.getProjet().getInformationsGenerales().getRedacteurs()
					.setAutre_employe_boolean(autreEmployeBox.isSelected());
		}
	}

	public static class TypeRechercheController implements ItemListener {
		private JCheckBox recherchePure;
		private Model model;

		public TypeRechercheController(JCheckBox recherchePure, Model model) {
			super();
			this.recherchePure = recherchePure;
			this.model = model;
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			this.model
					.getProjet()
					.getInformationsGenerales()
					.setButTravaux(
							this.recherchePure.isSelected() ? ButTravaux.RECH_PURE_APP
									: ButTravaux.DEV_EXP);
		}

	}

}
