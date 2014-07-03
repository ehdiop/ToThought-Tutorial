package com.xyz.myproject.GUI.presentation.general;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.xyz.myproject.GUI.controller.AddSousTraitantGeneralController;
import com.xyz.myproject.GUI.controller.EditSousTraitantTableController;
import com.xyz.myproject.GUI.presentation.tabmodels.SousTraitantModel;
import com.xyz.myproject.model.projet.DossierClient;

/**
 * Panel sous-traitant de l'onglet général
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class PanelSousTraitant extends JPanel{
	
	private JDialog owner;

	public PanelSousTraitant(JDialog owner, DossierClient dossierClient) {
		super();
		this.setLayout(new BorderLayout());
		this.owner = owner;
		JTable table = new JTable(new SousTraitantModel(dossierClient.getSousTraitants().getList()));
		table.setAutoCreateRowSorter(true);
		JScrollPane scroll = new JScrollPane(table);
		this.add(scroll);
		
		
		//Bouton ajouter sous traitant
		JPanel wrapper = new JPanel();
		this.add(wrapper,BorderLayout.SOUTH);
		wrapper.setLayout(new FlowLayout());
		JButton addST = new JButton("Ajouter");
		wrapper.add(addST);
		addST.addMouseListener(new AddSousTraitantGeneralController(this.owner,table,dossierClient));
		
		//Edit sous-traitant
		table.addMouseListener(new EditSousTraitantTableController(this.owner, table, dossierClient));
		
	}
	
	
	
	
}
