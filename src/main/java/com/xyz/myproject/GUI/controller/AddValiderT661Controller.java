package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.xyz.myproject.GUI.presentation.general.DialogT661;

/**
 * Controller définissant les actions à réaliser lors de l'appui sur "valider"
 * dans la boite de dialogue du formulaire T661 Fait appel à "onClick()" des
 * parties 3,4 et 7 du formulaire, qui enregistrent les données rentrées par
 * l'utilisateur dans la modélisation
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
