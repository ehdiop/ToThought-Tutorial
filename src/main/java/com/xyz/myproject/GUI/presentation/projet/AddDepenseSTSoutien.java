package com.xyz.myproject.GUI.presentation.projet;

import java.awt.Window;

import com.xyz.myproject.GUI.controller.AddDepenseSTSoutienCtrl;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.DepenseST_Soutien;

/**
 * VOir AddDepenseST
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class AddDepenseSTSoutien extends AddDepenseST<DepenseST_Soutien, AddDepenseSTSoutienCtrl> {

	public AddDepenseSTSoutien(Window owner, Model model) {
		super(owner, model);
	}

	@Override
	public AddDepenseSTSoutienCtrl getController() {
		return new AddDepenseSTSoutienCtrl(model, this);
	}

}
