package com.xyz.myproject.GUI.presentation.general;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableRowSorter;

import com.xyz.myproject.GUI.controller.AddMODetGenValider;
import com.xyz.myproject.GUI.controller.AddMODetTableGenValiderController;
import com.xyz.myproject.GUI.presentation.tabmodels.TSMODetermineeModel;
import com.xyz.myproject.model.general.MapLigneMRVR;
import com.xyz.myproject.model.projet.DossierAnnee;

/**
 * Panel "traitements et salaires" (onglet général)
 * @author Raoul
 *
 */
public class PanelMO extends JPanel {
	private Window owner;
	private JPanel panelCentral;
	private static final Font titlesFont = new Font("Arial", Font.BOLD, 20);
	private JTextField tsField, boniField, tsFieldEtranger;
	private JTextField nonPayesField = new JTextField();

	// Dimensions
	private static final Dimension margeVerticale = new Dimension(40, 20);
	private static final Dimension margeHorizontale = new Dimension(20, 20);
	private static final Dimension fieldDimension = new Dimension(100, 20);
	private DossierAnnee dossierAnneeModel;
	private static final Insets insets = new Insets(0, 0, 0, 10);

	public PanelMO(Window owner, DossierAnnee dossierAnneeModel) {
		super();
		this.dossierAnneeModel = dossierAnneeModel;
		this.owner = owner;
		this.setLayout(new BorderLayout());
		this.setBorder(null);

		this.add(Box.createRigidArea(margeHorizontale), BorderLayout.EAST);
		this.add(Box.createRigidArea(margeHorizontale), BorderLayout.WEST);
		this.add(Box.createRigidArea(margeVerticale), BorderLayout.NORTH);

		JButton valider = new JButton("valider");
		JPanel wrapper = new JPanel();
		wrapper.setLayout(new FlowLayout());
		wrapper.add(valider);
		valider.setMaximumSize(new Dimension(40, 20));
		valider.setBackground(Color.red);
		this.add(wrapper, BorderLayout.SOUTH);

		this.panelCentral = new JPanel();
		this.panelCentral.setBorder(null);
		this.panelCentral.setPreferredSize(new Dimension(800, 500));

		JScrollPane scroll = new JScrollPane(this.panelCentral);
		this.panelCentral.setLayout(new BoxLayout(this.panelCentral,
				BoxLayout.Y_AXIS));
		this.add(scroll, BorderLayout.CENTER);

		System.out.println("PANELMO BIS L80 : "+this.dossierAnneeModel);
		this.buildPanelDeterminee("Canada", this.dossierAnneeModel.getInfos()
				.getDepenses().getDepensesIndivSalaireCa());
		this.buildPanelNonDeterminee();
		this.buildPanelDeterminee("étranger", this.dossierAnneeModel.getInfos()
				.getDepenses().getDepensesIndivSalaireEtr());
		this.buildPanelMONonDetermineeEtranger();
		this.buildPanelSalairesNonPayes();

		// COntrollers :
		AddMODetGenValider controller = new AddMODetGenValider(this,
				this.dossierAnneeModel);
		this.dossierAnneeModel.getInfos().getDepenses().getTraitementEtr()
				.addObserver(controller);
		this.dossierAnneeModel.getInfos().getDepenses().gettSCanada()
				.addObserver(controller);
		this.dossierAnneeModel.getInfos().addObserver(controller);
		valider.addMouseListener(controller);

	}

