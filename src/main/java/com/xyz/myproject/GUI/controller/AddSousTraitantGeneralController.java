package com.xyz.myproject.GUI.controller;

import javax.swing.JDialog;
import javax.swing.JTable;

import com.xyz.myproject.GUI.presentation.general.AddSousTraitantDialog;
import com.xyz.myproject.model.projet.DossierClient;

/**
 * COntroller ouvrant une fen�tre d'ajout de sous-traitant lors d'un clic sur "ajouter" (onglet g�n�ral, sous
 * -traitants)
 * @author Raoul
 *
 */
public class AddSousTraitantGeneralController extends AddEController<AddSousTraitantDialog> {

	private JTable jtable;
	private DossierClient model;
	
	public AddSousTraitantGeneralController(JDialog owner, JTable table, DossierClient dossier) {
		super(owner);
		this.jtable=table;
		this.model=dossier;
	}

	@Override
	public AddSousTraitantDialog getInstance() {
		return new AddSousTraitantDialog(false,jtable,model);
	}

}
