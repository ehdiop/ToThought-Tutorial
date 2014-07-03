package com.xyz.myproject.GUI.controller;

import com.xyz.myproject.GUI.presentation.projet.AddDepenseST;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.projet.DepenseST_Soutien;
import com.xyz.myproject.model.projet.DepensesSousTraitance;

/**
 * Voir AddDepenseSTController
 * @author Raoul
 *
 */
public class AddDepenseSTSoutienCtrl extends AddDepenseSTController<DepenseST_Soutien> {

	public AddDepenseSTSoutienCtrl(Model model, AddDepenseST dialog) {
		super(model, dialog);
	}

	@Override
	public DepensesSousTraitance<DepenseST_Soutien> getDepensesST() {
		return this.model.getProjet().getDepenses().getSout_soutien();
	}

	@Override
	public DepenseST_Soutien getInstance(double montant, SousTraitant st) {
		return new DepenseST_Soutien(montant,st);
	}

	@Override
	public void setDepense(DepenseST_Soutien dep) {
		this.model.getProjet().getDepenses().addSoutSoutien(dep);
	}

}
