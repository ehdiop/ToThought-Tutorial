package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.JOptionPane;

import com.xyz.myproject.GUI.presentation.projet.PanelDescrTechRech;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.exceptions.DescriptionTechException;
import com.xyz.myproject.model.sectionsBC.SectionC;
import com.xyz.myproject.model.sectionsBC.SectionC.SECTIONC;

/**
 * Voir MAJPanelDescription
 * 
 * @author Raoul
 * 
 */
public class MAJPanelDescriptionTechRechCtrl extends
		MAJPanelDescription<PanelDescrTechRech> {

	public MAJPanelDescriptionTechRechCtrl(Model model,
			PanelDescrTechRech panelDesc) {
		super(model, panelDesc);
	}



	@Override
	public void update(Observable arg0, Object arg1) {
		SectionC sectionC = (SectionC) this.model.getProjet().getInformationsGenerales().getDescTech();
		if (arg1 == SECTIONC.MAJ_QU) {
			this.panelDesc.fillWith(sectionC);
		}

	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		SectionC sectionC = (SectionC) this.model.getProjet().getInformationsGenerales().getDescTech();
		sectionC.setQuestion1(this.panelDesc.getAvancementEditor().getText());
		try{
			sectionC.getQuestion1().checkNumberWords();
		}
		catch(DescriptionTechException ex){
			JOptionPane.showMessageDialog(this.panelDesc, ex.toString(), ex.title(), JOptionPane.WARNING_MESSAGE);
		}
		
		sectionC.setQuestion2(this.panelDesc.getTravauxEditor().getText());
		try{
			sectionC.getQuestion2().checkNumberWords();
		}
		catch(DescriptionTechException ex){
			JOptionPane.showMessageDialog(this.panelDesc, ex.toString(), ex.title(), JOptionPane.WARNING_MESSAGE);
		}
		
		

	}

}
