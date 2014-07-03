package com.xyz.myproject.GUI.presentation.tabmodels;

import javax.swing.table.AbstractTableModel;

import com.xyz.myproject.model.general.MRVR;
import com.xyz.myproject.model.general.MRVR.LigneTableau;
import com.xyz.myproject.model.general.MapLigneMRVR;

/**
 * Modèle utilisé pour la JTable des salaires des employés déterminés dans
 * l'onglet "traitements et salaires" de l'onglet général
 * 
 * @author Raoul
 * 
 */
public class TSMODetermineeModel extends AbstractTableModel {

	private static final long serialVersionUID = 8566812616863880655L;

	private MapLigneMRVR model;

	private static String[] entete = { "Nom", "Salaire annuel",
			"Pourcentage RSDE", "Nombre de jours travaillés" };

	public TSMODetermineeModel(MapLigneMRVR model) {
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
		return this.model.size();
	}

	@Override
	public Object getValueAt(int row, int column) {

		MRVR.LigneTableau ligneTableau = (LigneTableau) this.model.values()
				.toArray()[row];

		switch (column) {
		case 0:
			return ligneTableau.getEmploye();
		case 1:
			return ligneTableau.getTraitementsEmploye();
		case 2:
			return ligneTableau.getTempsConsacre();
		case 3:
			return ligneTableau.getNbJourW();

		}
		return null;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return row > -1 && row < this.getRowCount() && col > 0
				&& col < this.getColumnCount();
	}

	@Override
	public void setValueAt(Object val, int row, int col) {

		MRVR.LigneTableau ligneTableau = (MRVR.LigneTableau) this.model
				.values().toArray()[row];
		try {
			switch (col) {
			case 1:
				ligneTableau.setTraitementsEmploye((Double) Double
						.parseDouble((String) val));
				break;
			case 2:
				ligneTableau.setTempsConsacre((Double) Double
						.parseDouble((String) val));
				break;
			case 3:
				ligneTableau.setNbJourW((Integer) Integer
						.parseInt((String) val));
				break;
			}
		} catch (Exception e) {

		}
	}

}
