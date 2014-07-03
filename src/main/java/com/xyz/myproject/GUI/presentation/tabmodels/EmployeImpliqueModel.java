package com.xyz.myproject.GUI.presentation.tabmodels;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import com.xyz.myproject.model.general.EmployesImpliques;
import com.xyz.myproject.model.projet.DossierClient;
import com.xyz.myproject.model.projet.Employee;
import com.xyz.myproject.model.projet.Projet;
/**
 * Modèle utilisé pour la JTable des employés impliqués (onglet projet)
 */
@SuppressWarnings("serial")
public class EmployeImpliqueModel extends AbstractTableModel {

	private Projet projet;
	private DossierClient dossierClient;
	public static String[] entete = { "Nom", "Fonction",
			"Qualification/expérience", "Implication dans le projet" };
	

	public EmployeImpliqueModel(Projet projet, DossierClient dossierClient) {
		super();
		this.projet = projet;
		this.dossierClient=dossierClient;
		
	}

	@Override
	public String getColumnName(int column) {
		return entete[column];
	}

	@Override
	public boolean isCellEditable(int row, int column){
		return true;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Employee employe = this.dossierClient.getEmployes().get(rowIndex);
		EmployesImpliques emplImpliques = this.projet.getEmployesImp();

		switch (columnIndex) {
		case 0:
			return employe.toString();
		case 1:
			return employe.getFonction();
		case 2:
			return employe.getQualification();
		case 3:
			return (emplImpliques.get(employe) != null);
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return this.dossierClient.getEmployes().size();
	}
	
	@Override
	public void setValueAt(Object value, int row, int column){
		if(column==3){
			boolean implique = (Boolean) value;
			Employee employe = this.dossierClient.getEmployes().get(row);
			if(implique){
				this.projet.getEmployesImp().add(employe);
			}
			else{
				this.projet.getEmployesImp().remove(employe);
			}
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
			return String.class;
		case 3:
			return Boolean.class;
		default:
			return Object.class;
		}
	}

	public class MyCellRenderer extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {

			if (value instanceof Boolean) {
				JCheckBox check = new JCheckBox();
				check.setSelected((Boolean) value);
				return check;
			} else {
				if (value instanceof JCheckBox) {
					return (JCheckBox) value;
				} else {
					return new JLabel("hum");
				}
			}

		}

	}

}
