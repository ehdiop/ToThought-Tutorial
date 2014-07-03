package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.GUI.presentation.general.PanelMO;
import com.xyz.myproject.model.general.DepensesGenerales;
import com.xyz.myproject.model.general.InfoGenerales.INFOGE;
import com.xyz.myproject.model.general.TSGeneral.TSGEN;
import com.xyz.myproject.model.general.TSGeneralCanada;
import com.xyz.myproject.model.general.TSGeneralCanada.EVENT_TSGEN_CA;
import com.xyz.myproject.model.general.TSGeneralEtr;
import com.xyz.myproject.model.general.TSGeneralEtr.TSGEN_ETR;
import com.xyz.myproject.model.projet.DossierAnnee;

/**
 * COntroleur du panel des traitements et salaire. Gère la mise à jour des
 * JTextField en cas de changement du modèle (implements Observer) et met à jour
 * le modèle avec les valeurs des JTextField lors d'un clic sur le bouton
 * valider
 * 
 * @author Raoul
 * 
 */
public class AddMODetGenValider extends MouseAdapter implements Observer {

	private PanelMO panelMo;
	private DossierAnnee dossierAnnee;

	public AddMODetGenValider(PanelMO panelMo, DossierAnnee dossierAnnee) {
		super();
		this.panelMo = panelMo;
		this.dossierAnnee = dossierAnnee;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		DepensesGenerales depenses = dossierAnnee.getInfos().getDepenses();
		if (arg1 instanceof TSGEN) {

			TSGEN message = (TSGEN) arg1;
			switch (message) {
			case BONI:
				this.panelMo.getBoniField().setText(
						"" + depenses.gettSCanada().getBoni());

			}

		} else {
			if (arg1 instanceof EVENT_TSGEN_CA) {
				EVENT_TSGEN_CA message = (EVENT_TSGEN_CA) arg1;
				switch (message) {
				case MO_NON_DET:
					this.panelMo.getTsField().setText(
							"" + depenses.gettSCanada().getMo_non_determinee());
				}
			} else {
				if (arg1 instanceof TSGEN_ETR) {
					TSGEN_ETR message = (TSGEN_ETR) arg1;
					switch (message) {
					case MO_NON_DET:
						this.panelMo.getTsFieldEtranger().setText(
								""
										+ depenses.getTraitementEtr()
												.getMo_non_determinee());
					}
				} else {
					if (arg1 == INFOGE.MODIF) {
						this.panelMo.getNonPayesField().setText(
								""
										+ dossierAnnee.getInfos()
												.getSalairesNonPayes());
					}
				}

			}
		}

	}

	/**
	 * Action lors d'un clic sur le bouton valider : on passe au modèle les
	 * valeurs des JTextField pour les salaires des employés non déterminés, et
	 * les salaires non payés [...] (l315)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Main d'oeuvre non déterminée canada
		TSGeneralCanada tsGenCa = dossierAnnee.getInfos().getDepenses()
				.gettSCanada();
		double previousNonDetCa = tsGenCa.getMo_non_determinee();
		try {
			double nonDetCa = Double.parseDouble(this.panelMo.getTsField()
					.getText());
			if (tsGenCa.getMo_non_determinee() != nonDetCa) {
				tsGenCa.setMo_non_determinee(nonDetCa);
			}
		} catch (Exception ex) {
			this.panelMo.getTsField().setText("" + previousNonDetCa);
		}

		// Boni non déterminée canada
		double previousBoni = tsGenCa.getBoni();
		try {
			double boni = Double.parseDouble(this.panelMo.getBoniField()
					.getText());
			if (tsGenCa.getBoni() != boni) {
				tsGenCa.setBoni(boni);
			}
		} catch (Exception ex) {
			this.panelMo.getBoniField().setText("" + previousBoni);
		}

		TSGeneralEtr tsGenEtr = this.dossierAnnee.getInfos().getDepenses()
				.getTraitementEtr();
		// Main d'oeuvre non déterminée étranger
		double previousNonDetEtr = tsGenEtr.getMo_non_determinee();
		try {
			double nonDetEtr = Double.parseDouble(this.panelMo
					.getTsFieldEtranger().getText());
			if (nonDetEtr != tsGenEtr.getMo_non_determinee()) {
				tsGenEtr.setMo_non_determinee(nonDetEtr);
			}
		} catch (Exception ex) {
			this.panelMo.getTsFieldEtranger().setText("" + previousNonDetEtr);
		}
		
		//Salaires non payés durant les 180 jours suivant l'imposition
		double previousNonPaye = this.dossierAnnee.getInfos().getSalairesNonPayes();
		try{
			double newNonPaye = Double.parseDouble(this.panelMo.getNonPayesField().getText());
			if(newNonPaye!=previousNonPaye){
				this.dossierAnnee.getInfos().setSalairesNonPayes(newNonPaye);
			}
		}
		catch(Exception ex){
			this.panelMo.getNonPayesField().setText(""+previousNonPaye);
		}
	}

}
