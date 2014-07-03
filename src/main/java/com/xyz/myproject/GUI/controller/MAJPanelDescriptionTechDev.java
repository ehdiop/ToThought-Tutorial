package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.JOptionPane;

import com.xyz.myproject.GUI.presentation.projet.PanelDescrTechDev;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.exceptions.DescriptionTechException;
import com.xyz.myproject.model.sectionsBC.SectionB;
import com.xyz.myproject.model.sectionsBC.SectionB.SECTIONB;

/**
 * Mapping panel-question dans l'onglet description technique (évènements : mise
 * à jour du texte d'une question dans le modèle, ou clic sur bouton valider)
 * 
 * @author Raoul
 * 
 */
public class MAJPanelDescriptionTechDev extends
		MAJPanelDescription<PanelDescrTechDev> {

	public MAJPanelDescriptionTechDev(Model model, PanelDescrTechDev panelDesc) {
		super(model, panelDesc);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 == SECTIONB.MAJ_QU) {
			SectionB sectionB = (SectionB) this.model.getProjet()
					.getInformationsGenerales().getDescTech();
			this.panelDesc.fillWith(sectionB);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SectionB sectionB = (SectionB) this.model.getProjet().getInformationsGenerales().getDescTech();
		sectionB.getProgresTech().setTexte(
				this.panelDesc.getProgressEditor().getText());

		sectionB.getObstaclesTech().setTexte(
				this.panelDesc.getObstaclesEditor().getText());
		sectionB.getTravaux().setTexte(
				this.panelDesc.getTravauxEditor().getText());

		try {
			sectionB.getObstaclesTech().checkNumberWords();
			sectionB.getProgresTech().checkNumberWords();
			sectionB.getTravaux().checkNumberWords();
		} catch (DescriptionTechException e1) {
			JOptionPane.showMessageDialog(this.panelDesc, e1.toString(),
					e1.title(), JOptionPane.WARNING_MESSAGE);
		}

	}

}
