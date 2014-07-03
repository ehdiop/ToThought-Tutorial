package com.xyz.myproject.GUI.presentation.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.xyz.myproject.GUI.controller.MAJPanelDescription;
import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.sectionsBC.DescriptionTechnique;
/**
 * Panel de la description technique. Est étendu par PanelDescrTechDev et PanelDescrTechRech. Classe générique et 
 * abstraite pour spécialiser le controller
 * @author Raoul
 *
 * @param <E>
 * @param <F>
 */
@SuppressWarnings("serial")
public abstract class PanelDescrTech<E extends DescriptionTechnique, F extends MAJPanelDescription> extends JPanel {

	private static final Dimension margeVerticale = new Dimension(40, 20);
	private static final Dimension margeHorizontale = new Dimension(20, 20);
	
	protected static final Font font = PARAMETERS_IHM.font;
	protected static final Dimension editorDimension = new Dimension(150, 300);
	
	protected JButton valider;
	protected Model model;
	
	public PanelDescrTech(Model model){
		this.model = model;
		this.setLayout(new BorderLayout());
		this.add(Box.createRigidArea(margeHorizontale), BorderLayout.EAST);
		this.add(Box.createRigidArea(margeHorizontale), BorderLayout.WEST);
		this.add(Box.createRigidArea(margeVerticale), BorderLayout.NORTH);
		this.valider = new JButton("valider");
		valider.setBackground(Color.RED);
		valider.addMouseListener(this.getController());
		((E)this.model.getProjet().getInformationsGenerales().getDescTech()).addObserver(this.getController());
		JPanel wrapper = new JPanel(new FlowLayout());
		wrapper.add(valider);
		this.add(wrapper,BorderLayout.SOUTH);
	}

	public JButton getValider() {
		return valider;
	}
	
	protected abstract void fillWithBrut(E section);
	
	public void fillWith(E section){
		if(section!=null){
			fillWithBrut(section);
		}
	}
	
	protected abstract F getController();
	
	
	
}