	private void buildPanelSalairesNonPayes() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEtchedBorder());
		this.panelCentral.add(panel);
		panel.setLayout(new GridBagLayout());
		JLabel label = new JLabel(
				"<html>Traitements ou salaires engagés dans l'année mais non payés" +
				" <br> dans les 180 jours suivant la fin de l'année d'imposition : <html>");
		this.nonPayesField.setPreferredSize(fieldDimension);
		GridBagConstraints cons = new GridBagConstraints();
		cons.anchor = GridBagConstraints.LINE_START;
		cons.gridx=0;
		cons.gridy=0;
		cons.weightx = 0;
		cons.gridwidth=1;
		cons.insets = insets;
		panel.add(label, cons);
		
		cons.gridx++;
		panel.add(this.nonPayesField, cons);
		
		JLabel $label = new JLabel("$");
		cons.insets=new Insets(0,0,0,0);
		cons.gridx++;
		cons.weightx=1;
		panel.add($label,cons);

	}

	private void buildPanelDeterminee(String location, MapLigneMRVR model) {
		JPanel detailMOPanel = new JPanel();
		detailMOPanel.setBorder(new TitledBorder(BorderFactory
				.createEtchedBorder(), "Détail main d'oeuvre déterminée "
				+ location));
		detailMOPanel.setLayout(new BorderLayout());
		this.panelCentral.add(detailMOPanel);
		
		
		JTable table = new JTable(new TSMODetermineeModel(model));
//		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane(table);
		model.addObserver(new AddMODetTableGenValiderController(table));

		scroll.setPreferredSize(new Dimension(600, 100));
		detailMOPanel.add(scroll);
	}

	private void buildPanelNonDeterminee() {

		// Ligne main d'oeuvre non déterminée

		JPanel panelLigne = new JPanel();
		this.panelCentral.add(panelLigne);
		panelLigne.setLayout(new GridBagLayout());
		panelLigne.setBorder(new TitledBorder(BorderFactory
				.createEtchedBorder(), "Main d'oeuvre non déterminée"));

		JLabel tsLabel = new JLabel(
				"<html>Traitement ou salaires des employés <br> autres que les employés déterminés<html>");
		this.tsField = new JTextField();
		this.tsField.setPreferredSize(fieldDimension);
		JLabel $label1 = new JLabel("$");

		JLabel boniLabel = new JLabel(
				"<html>Rémunération fondée sur les bénéfices, <br> gratifications et avantages imposables <br> inclus précédemment<html>");
		this.boniField = new JTextField();
		this.boniField.setPreferredSize(fieldDimension);
		JLabel $label2 = new JLabel("$");

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.weightx = 0;
		cons.anchor = GridBagConstraints.LINE_START;

		// tsLabel
		cons.insets = new Insets(0, 0, 0, 10);
		panelLigne.add(tsLabel, cons);

		// tsField
		cons.insets = new Insets(0, 0, 0, 0);
		cons.gridx = 1;
		cons.weightx = 0;
		panelLigne.add(this.tsField, cons);

		// $label1
		cons.gridx = 2;
		cons.weightx = 0.5;
		panelLigne.add($label1, cons);

		// boniLabel
		cons.gridx = 3;
		cons.weightx = 0;
		cons.insets = new Insets(0, 0, 0, 10);
		panelLigne.add(boniLabel, cons);

		// boniField
		cons.gridx = 4;
		panelLigne.add(boniField, cons);

		// $label2
		cons.gridx = 5;
		cons.weightx = 0.5;
		panelLigne.add($label2, cons);

	}

	private void buildPanelMONonDetermineeEtranger() {

		JPanel panelLigne = new JPanel();
		this.panelCentral.add(panelLigne);
		panelLigne.setLayout(new GridBagLayout());
		panelLigne
				.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(),
						"Main d'oeuvre non déterminée pour les activités exercées à l'étranger"));

		JLabel tsLabel = new JLabel(
				"Traitement ou salaire des employés, autre que les employés déterminés :");
		this.tsFieldEtranger = new JTextField();
		this.tsFieldEtranger.setPreferredSize(fieldDimension);
		JLabel $label = new JLabel("$");

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.insets = new Insets(0, 0, 0, 10);
		cons.anchor = GridBagConstraints.FIRST_LINE_START;

		// tsLabel
		panelLigne.add(tsLabel, cons);

		// tsField
		cons.gridx = 1;
		cons.weightx = 0;
		panelLigne.add(tsFieldEtranger, cons);

		// $label
		cons.weightx = 1;
		cons.gridx = 2;
		panelLigne.add($label, cons);

		// rigidarea
		cons.gridx = 3;
		cons.fill = GridBagConstraints.HORIZONTAL;
		panelLigne.add(Box.createRigidArea(new Dimension(300, 40)), cons);

	}

	public JTextField getTsField() {
		return tsField;
	}

	public void setTsField(JTextField tsField) {
		this.tsField = tsField;
	}

	public JTextField getBoniField() {
		return boniField;
	}

	public void setBoniField(JTextField boniField) {
		this.boniField = boniField;
	}

	public JTextField getTsFieldEtranger() {
		return tsFieldEtranger;
	}

	public void setTsFieldEtranger(JTextField tsFieldEtranger) {
		this.tsFieldEtranger = tsFieldEtranger;
	}
	
	
	


	public JTextField getNonPayesField() {
		return nonPayesField;
	}

	public void fillWith() {
		this.boniField.setText(""
				+ this.dossierAnneeModel.getInfos().getDepenses().gettSCanada()
						.getBoni());
		this.tsFieldEtranger.setText(""
				+ this.dossierAnneeModel.getInfos().getDepenses()
						.getTraitementEtr().getMo_non_determinee());
		this.tsField.setText(""
				+ this.dossierAnneeModel.getInfos().getDepenses().gettSCanada()
						.getMo_non_determinee());
	}
}
