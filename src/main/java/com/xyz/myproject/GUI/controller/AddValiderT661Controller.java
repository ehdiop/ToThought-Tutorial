package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.xyz.myproject.GUI.presentation.general.DialogT661;

/**
 * Controller d�finissant les actions � r�aliser lors de l'appui sur "valider"
 * dans la boite de dialogue du formulaire T661 Fait appel � "onClick()" des
 * parties 3,4 et 7 du formulaire, qui enregistrent les donn�es rentr�es par
 * l'utilisateur dans la mod�lisation
 * 
 * @author Raoul
 * 
 */
public class AddValiderT661Controller extends MouseAdapter {

	private DialogT661 frame;

	public AddValiderT661Controller(DialogT661 frame) {
		super();
		this.frame = frame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.frame.getPartie3().onClick();
		frame.getPartie4().onClick();
		frame.getPartie7().onClick();
		frame.dispose();
	}

}
