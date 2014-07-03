package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.GUI.presentation.projet.PanelDescrTech;
import com.xyz.myproject.model.Model;

/**
 * Controller liant le panel de la description technique (onglet projet) à son modèle. A étendre et à 
 * préciser avec le type de Panel en cours.
 * L'observable est une objet SectionB ou SectionC
 * @author Raoul
 *
 * @param <E> : le type du panel de la description technique (PanelDescrTechRech, PanelDescrTechDev)
 */
public abstract class MAJPanelDescription<E extends PanelDescrTech> extends MouseAdapter implements Observer {
	
	protected Model model;
	protected E panelDesc;
	
	

	public MAJPanelDescription(Model model, E panelDesc) {
		super();
		this.model = model;
		this.panelDesc = panelDesc;
	}

	@Override
	public abstract void update(Observable arg0, Object arg1);
	
	@Override
	public abstract  void mouseClicked(MouseEvent e);

}
