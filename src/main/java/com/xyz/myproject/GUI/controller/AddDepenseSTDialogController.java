package com.xyz.myproject.GUI.controller;

import java.awt.Window;

import com.xyz.myproject.GUI.presentation.projet.AddDepenseSTRD;
import com.xyz.myproject.GUI.presentation.projet.AddDepenseSTSoutien;
import com.xyz.myproject.model.Model;

/**
 * Les controllers qui ouvrent la dialog pour l'ajout d'une dépense de sous traitance. Onglet projet->dépenses
 * @author Raoul
 *
 */
public class AddDepenseSTDialogController {

	public static class AddDepenseSTRDDialogController extends AddEController<AddDepenseSTRD>{
		private Model model;

		public AddDepenseSTRDDialogController(Window owner, Model model) {
			super(owner);
			this.model = model;
		}

		@Override
		public AddDepenseSTRD getInstance() {
			return new AddDepenseSTRD(owner, model);
		}
	}

	public static class AddDepenseSTSoutienDialogController extends
			AddEController<AddDepenseSTSoutien> {
		private Model model;

		public AddDepenseSTSoutienDialogController(Window owner, Model model) {
			super(owner);
			this.model = model;
		}

		@Override
		public AddDepenseSTSoutien getInstance() {
			return new AddDepenseSTSoutien(owner, model);
		}
	}

}
