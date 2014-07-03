package com.xyz.myproject.GUI.presentation.projet;

import java.awt.Window;

import com.xyz.myproject.GUI.controller.AddDepenseSTDialogController;
import com.xyz.myproject.GUI.controller.AddDepenseSTDialogController.AddDepenseSTRDDialogController;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.DepenseAbstract;
import com.xyz.myproject.model.projet.DepenseST_RD;
import com.xyz.myproject.model.projet.DepensesSousTraitance;

/**
 * Voir AddSTDepDialog
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class AddSTDepRDDialog extends AddSTDepDialog<DepenseST_RD, AddDepenseSTDialogController.AddDepenseSTRDDialogController> {

	public AddSTDepRDDialog(String titre, DepenseAbstract depense,
			Window proprio, Model model) {
		super(titre, depense, proprio, model);
	}

	@Override
	protected DepensesSousTraitance<DepenseST_RD> getInstance() {
		return this.model.getProjet().getDepenses().getSout_rd();
	}

	@Override
	protected AddDepenseSTRDDialogController getController() {
		return new AddDepenseSTRDDialogController(owner, model);
	}

	

}
