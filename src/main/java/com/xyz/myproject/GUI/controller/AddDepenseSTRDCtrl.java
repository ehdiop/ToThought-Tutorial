package com.xyz.myproject.GUI.controller;

import com.xyz.myproject.GUI.presentation.projet.AddDepenseST;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.projet.DepenseST_RD;
import com.xyz.myproject.model.projet.DepensesSousTraitance;
/**
 * Voir AddDepenseSTController
 * @author Raoul
 *
 */
public class AddDepenseSTRDCtrl extends AddDepenseSTController<DepenseST_RD> {

	public AddDepenseSTRDCtrl(Model model, AddDepenseST dialog) {
		super(model, dialog);
	}


	@Override
	public DepensesSousTraitance<DepenseST_RD> getDepensesST() {
		return this.model.getProjet().getDepenses().getSout_rd();
	}

	@Override
	public DepenseST_RD getInstance(double montant, SousTraitant st) {
		return new DepenseST_RD(montant,st);
	}


	@Override
	public void setDepense(DepenseST_RD dep) {
		this.model.getProjet().getDepenses().addSoutRSDE(dep);
	}


	



}
