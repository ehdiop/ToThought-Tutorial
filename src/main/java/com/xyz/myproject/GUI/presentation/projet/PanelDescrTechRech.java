package com.xyz.myproject.GUI.presentation.projet;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.xyz.myproject.GUI.controller.MAJPanelDescriptionTechRechCtrl;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.sectionsBC.SectionC;
/**
 * 
 * Voir PanelDescrTech
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class PanelDescrTechRech extends PanelDescrTech<SectionC, MAJPanelDescriptionTechRechCtrl> {
	
	private JEditorPane avancementEditor, travauxEditor;

	// Constantes statiques
	
	public PanelDescrTechRech(Model model){
		super(model);
		JPanel panelCentral = new JPanel();

		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		this.add(new JScrollPane(panelCentral,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		// Editeur avancements sur les connaissances scientifiques
		JLabel progressLabel = new JLabel(
				"Quels avancements dans les connaissances scientifiques cherchiez-vous à réaliser ?");
		progressLabel.setFont(font);
		JPanel wrapperPLabel = new JPanel(new FlowLayout());
		wrapperPLabel.add(progressLabel);
		panelCentral.add(wrapperPLabel);
		wrapperPLabel.setAlignmentX(LEFT_ALIGNMENT);
		avancementEditor = new JEditorPane();
		avancementEditor.setBorder(BorderFactory.createEtchedBorder());
		avancementEditor.setPreferredSize(editorDimension);
		JScrollPane paneProgess = new JScrollPane(avancementEditor,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		paneProgess.setPreferredSize(editorDimension);
		panelCentral.add(paneProgess);
		
		
		// Editeur obstacle technologique
				JLabel obstacleLabel = new JLabel(
						"<html>Quels travaux avez-vous effectués au cours de l'année d'imposition,<br> et comment ont-ils contribués aux avancements décrits à la ligne 250 ?<html>");
				obstacleLabel.setFont(font);
				JPanel wrapperOLabel = new JPanel(new FlowLayout());
				wrapperOLabel.add(obstacleLabel);
				panelCentral.add(wrapperOLabel);
				travauxEditor = new JEditorPane();
				travauxEditor.setBorder(BorderFactory.createEtchedBorder());
				travauxEditor.setPreferredSize(editorDimension);
				JScrollPane obstaclePane = new JScrollPane(travauxEditor,
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				obstaclePane.setPreferredSize(editorDimension);
				panelCentral.add(obstaclePane);
	}

	public JEditorPane getAvancementEditor() {
		return avancementEditor;
	}

	public JEditorPane getTravauxEditor() {
		return travauxEditor;
	}
	
	/**
	 * Méthode utilisée lorsque l'on souhaite remplir le panel avec un objet SectionC. 
	 * On distingue le cas où le panel est rempli après appui sur "valider". Dans ce dernier cas,
	 * il faut permettre l'apparition d'un pop up en cas d'un nombre de mot trop important.
	 * @param sectionC
	 * @param okPressed : si le panel est rempli après avoir appuyé sur "valider"
	 */




	@Override
	protected void fillWithBrut(SectionC section) {
		if(!this.getAvancementEditor().getText().equals(section.getQuestion1().getTexte()))
			this.getAvancementEditor().setText(
					section.getQuestion1().getTexte());
			if(!this.getTravauxEditor().getText().equals(section.getQuestion2().getTexte()))

			this.getTravauxEditor().setText(
					section
							.getQuestion2().getTexte());
	}

	@Override
	protected MAJPanelDescriptionTechRechCtrl getController() {
		return new MAJPanelDescriptionTechRechCtrl(model, this);
	}

	
	

}
