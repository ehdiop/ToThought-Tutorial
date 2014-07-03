package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;

import com.xyz.myproject.GUI.presentation.tabmodels.TSMODetermineeModel;
import com.xyz.myproject.model.general.MapLigneMRVR.MAPMRVR;

/**
 * Controller observant la mise � jour des objets des tables dans l'onglet traitements et salaires (onglet
 * g�n�ral). D�clenche un fireTableDataChanged pour mettre � jour la table.
 * @author Raoul
 *
 */
public class AddMODetTableGenValiderController implements Observer {

	private JTable table;

	public AddMODetTableGenValiderController(JTable table) {
		this.table = table;
	}

	@Override
	public void update(Observable arg0, Object message) {
		
		if (message instanceof MAPMRVR) {
			((TSMODetermineeModel) table.getModel()).fireTableDataChanged();
		}
	}

}
