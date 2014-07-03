package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import com.xyz.myproject.GUI.presentation.general.AddEmployeeDialog;
import com.xyz.myproject.GUI.presentation.tabmodels.EmployeModelGeneral;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.projet.Employee;
/**
 * Appelé lors d'un double clic sur un élément de la jtable
 * @author Raoul
 *
 */
public class EditEmployeeTableController extends MouseAdapter  {

	private JTable table;
	private JDialog owner;
	private Client clientModel;

	public EditEmployeeTableController(JTable table, JDialog proprio, Client clientM) {
		super();
		this.table = table;
		this.owner = proprio;
		this.clientModel=clientM;
		
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
			AddEmployeeDialog addEmployeeDialog = new AddEmployeeDialog(this.clientModel,true, this.table);
			Employee clickedEmployee = ((EmployeModelGeneral) (table.getModel()))
					.getListeEmployes().get(this.table.getSelectedRow());

			// On remplit les valeurs de la JDIalog avec celles de l'employé
			// cliqué
			addEmployeeDialog.getNomField().setText(clickedEmployee.getNom());
			addEmployeeDialog.getPrenomField().setText(
					clickedEmployee.getPrenom());
			addEmployeeDialog.getQualifArea().setText(
					clickedEmployee.getQualification());
			addEmployeeDialog.getCourrielField().setText(
					clickedEmployee.getEmail().toString());
			addEmployeeDialog.getDetermineButton().setSelected(
					clickedEmployee.isDetermine());
			addEmployeeDialog.getNonDetermineButton().setSelected(
					!clickedEmployee.isDetermine());
			
			addEmployeeDialog.pack();
			addEmployeeDialog.setLocationRelativeTo(this.owner);
			addEmployeeDialog.setModal(true);
			addEmployeeDialog.setVisible(true);
		}
	}

	

}
