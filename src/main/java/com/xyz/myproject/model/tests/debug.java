package com.xyz.myproject.model.tests;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.xyz.myproject.bdd.utils.Mock;
import com.xyz.myproject.model.general.SousTraitant;

public class debug {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new JComboBox<SousTraitant>(Mock.sousTraitantsCreate()));
		frame.pack();
		frame.setVisible(true);
	}

}
