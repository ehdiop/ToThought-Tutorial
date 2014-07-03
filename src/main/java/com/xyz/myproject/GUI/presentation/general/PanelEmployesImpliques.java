package com.xyz.myproject.GUI.presentation.general;

import java.awt.BorderLayout;
import java.awt.Window;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.xyz.myproject.GUI.controller.MAJEmployesImpliquesController;
import com.xyz.myproject.GUI.presentation.tabmodels.EmployeImpliqueModel;
import com.xyz.myproject.model.Model;
/**
 * Panel des employés impliqués (onglet projet).
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class PanelEmployesImpliques extends JPanel {

	private Window owner;
	private Model model;

	public PanelEmployesImpliques(Window proprio, Model model) {
		this.owner = proprio;
		this.model = model;
		this.setLayout(new BorderLayout());
		EmployeImpliqueModel employeImpModel = new EmployeImpliqueModel(
				this.model.getProjet(), this.model.getDossierClient());
		JTable table = new JTable(employeImpModel);
		table.getColumnModel().getColumn(3)
				.setCellEditor(new DefaultCellEditor(new JCheckBox()));
		JScrollPane scroll = new JScrollPane(table);
		this.add(scroll);
		// controller
		MAJEmployesImpliquesController controller = new MAJEmployesImpliquesController(table);
		this.model.getEmployees().addObserver(controller);

	}

}
