package com.xyz.myproject.GUI.presentation.projet;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.xyz.myproject.GUI.controller.MAJPanelDescriptionTechDev;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.sectionsBC.SectionB;

/**
 * 
 * Voir PanelDescrTech
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class PanelDescrTechDev extends PanelDescrTech<SectionB, MAJPanelDescriptionTechDev> {

	private JEditorPane progressEditor, obstaclesEditor, travauxEditor;

	public PanelDescrTechDev(Model model) {
		super(model);
		JPanel panelCentral = new JPanel();

		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		this.add(new JScrollPane(panelCentral,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		// Editeur progrès technologique
		JLabel progressLabel = new JLabel(
				"Quels progrès technologiques avez-vous essayé de réaliser?");
		progressLabel.setFont(font);
		JPanel wrapperPLabel = new JPanel(new FlowLayout());
		wrapperPLabel.add(progressLabel);
		panelCentral.add(wrapperPLabel);
		wrapperPLabel.setAlignmentX(LEFT_ALIGNMENT);
		progressEditor = new JEditorPane();
		progressEditor.setBorder(BorderFactory.createEtchedBorder());
		progressEditor.setPreferredSize(editorDimension);
		JScrollPane paneProgess = new JScrollPane(progressEditor,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		paneProgess.setPreferredSize(editorDimension);
		panelCentral.add(paneProgess);

		// Editeur obstacle technologique
		JLabel obstacleLabel = new JLabel(
				"<html>Quels obstacles ou quelles incertitudes technologiques avez-vous dû <br> surmonter pour réaliser les progrès décrits ci-dessus?<html>");
		obstacleLabel.setFont(font);
		JPanel wrapperOLabel = new JPanel(new FlowLayout());
		wrapperOLabel.add(obstacleLabel);
		panelCentral.add(wrapperOLabel);
		obstaclesEditor = new JEditorPane();
		obstaclesEditor.setBorder(BorderFactory.createEtchedBorder());
		obstaclesEditor.setPreferredSize(editorDimension);
		JScrollPane obstaclePane = new JScrollPane(obstaclesEditor,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		obstaclePane.setPreferredSize(editorDimension);
		panelCentral.add(obstaclePane);

		// Editeur travaux réalisés
		JLabel travauxEffectues = new JLabel(
				"<html>Quels travaux avez-vous effectués au cours de l'année d'imposition pour"
						+ "<br> surmonter les obstacles et incertitudes technologiques décrits ci-dessus?<html>");
		travauxEffectues.setFont(font);
		JPanel wrapperTPanel = new JPanel(new FlowLayout());
		wrapperTPanel.add(travauxEffectues);
		panelCentral.add(wrapperTPanel);
		travauxEditor = new JEditorPane();
		travauxEditor.setBorder(BorderFactory.createEtchedBorder());
		travauxEditor.setPreferredSize(editorDimension);
		JScrollPane travauxScroll = new JScrollPane(travauxEditor,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelCentral.add(travauxScroll);
	}

	public JEditorPane getProgressEditor() {
		return progressEditor;
	}

	public JEditorPane getObstaclesEditor() {
		return obstaclesEditor;
	}

	public JEditorPane getTravauxEditor() {
		return travauxEditor;
	}


	@Override
	protected void fillWithBrut(SectionB section) {
		if (!this.getProgressEditor().getText()
				.equals(section.getProgresTech().getTexte()))
			this.getProgressEditor().setText(
					section.getProgresTech().getTexte());
		if (!this.getObstaclesEditor().getText()
				.equals(section.getObstaclesTech().getTexte()))

			this.getObstaclesEditor().setText(
					section.getObstaclesTech().getTexte());
		if (!this.getTravauxEditor().getText()
				.equals(section.getTravaux().getTexte()))
			this.getTravauxEditor().setText(
					section.getTravaux().getTexte());		
	}

	@Override
	protected MAJPanelDescriptionTechDev getController() {
		return new MAJPanelDescriptionTechDev(this.model, this);
	}

}
