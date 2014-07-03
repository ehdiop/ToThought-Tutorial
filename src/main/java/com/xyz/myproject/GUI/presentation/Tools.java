package com.xyz.myproject.GUI.presentation;

import java.awt.Window;

import javax.swing.JDialog;
/**
 * 
 * @author Raoul
 *
 */
public class Tools {
	
	/**
	 * Affiche une fen�tre fille. Sous-utilis� dans le projet.
	 * @param dialog
	 * @param owner
	 */
	public static void displayChildDialog(JDialog dialog, Window owner){
		dialog.pack();
		dialog.setLocationRelativeTo(owner);
		dialog.setModal(true);
		dialog.setVisible(true);
	}

}
