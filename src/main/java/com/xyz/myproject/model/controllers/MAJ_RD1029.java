package com.xyz.myproject.model.controllers;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.general.DepensesGenerales;
import com.xyz.myproject.model.general.RD1029;
import com.xyz.myproject.model.general.RD1029Partie2;
import com.xyz.myproject.model.general.SousTraitanceGenerale.SOUT_GEN;
import com.xyz.myproject.model.general.SousTraitanceRD;
import com.xyz.myproject.model.general.SousTraitanceSoutien;
import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.general.TSGeneral.SALAIRES;
import com.xyz.myproject.model.general.TSGeneralCanada;
import com.xyz.myproject.model.general.TSGeneralEtr;
import com.xyz.myproject.model.projet.DossierAnnee;
/**
 * Controllers observant les paramètres qui doivent modifier les valeurs par défaut du RD1029.7, pour
 * mettre à jour ces valeurs par défaut 
 * @author Raoul
 *
 */
public class MAJ_RD1029 {

	public static class MAJ_RD1029_SalairesCtrl implements Observer {

		private DossierAnnee dossierAnnee;

		public MAJ_RD1029_SalairesCtrl(DossierAnnee dossierAnnee) {
			super();
			this.dossierAnnee = dossierAnnee;
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			if (arg1 == SALAIRES.MODIF) {

				this.majSalaire();
			} else {
				if (arg1 == SOUT_GEN.MODIF) {
					this.majSout();
				}
			}
		}

		private void majSout() {
			RD1029 rd1029 = dossierAnnee.getRd1029();
			SousTraitanceRD stRd = dossierAnnee.getInfos().getDepenses()
					.getSout_rd();
			SousTraitanceSoutien stSoutien = dossierAnnee.getInfos()
					.getDepenses().getSout_soutien();
			rd1029.getPartie3().setbSTDep(
					(int) Math.round(stRd.getMontantVerseDep()
							+ stSoutien.getMontantVerseDep()));
			rd1029.getPartie3().setcSTNonDep(
					(int) Math.round(stRd.getMontantVerseNonDep()
							+ stSoutien.getMontantVerseNonDep()));
		}

		private void majSalaire() {
			RD1029 rd1029 = dossierAnnee.getRd1029();
			TSGeneralCanada tsGeneralCanada = dossierAnnee.getInfos()
					.getDepenses().gettSCanada();
			TSGeneralEtr tsGeneralEtr = dossierAnnee.getInfos().getDepenses()
					.getTraitementEtr();
			double sommeCa = tsGeneralCanada.getMo_determinee()
					+ tsGeneralCanada.getMo_non_determinee()
					+ tsGeneralCanada.getMo_soutien();
			double sommeEtr = tsGeneralEtr.getMo_non_determinee()
					+ tsGeneralEtr.getMo_determinee();
			int somme = (int) (sommeCa + sommeEtr);

			rd1029.getPartie3().setaContribuable(somme);
		}
	}

	public static class MAJ_RD1029_Partie2Ctrl implements Observer {

		private DepensesGenerales model;
		private RD1029Partie2 rd1029Partie2;

	

		public MAJ_RD1029_Partie2Ctrl(DepensesGenerales model,
				RD1029Partie2 rd1029Partie2) {
			super();
			this.model = model;
			this.rd1029Partie2 = rd1029Partie2;
		}



		@Override
		public void update(Observable arg0, Object arg1) {
			if (arg1 == SOUT_GEN.MODIF) {
				rd1029Partie2.clear();
				SousTraitanceRD stRd = model.getSout_rd();
				SousTraitanceSoutien stSout = model.getSout_soutien();
				for (SousTraitant st : model.getSout_rd().getDepenses()
						.keySet()) {
					if (st.isDep())continue;
					double montant = Math.round(stRd.getMontantVerse(st)
							+ stSout.getMontantVerse(st));
					rd1029Partie2.put(st, montant);
				}

			}

		}

	}

}
