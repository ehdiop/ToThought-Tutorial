package com.xyz.myproject.GUI.presentation.tabmodels;

import javax.swing.table.AbstractTableModel;

import com.xyz.myproject.model.projet.DepenseSousTraitance;
import com.xyz.myproject.model.projet.DepensesSousTraitance;

/**
 * Modèle utilisé pour la JTable des dépenses de sous-traitance dans
 * projet>depenses>double clic sur sous-traitance
 * 
 * @author Raoul
 * 
 * @param <E>
 */
@SuppressWarnings("serial")
public class DepenseSTModel<E extends DepenseSousTraitance> extends
		AbstractTableModel {

	protected static String[] entete = new String[] { "Sous-traitant",
			"montant" };
	protected DepensesSousTraitance<E> model;

	public DepenseSTModel(DepensesSousTraitance<E> liste) {
		this.model = liste;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		E stGen = (E) this.model.getDepenses().values().toArray()[rowIndex];
		switch (columnIndex) {
		case 0:
			return stGen.getSousTraitant().getNom();
		case 1:
			return stGen.getMontant();
		default:
			return null;
		}

	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return this.model.getDepenses().size();
	}

	@Override
	public String getColumnName(int col) {
		return entete[col];
	}

}
