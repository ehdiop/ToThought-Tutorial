package com.xyz.myproject.model.controllers;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import com.xyz.myproject.model.general.DepensesGenerales;
import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.projet.DepenseST_RD;
import com.xyz.myproject.model.projet.DepenseST_Soutien;
import com.xyz.myproject.model.projet.DepensesSousTraitance;
import com.xyz.myproject.model.projet.EVENT_DEP;
import com.xyz.myproject.model.projet.ListeProjet;
import com.xyz.myproject.model.projet.Projet;

/**
 * Ce controller met à jour les valeurs des dépenses générales (cad inter
 * projet), lorsque les dépenses d'un projet sont modifiées.
 * 
 * @author Raoul
 * 
 */
public class DepensesController implements Observer {

	private DepensesGenerales depensesGenerales;

	private ListeProjet listeProjet;

	public DepensesController(DepensesGenerales depensesGenerales,
			ListeProjet listeProjet) {
		super();
		this.depensesGenerales = depensesGenerales;
		this.listeProjet = listeProjet;
	}

	/**
	 * Méthode appelée lorsqu'une dépense d'un projet est mise à jour. Gros
	 * switch/case pour identifier quelle dépense a été mise à jour puis appel
	 * de la méthode mettant la dépense générale adequat à jour.
	 */
	@Override
	public void update(Observable arg0, Object message) {
		if(! (message instanceof EVENT_DEP))return;
		switch ((EVENT_DEP) message) {

		case EQ_50: {
			this.majEqt50();
		}
			;
			break;

		case EQ_90: {
			this.majEqt90();
		}
			;
			break;

		case ST_CA_DET: {
			this.maj_ST_CA_DET();
		}
			;
			break;

		case ST_CA_NON_DET: {
			this.maj_ST_CA_NON_DET();
		}
			;
			break;

		case ST_ETR_DET: {
			this.maj_ST_ETR_DET();
		}
			;
			break;

		case ST_ETR_NON_DET: {
			this.maj_ST_ETR_NON_DET();
		}
			;
			break;

		case ST_RSDE: {
			this.maj_ST_RSDE();
		}
			break;

		case ST_SOUT: {
			this.maj_ST_SOUTIEN();
		}
			break;

		case MAT_CONSO: {
			this.maj_MAT_CONSO();
		}
			break;

		case MAT_TRANSF: {
			this.maj_MAT_TRANSF();
		}
			break;
			
		case MO_SOUT : {
			this.maj_MO_SOUT();
		}

		case CHGT_PROJET: {
			this.maj_ST_CA_DET();
			this.maj_ST_CA_NON_DET();
			this.maj_ST_ETR_DET();
			this.maj_ST_ETR_NON_DET();
			this.maj_ST_RSDE();
			this.maj_ST_SOUTIEN();
			this.majEqt50();
			this.majEqt90();
		}
		}
	}

	private void maj_MO_SOUT() {
		double montant =0;
		
		for(Projet projet : listeProjet.getList()){
			montant += projet.getDepenses().getTsProjetCa().getMo_soutien();
		}
		this.depensesGenerales.gettSCanada().setMo_soutien(montant);
	}

	private void majEqt50() {
		double montant = 0;
		for (int i = 0; i < listeProjet.size(); i++) {
			montant += listeProjet.get(i).getDepenses().getEqt_50()
					.getMontant();
		}
		this.depensesGenerales.getEqt_50().setMontant(montant);
	}

	private void majEqt90() {
		double montant = 0;
		for (int i = 0; i < listeProjet.size(); i++) {
			montant += listeProjet.get(i).getDepenses().getEqt_90()
					.getMontant();
		}
		this.depensesGenerales.getEqt_90().setMontant(montant);
	}

	private void maj_ST_CA_DET() {
		double salaires = 0;
		for (int i = 0; i < listeProjet.size(); i++) {
			salaires += listeProjet.get(i).getDepenses().getTsProjetCa()
					.getMo_determinee();
		}
		this.depensesGenerales.gettSCanada().setMo_determinee(salaires);
	}

	private void maj_ST_CA_NON_DET() {
		double salaires = 0;
		for (int i = 0; i < listeProjet.size(); i++) {
			salaires += listeProjet.get(i).getDepenses().getTsProjetCa()
					.getMo_non_determinee();
		}
		this.depensesGenerales.gettSCanada().setMo_non_determinee(salaires);
	}

	private void maj_ST_ETR_DET() {
		double salaires = 0;
		for (int i = 0; i < listeProjet.size(); i++) {
			salaires += listeProjet.get(i).getDepenses().getTsProjetEtr()
					.getMo_determinee();
		}
		this.depensesGenerales.getTraitementEtr().setMo_determinee(salaires);
	}

	private void maj_ST_ETR_NON_DET() {
		double salaires = 0;
		for (int i = 0; i < listeProjet.size(); i++) {
			salaires += listeProjet.get(i).getDepenses().getTsProjetEtr()
					.getMo_non_determinee();
		}
		this.depensesGenerales.getTraitementEtr()
				.setMo_non_determinee(salaires);
	}

	private synchronized void maj_ST_RSDE() {
		this.depensesGenerales.getSout_rd().clear();

		for (int i = 0; i < listeProjet.size(); i++) {

			DepensesSousTraitance<DepenseST_RD> depsSoutProjet = listeProjet
					.get(i).getDepenses().getSout_rd();

			HashMap<SousTraitant, DepenseST_RD> depensesST = depsSoutProjet
					.getDepenses();

			Set<SousTraitant> keySet = depensesST.keySet();
			for(SousTraitant st: keySet){
				this.depensesGenerales.getSout_rd().addDepense(st,
						depensesST.get(st).getMontant());

			}

		}
		;
	}

	private void maj_ST_SOUTIEN() {
		this.depensesGenerales.getSout_soutien().clear();
		for (int i = 0; i < listeProjet.size(); i++) {
			 DepensesSousTraitance<DepenseST_Soutien> depsSoutProjet = listeProjet.get(i)
					.getDepenses().getSout_soutien();
			 HashMap<SousTraitant, DepenseST_Soutien> depenses = depsSoutProjet.getDepenses();
			 Set<SousTraitant> keySet = depenses.keySet();
			for(SousTraitant st : keySet){
				this.depensesGenerales.getSout_soutien().addDepense(st, depsSoutProjet.get(st).getMontant());
			}
		}
	}

	private void maj_MAT_TRANSF() {
		double mat_transf = 0;
		for (int i = 0; i < listeProjet.size(); i++) {
			Projet tmp = listeProjet.get(i);
			mat_transf += tmp.getDepenses().getMat_transf().getMontant();
		}
		this.depensesGenerales.getMat_transf().setMontant(mat_transf);
	}

	private void maj_MAT_CONSO() {
		double mat_conso = 0;
		for (int i = 0; i < listeProjet.size(); i++) {
			Projet tmp = listeProjet.get(i);
			mat_conso += tmp.getDepenses().getMat_conso().getMontant();
		}
		this.depensesGenerales.getMat_conso().setMontant(mat_conso);
	}

}
