package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;

import com.xyz.myproject.GUI.presentation.projet.PanelInfo;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.InfoGeneralesProjet;

/**
 * Controller gérant la génération d'un InfoGeneralesProjet lors du clic sur le
 * bouton valider, dans l'onglet informations générales de l'onglet projet.
 * 
 * @author Raoul
 * 
 */
public class ValideInfoGenProjetController extends MouseAdapter {

	private PanelInfo panel;
	private Model model;

	public ValideInfoGenProjetController(PanelInfo panel, Model model) {
		super();
		this.panel = panel;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		InfoGeneralesProjet infosGene = this.panel.generateInfo();
		this.model.getProjet().getInformationsGenerales().setInfoGeneralesProjet(infosGene);
		this.model.getProjet().setResponsable(this.panel.getRespoField().getText());
		GregorianCalendar debut = new GregorianCalendar();
		debut.setTime(this.panel.getDebutChooser().getDate());
		GregorianCalendar fin = new GregorianCalendar();
		fin.setTime(this.panel.getFinChooser().getDate());
		this.model.getProjet().setDebut(debut);
		this.model.getProjet().setFin(fin);
	}
}
