package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JTable;

import com.xyz.myproject.GUI.presentation.general.AddEmployeeDialog;
import com.xyz.myproject.model.general.Client;

/**
 * Controller ouvrant un AddEmployeeDialog lors d'un clic sur le bouton "ajouter" (onglet général, employés)
 * @author Raoul
 *
 */
public class AddEmployeeGeneralController extends MouseAdapter {

	private JDialog owner;

	private Client clientModel;
	private JTable table;

	public AddEmployeeGeneralController(JDialog owner, Client clientM, JTable table) {
		super();
		this.owner = owner;
		this.clientModel = clientM;
		this.table=table;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		AddEmployeeDialog employeeDialog = new AddEmployeeDialog(
				this.clientModel,false,table);
		employeeDialog.pack();
		employeeDialog.setLocationRelativeTo(owner);
		employeeDialog.setModal(true);
		employeeDialog.setVisible(true);
	}

}
