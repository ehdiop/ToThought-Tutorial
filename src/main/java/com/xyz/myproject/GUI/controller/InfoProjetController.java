package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.GUI.presentation.projet.PanelInfo;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.InfoGeneralesProjet.INFOSPROJET;

/**
 * Met à jour le PanelInfo lorsque InfoGeneralesProjet est mis à jour, en
 * rendant certaines JTextField non éditables. L'observable est
 * InfoProjetController.
 */
public class InfoProjetController implements Observer {

	private PanelInfo panelInfo;

	private Model model;

	public InfoProjetController(PanelInfo panelInfo, Model model) {
		super();
		this.panelInfo = panelInfo;
		this.model = model;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 == INFOSPROJET.MODIF) {
			this.panelInfo.getAutreLieuField().setEditable(
					this.model.getProjet().getInformationsGenerales()
							.getLieu_dev().isAutre());
			this.panelInfo.getAutrePreuve().setEditable(
					this.model.getProjet().getInformationsGenerales()
							.getPreuvesAppui().isAutresBoolean());
			this.panelInfo.getFirmeField().setEditable(
					this.model.getProjet().getInformationsGenerales()
							.getRedacteurs().isConsultant());
			this.panelInfo.getConsultantField().setEditable(
					this.model.getProjet().getInformationsGenerales()
							.getRedacteurs().isConsultant());
			this.panelInfo.getEmployeImpliqueCombo().setEnabled(
					this.model.getProjet().getInformationsGenerales()
							.getRedacteurs().isEmploye_implique_boolean());
			this.panelInfo.getAutreEmployeCombo().setEnabled(
					this.model.getProjet().getInformationsGenerales()
							.getRedacteurs().isAutre_employe_boolean());
		}
	}

}
