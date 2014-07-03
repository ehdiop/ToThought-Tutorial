package com.xyz.myproject.GUI.presentation.tabmodels;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.ListClient;
import com.xyz.myproject.model.projet.DossierAnnee;
/**
 * Modèle utilisé pour la JTable des clients dans la fenêtre d'accueil
 * @author Raoul
 *
 */
public class ClientModel extends AbstractTableModel {

	private static final String[] entete = { "client", "nombre de projets" };
	private ListClient clients;

	public ClientModel() {
		super();
	}

	public ClientModel(ListClient clients) {
		super();
		this.clients = clients;
	}

	public ListClient getClients() {
		return clients;
	}

	public void setClients(ListClient clients) {
		this.clients = clients;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return (this.clients == null) ? 0 : clients.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int nombreProjets = 0;
		if (this.clients.get(rowIndex).getDossierClient() != null) {
			
			HashMap<Annee,DossierAnnee> dossiersAnnee = this.clients.get(rowIndex).getDossierClient().getDossiersAnnee();
			Iterator<Annee> it = dossiersAnnee.keySet().iterator();
			while(it.hasNext()){
				Annee annee=it.next();
				nombreProjets += dossiersAnnee.get(annee).getProjets().size();
				
			}
		}
		switch (columnIndex) {
		case 0:
			return this.clients.get(rowIndex).getEntreprise();
		case 1:
			return nombreProjets;
		default:
			throw new IllegalArgumentException();
		}

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return Integer.class;
		default:
			return Object.class;
		}
	}

}
