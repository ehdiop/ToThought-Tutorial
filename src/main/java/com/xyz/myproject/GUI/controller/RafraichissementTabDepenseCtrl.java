package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.xyz.myproject.model.projet.DepensesProjet.DEP_PROJET;
import com.xyz.myproject.model.projet.DepensesSousTraitance.DEP_ST;

/**
 * Rafraichit la table des dépenses lors de l'ajout d'une dépense
 * @author Raoul
 *
 */
public class RafraichissementTabDepenseCtrl implements Observer {

	private JTable table;

	public RafraichissementTabDepenseCtrl(JTable table) {
		super();
		this.table = table;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == DEP_PROJET.MODIF || arg == DEP_ST.MODIF) {
			((AbstractTableModel) this.table.getModel()).fireTableDataChanged();
		}

	}

}
