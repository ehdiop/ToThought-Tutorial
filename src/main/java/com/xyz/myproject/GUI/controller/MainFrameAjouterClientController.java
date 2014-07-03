package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.xyz.myproject.GUI.presentation.AddClientDialog;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.ListClient;

/**
 * Ouvre une fenêtre de dialogue d'ajout/édition de client. Listener du bouton
 * "ajouter" et du MenuItem "editer".
 * 
 * @author Raoul
 * 
 */
public class MainFrameAjouterClientController extends MouseAdapter {

	private JFrame owner;
	private ListClient model;
	private boolean edit;
	private Client client;
	private JTable table;

	public MainFrameAjouterClientController(JFrame owner, ListClient model,
			Client client, boolean edit, JTable table) {
		super();
		this.owner = owner;
		this.model = model;
		this.edit = edit;
		this.client = client;
		this.table = table;
	}

	private void display() {
		AddClientDialog clientDialog = new AddClientDialog(this.owner, model,
				edit);
		AddClientValiderController controller = new AddClientValiderController(
				clientDialog, model, edit, table, client);
		clientDialog.getValider().addMouseListener(controller);
		this.model.addObserver(controller);
		if (edit)
			clientDialog.fillWith(client);
		clientDialog.pack();
		clientDialog.setModal(true);
		clientDialog.setLocationRelativeTo(this.owner);
		clientDialog.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		display();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		display();
	}
}
