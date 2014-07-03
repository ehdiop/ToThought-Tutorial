package com.xyz.myproject.GUI.presentation.general;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.xyz.myproject.GUI.controller.AddValiderT661Controller;
import com.xyz.myproject.GUI.presentation.AddEDialog;
import com.xyz.myproject.model.Model;

/**
 * Fenêtre de dialogue du T661
 * 
 * @author Raoul
 * 
 */
@SuppressWarnings("serial")
public class DialogT661 extends AddEDialog {

	private JTabbedPane tab;
	private Model model;
	private PanelT661Partie7 partie7;
	private PanelT661Partie3 partie3;
	private PanelT661Partie4 partie4;

	public DialogT661(Model model) {
		super();
		this.model = model;
		this.setTitle("formulaire T661");
		this.tab = new JTabbedPane();
		this.pane.add(tab);
		this.buildPartie3();
		this.buildPartie4();
		this.buildPartie7();
		JButton valider = new JButton("Valider");
		valider.setBackground(Color.RED);
		JPanel wrapper = new JPanel(new FlowLayout());
		wrapper.add(valider);
		valider.addMouseListener(new AddValiderT661Controller(this));
		this.pane.add(wrapper, BorderLayout.SOUTH);
	}

	private void buildPartie7() {
		partie7 = new PanelT661Partie7(model);
		tab.add(partie7, "Partie 7");
	}

	private void buildPartie4() {
		partie4 = new PanelT661Partie4(model);
		tab.add(partie4, "Partie 4");

	}

	private void buildPartie3() {
		partie3 = new PanelT661Partie3(model);
		tab.add(partie3, "Partie 3");

	}

	public PanelT661Partie7 getPartie7() {
		return partie7;
	}

	public PanelT661Partie3 getPartie3() {
		return partie3;
	}

	public PanelT661Partie4 getPartie4() {
		return partie4;
	}

	public static class PanelOnglet extends JPanel {
		private static int val = 10;
		private static Dimension dimension = new Dimension(val, val);
		protected JPanel panelCentral;

		public PanelOnglet() {
			this.setLayout(new BorderLayout());
			this.add(Box.createRigidArea(dimension), BorderLayout.WEST);
			this.add(Box.createRigidArea(dimension), BorderLayout.EAST);
			this.add(Box.createRigidArea(dimension), BorderLayout.NORTH);
			this.add(Box.createRigidArea(dimension), BorderLayout.SOUTH);
			this.panelCentral = new JPanel();
			this.add(panelCentral, BorderLayout.CENTER);
			panelCentral
					.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		}

	}
}
