package com.xyz.myproject.GUI.controller;

import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 * Generic controller class on a table row for editing. Describes the actions
 * when double clicking on a table row, which is to popup a JDialog with the
 * values of the object to edit. The getInstance() and fillFields must be
 * implemented. getInstance() : must return an instance of the JDialog where the
 * fields are edited. fillFields : must fill the JDialog with the data of the
 * table row
 * 
 * @author Raoul
 * 
 */
public abstract class EditEController<E extends JDialog> extends MouseAdapter {

	protected Window owner;
	protected JTable table;

	public EditEController(Window owner, JTable table) {
		super();
		this.owner = owner;
		this.table = table;

	}

	protected abstract E getInstance();

	protected abstract void fillField(E dialog);

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
			E dialog = this.getInstance();
			if (dialog != null) {
				this.fillField(dialog);
				dialog.pack();
				dialog.setLocationRelativeTo(this.owner);
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		}
	}

}
