package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.xyz.myproject.model.Model;

/**
 * Appelé lorsque le bouton valider de l'onglet "informations générales" de l'onglet "projet" est cliqué.
 * Met alors à jour l'instance d'InformationGenerale en variable d'instance du projet.
 * @author Raoul
 *
 */
public class AddInfoProjetValiderController extends MouseAdapter {
	
	private Model model;

	public AddInfoProjetValiderController(Model model) {
		super();
		this.model = model;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		
	}

}
