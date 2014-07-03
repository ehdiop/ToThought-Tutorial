package com.xyz.myproject.GUI.controller;

import java.awt.Window;

import com.xyz.myproject.GUI.presentation.projet.AddProjetDialog;
import com.xyz.myproject.model.Model;

/**
 * Controller ouvrant une nouvelle boite de dialogue d'ajout d'un projet.
 * @author Raoul
 *
 */
public class AddProjetGeneralController extends AddEController<AddProjetDialog> {
	
	private Model model;

	public AddProjetGeneralController(Window owner, Model model) {
		super(owner);
		this.model=model;
	}

	@Override
	public AddProjetDialog getInstance() {
		return new AddProjetDialog(this.model, owner);
	}

}
