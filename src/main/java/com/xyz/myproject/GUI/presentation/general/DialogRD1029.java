package com.xyz.myproject.GUI.presentation.general;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.xyz.myproject.GUI.controller.AddValiderRD1029Ctrl;
import com.xyz.myproject.GUI.presentation.AddEDialog;
import com.xyz.myproject.model.Model;
/**
 * Fenêtre de dialogue du formulaire RD1029.7
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class DialogRD1029 extends AddEDialog {
	
	private JTabbedPane tab;
	private Model model;
	private PanelRD1029Partie3 partie3;
	private PanelRD1029Partie2 partie2;
	
	public DialogRD1029(Model model){
		this.model=model;
		tab = new JTabbedPane();
		this.pane.add(tab);
		JPanel wrapper = new JPanel(new FlowLayout());
		JButton valider = new JButton("valider");
		wrapper.add(valider);
		this.pane.add(wrapper,BorderLayout.SOUTH);
		this.buildPartie2();
		this.buildPartie3();
		valider.addMouseListener(new AddValiderRD1029Ctrl(this));
	}

	private void buildPartie2() {
		partie2=new PanelRD1029Partie2(model);
		tab.add(partie2,"Partie 2");
	}

	private void buildPartie3() {
		partie3 = new PanelRD1029Partie3(model);
		tab.add(partie3,"Partie 3");
	}
	
	public void onClick(){
		this.getPartie3().onClick();
	}

	public PanelRD1029Partie3 getPartie3() {
		return partie3;
	}

	public void setPartie3(PanelRD1029Partie3 partie3) {
		this.partie3 = partie3;
	}

	public PanelRD1029Partie2 getPartie2() {
		return partie2;
	}

	public void setPartie2(PanelRD1029Partie2 partie2) {
		this.partie2 = partie2;
	}
	
	
	
	

}
