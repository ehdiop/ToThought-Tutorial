package com.xyz.myproject.GUI.presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.Box;
import javax.swing.JDialog;

/**
 * Code général pour les JDialog ouvertes en popup pour ajouter de nouveaux éléments tels que des employés,
 * des dépenses... Classe à étendre.
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class AddEDialog extends JDialog {
	
	protected static final Dimension sidesMargin = new Dimension(10, 10);
	protected static final Dimension topBotMargin = new Dimension(10, 10);
	
	protected Container pane;
	
	protected AddEDialog(){
		this(null);
	}
	
	protected AddEDialog(Window parent){
		super(parent);
		this.pane = this.getContentPane();
		this.pane.setLayout(new BorderLayout());
		this.pane.add(Box.createRigidArea(topBotMargin),BorderLayout.WEST);
		this.pane.add(Box.createRigidArea(topBotMargin),BorderLayout.EAST);
		this.pane.add(Box.createRigidArea(sidesMargin),BorderLayout.NORTH);
		this.pane.add(Box.createRigidArea(sidesMargin),BorderLayout.SOUTH);
	}

}
