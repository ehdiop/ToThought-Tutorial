package com.xyz.myproject.GUI.controller;

import java.awt.Window;

import com.xyz.myproject.GUI.presentation.AjoutAnneeDialog;
import com.xyz.myproject.model.general.Client;

/**
 * Controller utilisé pour ouvrir une nouvelle boite de dialogue de type "ajout/edition d'année"
 * @author Raoul
 *
 */
public class AddAnneeGeneralController extends AddEController<AjoutAnneeDialog> {

	private Client model;
	private boolean edit;
	public AddAnneeGeneralController(Window owner, Client client, boolean edit) {
		super(owner);
		this.model= client;
		this.edit=edit;
	}

	@Override
	public AjoutAnneeDialog getInstance() {
		return new AjoutAnneeDialog(this.model,edit);
	}

}
