package com.xyz.myproject.GUI.presentation.tabmodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.xyz.myproject.model.projet.Employee;
/**
 * Modèle utilisé pour la JTable des employés dans l'onglet général
 * @author Raoul
 *
 */
public class EmployeModelGeneral extends AbstractTableModel {

	private static String[] entetes = { "Nom", "Prenom", "Fonction",
			"Qualification/expérience" };

	private List<Employee> listeEmployes;

	public EmployeModelGeneral(List<Employee> listeEmployes) {
		super();
		this.listeEmployes = listeEmployes;
	}
	
	

	public List<Employee> getListeEmployes() {
		return listeEmployes;
	}



	public void setListeEmployes(List<Employee> listeEmployes) {
		this.listeEmployes = listeEmployes;
	}



	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return (listeEmployes == null) ? 0 : listeEmployes.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Employee employee = this.listeEmployes.get(row);

		switch (column) {
		case 0:
			return employee.getNom();
		case 1:
			return employee.getPrenom();
		case 2:
			return employee.getFonction();
		case 3:
			return employee.getQualification();
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex <= 3 && columnIndex >= 0) {
			return String.class;
		}
		return Object.class;
	}

}
