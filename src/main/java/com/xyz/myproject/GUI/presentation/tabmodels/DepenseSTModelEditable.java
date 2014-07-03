package com.xyz.myproject.GUI.presentation.tabmodels;

import javax.swing.table.AbstractTableModel;

import com.xyz.myproject.model.general.RD1029Partie2;
import com.xyz.myproject.model.general.SousTraitant;

/**
 * Modèle utilisé pour la JTable dans la partie 2 du RD1029
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class DepenseSTModelEditable extends AbstractTableModel {

	private RD1029Partie2 model;

	private String[] entete = { "Sous traitant", "partie versée dans l'année" };

	public DepenseSTModelEditable(RD1029Partie2 model) {
		super();
		this.model = model;
	}

	@Override
	public String getColumnName(int col) {
		return entete[col];
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
	public Object getValueAt(int row, int col) {
		if (col == 0) {
			return this.getSousTraitant(row);
		} else {
			return this.getMontant(row);
		}
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		try {
			this.model.put(this.getSousTraitant(row), Double.parseDouble((String)value));
			this.fireTableCellUpdated(row, col);
		} catch (Exception e) {

		}
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return col == 1 && row < this.getRowCount();
	}

	public SousTraitant getSousTraitant(int row) {
		return (SousTraitant) model.keySet().toArray()[row];
	}

	public Double getMontant(int row) {
		return model.get(getSousTraitant(row));
	}

}
