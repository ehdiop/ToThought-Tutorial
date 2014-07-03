package com.xyz.myproject.model.tests;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestActionItemListener extends JFrame{
	
	private JCheckBox checkBoxAction, checkBoxItem;
	public TestActionItemListener() {
		this.setSize(500, 500);
		JPanel grand = new JPanel();
		grand.setLayout(new BoxLayout(grand, BoxLayout.Y_AXIS));
		this.add(grand);
		
		JPanel panel = new JPanel(new GridBagLayout());
		grand.add(panel);
		
		checkBoxAction = new JCheckBox("ActionListener");
		checkBoxAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent _ev) {
				System.out.println("State by ActionListener:"
						+ ((JCheckBox)(_ev.getSource())).isSelected());
			}
		});

		checkBoxItem = new JCheckBox("ItemListener");
		checkBoxItem.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println("State by ItemListener: "
						+ ((JCheckBox)(e.getSource())).isSelected());
			}
		});
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx=0;
		cons.gridy=0;

		panel.add(checkBoxAction,cons);
		cons.gridy++;
		panel.add(checkBoxItem,cons);

		checkBoxAction.setSelected(true);
		checkBoxItem.setSelected(false);
	}
	
	public static void main(String[] _args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		

		new TestActionItemListener().setVisible(true);
	}

}