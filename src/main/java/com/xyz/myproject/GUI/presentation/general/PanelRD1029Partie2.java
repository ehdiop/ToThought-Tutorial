package com.xyz.myproject.GUI.presentation.general;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.xyz.myproject.GUI.presentation.general.DialogT661.PanelOnglet;
import com.xyz.myproject.GUI.presentation.tabmodels.DepenseSTModelEditable;
import com.xyz.myproject.model.Model;

/**
 * Onglet partie 2 de la fenêtre de dialogue de lu RD1029.7
 * @author Raoul
 *
 */
public class PanelRD1029Partie2 extends PanelOnglet {

	public PanelRD1029Partie2(Model model) {
		JLabel titre = new JLabel(
				"2. Renseignements sur les sous-traitants sans lien de dépendance");
		this.panelCentral.add(titre);
		JPanel panel = new JPanel(new BorderLayout());
		panelCentral.add(panel);
		//TODO ajouter un controller ici
		JTable table = new JTable(new DepenseSTModelEditable(model
				.getDossierAnnee().getRd1029().getPartie2()));
		table.setAutoCreateRowSorter(true);
		JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll);
	}

}
