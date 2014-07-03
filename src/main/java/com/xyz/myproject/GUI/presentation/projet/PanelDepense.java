package com.xyz.myproject.GUI.presentation.projet;

import java.awt.BorderLayout;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import com.xyz.myproject.GUI.controller.EditDepenseController;
import com.xyz.myproject.GUI.controller.RafraichissementTabDepenseCtrl;
import com.xyz.myproject.GUI.presentation.tabmodels.DepensesModel;
import com.xyz.myproject.model.Model;
/**
 * Panel des dépenses de l'onglet projet.
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class PanelDepense extends JPanel {
	
	private Window owner;
	private Model model;

	public PanelDepense(Window proprio, Model model) {
		this.owner = proprio;
		this.model=model;
		this.setLayout(new BorderLayout());
		JTable table = new JTable(
				new DepensesModel(model.getProjet().getDepenses()));
		RafraichissementTabDepenseCtrl tableController = new RafraichissementTabDepenseCtrl(table);
		this.model.getProjet().getDepenses().addObserver(tableController);
		this.model.getProjet().getDepenses().getSout_rd().addObserver(tableController);
		this.model.getProjet().getDepenses().getSout_soutien().addObserver(tableController);
		JScrollPane scroll = new JScrollPane(table,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		table.addMouseListener(new EditDepenseController(owner, table, this.model));
		
		this.add(scroll);
	}

}
