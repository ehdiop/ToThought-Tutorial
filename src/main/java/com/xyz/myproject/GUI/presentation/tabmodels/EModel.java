package com.xyz.myproject.GUI.presentation.tabmodels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Implémentation des commandes de base pour un AbstractTableModel de JTable
 * dont le modèle attaché (model) est une liste
 * 
 * @author Raoul
 * 
 * @param <E>
 */
@SuppressWarnings("serial")
public abstract class EModel<E> extends AbstractTableModel {

	protected List<E> model;
	protected static String[] entete;

	public EModel(List<E> model) {
		this.model = model;
	}

	public EModel() {
		this(new ArrayList<E>());
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return model.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}

	@Override
	public abstract Object getValueAt(int rowIndex, int columnIndex);

	public List<E> getModel() {
		return model;
	}

	public void setModel(List<E> model) {
		this.model = model;
	}

}
