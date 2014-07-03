package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.xyz.myproject.model.projet.DepensesSousTraitance.DEP_ST;

/**
 * Rafraichit la table des dépenses de sous traitance lors de l'ajout d'une dépense.
 * @author Raoul
 *
 */
public class MAJTabDepST implements Observer {

	private JTable table;

	public MAJTabDepST(JTable table) {
		super();
		this.table = table;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1==DEP_ST.MODIF){
			((AbstractTableModel)table.getModel()).fireTableDataChanged();
		}
		
	}

}
