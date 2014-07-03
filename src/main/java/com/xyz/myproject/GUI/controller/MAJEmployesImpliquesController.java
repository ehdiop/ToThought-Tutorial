package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.xyz.myproject.model.general.ListeEmployee.EMPLOYEE;

/**
 * Ce controller observe la mise à jour de la liste des employés, et notifie la liste des employés 
 * impliqués pour mettre à jour son affichage.
 * @author Raoul
 *
 */
public class MAJEmployesImpliquesController implements Observer {
	
	private JTable table;
	
	

	public MAJEmployesImpliquesController(JTable table) {
		super();
		this.table = table;
	}



	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1==EMPLOYEE.MODIF){
			((AbstractTableModel)table.getModel()).fireTableDataChanged();
		}

	}

}
