package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.xyz.myproject.GUI.presentation.general.DialogRD1029;

/**
 * Controller d�finissant les actions � r�aliser lors de l'appui sur "valider" dans la boite de 
 * dialogue du formulaire RD1029.7
 * Fait appel � "onClick()" de DialogRD1029.7, qui enregistre les donn�es rentr�es par l'utilisateur dans
 * la mod�lisation
 * 
 * @author Raoul
 *
 */
public class AddValiderRD1029Ctrl extends MouseAdapter {

	private DialogRD1029 dialog;

	public AddValiderRD1029Ctrl(DialogRD1029 dialog) {
		super();
		this.dialog = dialog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.dialog.onClick();
		this.dialog.dispose();
	}

}
