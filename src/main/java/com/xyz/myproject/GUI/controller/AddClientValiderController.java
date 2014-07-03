package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


import com.xyz.myproject.GUI.presentation.AddClientDialog;
import com.xyz.myproject.model.exceptions.ClientException;
import com.xyz.myproject.model.exceptions.NEException;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.CodePostal;
import com.xyz.myproject.model.general.ListClient;
import com.xyz.myproject.model.general.ListClient.LISTE_CLIENT;
import com.xyz.myproject.model.general.NumeroEntreprise;
import com.xyz.myproject.model.general.NumeroIdProv;
import com.xyz.myproject.model.general.Province;
import com.xyz.myproject.model.projet.DossierClient;

/**
 * Controller de la création/édition d'un client. Lors du clic sur "ajouter", on
 * ajoute ou édite le client. Lors du changement d'un client, on met à jour la
 * liste.
 * 
 * @author Raoul
 * 
 */
public class AddClientValiderController extends MouseAdapter implements
		Observer {

	private AddClientDialog dialog;
	private ListClient model;
	private Client client;
	private boolean edit;
	private JTable table;

	public AddClientValiderController(AddClientDialog dialog, ListClient model,
			boolean edit, JTable table, Client client) {
		this.dialog = dialog;
		this.model = model;
		this.edit = edit;
		this.table = table;
		this.client=client;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1==LISTE_CLIENT.MODIF){
			((AbstractTableModel)this.table.getModel()).fireTableDataChanged();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Creating the new client from the data in the JDialog
		String nom = dialog.getFieldEntreprise().getText();
		String adresse = dialog.getFieldAdresse().getText();
		String ville = dialog.getVilleField().getText();
		Province prov = dialog.getComboProvince().getItemAt(
				dialog.getComboProvince().getSelectedIndex());
		CodePostal cp = new CodePostal(dialog.getCPField().getText());
		NumeroEntreprise ne = new NumeroEntreprise();
		boolean valider = true;
		try {
			ne = new NumeroEntreprise(dialog.getNETextField().getText());
		} catch (NEException e1) {
			int choix = JOptionPane.showConfirmDialog(dialog, e1.toString()
					+ "\n Garder ce NE ?", "NE incorrect",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (choix == JOptionPane.NO_OPTION) {
				valider = false;
			}
		}

		NumeroIdProv nId = new NumeroIdProv(dialog.getIdProvField().getText());

		if (valider) {

			Client client;
			try {
				client = new Client(nom, adresse, ville, prov, cp, ne, nId,
						new DossierClient());
				if (!edit) {
					model.add(client);
				} else {
					this.client.set(client);
				}
				dialog.dispose();
			} catch (ClientException e1) {
				JOptionPane.showMessageDialog(dialog, e1.toString());
			}

		}
	}

}
