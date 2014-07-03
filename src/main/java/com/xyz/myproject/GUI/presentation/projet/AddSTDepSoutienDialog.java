package com.xyz.myproject.GUI.presentation.projet;

import java.awt.Window;

import com.xyz.myproject.GUI.controller.AddDepenseSTDialogController;
import com.xyz.myproject.GUI.controller.AddDepenseSTDialogController.AddDepenseSTSoutienDialogController;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.DepenseAbstract;
import com.xyz.myproject.model.projet.DepenseST_Soutien;
import com.xyz.myproject.model.projet.DepensesSousTraitance;

/**
 * Voir AddSTDepDialog
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class AddSTDepSoutienDialog extends AddSTDepDialog<DepenseST_Soutien, AddDepenseSTDialogController.AddDepenseSTSoutienDialogController> {

	public AddSTDepSoutienDialog(String titre, DepenseAbstract depense,
			Window proprio, Model model) {
		super(titre, depense, proprio, model);
	}


	@Override
	protected DepensesSousTraitance<DepenseST_Soutien> getInstance() {
		return this.model.getProjet().getDepenses().getSout_soutien();
	}

	@Override
	protected AddDepenseSTSoutienDialogController getController() {
		return new AddDepenseSTSoutienDialogController(this.owner, model);
	}




}
