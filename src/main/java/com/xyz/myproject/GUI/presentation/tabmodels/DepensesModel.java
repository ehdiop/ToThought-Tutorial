package com.xyz.myproject.GUI.presentation.tabmodels;

import javax.swing.table.AbstractTableModel;

import com.xyz.myproject.model.projet.DepenseAbstract;
import com.xyz.myproject.model.projet.DepenseST_RD;
import com.xyz.myproject.model.projet.DepenseST_Soutien;
import com.xyz.myproject.model.projet.DepensesProjet;

/**
 * AbstractTableModel pour représenter la table des dépenses. Les dépenses sont
 * représentées dans cet ordre:
 * 
 * Main d'oeuvre Matériel consommée Matériel transformé Sous traitance RSDE Sous
 * traitance soutien Location 50-90 Location 90 et plus Equipement 50-90
 * Equipement 90 et plus
 * 
 * @author Raoul
 * 
 */
public class DepensesModel extends AbstractTableModel {

	private DepensesProjet depenses;

	private static String[] entete = { "Dépense", "Montant" };

	/**
	 * Required by getRowCount()
	 */
	private static int nbDepenses = 9;

	public DepensesModel(DepensesProjet depenses) {
		super();
		this.depenses = depenses;
	}

	public DepensesProjet getDepenses() {
		return depenses;
	}

	public void setDepenses(DepensesProjet depenses) {
		this.depenses = depenses;
	}

	@Override
	public String getColumnName(int column) {
		return entete[column];
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return nbDepenses;
	}

	@Override
	public Class<?> getColumnClass(int col) {
		if (col == 0) {
			return String.class;
		} else {
			if (col == 1) {
				return Double.class;

			}

		}
		return Object.class;
	}

	@Override
	public Object getValueAt(int row, int col) {
		if (row == 0) {
			if (col == 0) {
				return this.getNomDepense(row);
			} else {
				return depenses.getTsProjetCa().getTotal()
						+ depenses.getTsProjetEtr().getTotal();
			}
		} else {
			if (row == 3) {
				if (col == 0) {
					return DepenseST_RD.nom;
				} else {
					return depenses.getSous_rd_montant();

				}
			} else {
				if (row == 4) {
					if (col == 0) {
						return DepenseST_Soutien.nom;
					} else {
						return depenses.getSout_soutien_montant();
					}

				} else {
					// Cas général d'un IDepense
					if (col == 0) {
						return this.getNomDepense(row);
					} else {
						return this.getDepense(row).getMontant();
					}
				}
			}

		}
	}

	public DepenseAbstract getDepense(int row) {
		switch (row) {
		case 0:
			return depenses.getTsProjetCa();
		case 1:
			return depenses.getMat_conso();
		case 2:
			return depenses.getMat_transf();
		case 3:
			return depenses.getSout_rd();
		case 4:
			return depenses.getSout_soutien();
		case 5:
			return depenses.getLocation50();
		case 6:
			return depenses.getLocation90();
		case 7:
			return depenses.getEqt_50();
		case 8:
			return depenses.getEqt_90();
		default:
			return depenses.getEqt_50();
		}
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		if (column == 0)
			return;

		if (isCellEditable(row, column)) {
			try {
				this.getDepense(row).setMontant((Double) aValue);
			} catch (ClassCastException e) {

			}
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 0)
			return false;

		switch (row) {
		case 0:
			return false;
		case 1:
		case 2:
			return true;
		case 3:
		case 4:
			return false;
		case 5:
		case 6:
		case 7:
		case 8:
			return true;
		default:
			return false;
		}
	}

	public String getNomDepense(int row) {
		if (row == 0) {
			return "Main d'oeuvre";
		} else {
			return this.getDepense(row).getNom();
		}
	}

	public Class<?> getRowClass(int row) {
		switch (row) {
		case 0:
		case 1:
		case 2:
			return this.getDepense(row).getClass();
		case 3:
			return DepenseST_RD.class;
		case 4:
			return DepenseST_Soutien.class;
		case 5:
		case 6:
		case 7:
			return this.getDepense(row).getClass();
		default:
			return Object.class;
		}

	}

}
