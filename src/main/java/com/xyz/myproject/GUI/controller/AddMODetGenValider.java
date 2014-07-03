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
 * COntroleur du panel des traitements et salaire. G�re la mise � jour des
 * JTextField en cas de changement du mod�le (implements Observer) et met � jour
 * le mod�le avec les valeurs des JTextField lors d'un clic sur le bouton
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
	 * Action lors d'un clic sur le bouton valider : on passe au mod�le les
	 * valeurs des JTextField pour les salaires des employ�s non d�termin�s, et
	 * les salaires non pay�s [...] (l315)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Main d'oeuvre non d�termin�e canada
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

		// Boni non d�termin�e canada
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
		// Main d'oeuvre non d�termin�e �tranger
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
		
		//Salaires non pay�s durant les 180 jours suivant l'imposition
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
