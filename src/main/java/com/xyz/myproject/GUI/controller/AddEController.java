package com.xyz.myproject.GUI.controller;

import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;

import com.xyz.myproject.model.Model;

/**
 * Controller générique utilisé pour ouvrir une boite de dialogue. Permet de factoriser le code rendant
 * la boite de dialogue modale, et de fixer sa position par rapport à sa fenêtre mère.
 * @author Raoul
 *
 * @param <E>
 */
public abstract class AddEController<E extends JDialog> extends MouseAdapter {
	
	protected Window owner;
	protected Model model;


	public AddEController(Window owner) {
		super();
		this.owner = owner;
	}

	public abstract E getInstance();
	
	private void doAction(){
		E addE = this.getInstance();
		addE.pack();
		addE.setLocationRelativeTo(this.owner);
		addE.setModal(true);
		addE.setVisible(true);
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		this.doAction();
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		this.doAction();
	}
	

}
