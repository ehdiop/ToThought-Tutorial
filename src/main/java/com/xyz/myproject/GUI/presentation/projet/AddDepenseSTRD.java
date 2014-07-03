package com.xyz.myproject.GUI.presentation.projet;

import java.awt.Window;

import com.xyz.myproject.GUI.controller.AddDepenseSTRDCtrl;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.DepenseST_RD;

/**
 * Voir AddDepenseST
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class AddDepenseSTRD extends AddDepenseST<DepenseST_RD, AddDepenseSTRDCtrl> {

	public AddDepenseSTRD(Window owner, Model model) {
		super(owner, model);
	}

	@Override
	public AddDepenseSTRDCtrl getController() {
		return new AddDepenseSTRDCtrl(model, this);
	}

}
