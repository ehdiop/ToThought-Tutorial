package com.xyz.myproject.GUI.presentation.general;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.xyz.myproject.GUI.controller.AddEmployeeGeneralController;
import com.xyz.myproject.GUI.controller.EditEmployeeTableController;
import com.xyz.myproject.GUI.presentation.tabmodels.EmployeModelGeneral;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.Client;

/**
 * Panel employé (onglet général)
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class PanelEmploye extends JPanel {
	
	private static final Dimension dimensionBouton = new Dimension(70,25);
	private JDialog owner;
	private Client clientModel;
	private Annee anneeModel;
	
	public PanelEmploye(JDialog proprio, Client clientModele, Annee anneeModele) {
		super();
		this.clientModel=clientModele;
		this.anneeModel=anneeModele;
		this.owner = proprio;
		this.setLayout(new BorderLayout());
		JTable table = new JTable(new EmployeModelGeneral(clientModele.getDossierClient().getEmployes().getList()));
		this.add(new JScrollPane(table));
		JButton addEmployee = new JButton("ajouter");
		addEmployee.setPreferredSize(dimensionBouton);
		
		JPanel buttonWrapper = new JPanel();
		buttonWrapper.setLayout(new FlowLayout());
		this.add(buttonWrapper,BorderLayout.SOUTH);
		buttonWrapper.add(addEmployee);
		addEmployee.addMouseListener(new AddEmployeeGeneralController(this.owner, this.clientModel, table));
		EditEmployeeTableController employeeTableControl=new EditEmployeeTableController(table, this.owner,this.clientModel);
		table.addMouseListener(employeeTableControl);
		
		table.setAutoCreateRowSorter(true);
	}
	
	

}
