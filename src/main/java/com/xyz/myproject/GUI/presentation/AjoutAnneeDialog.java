package com.xyz.myproject.GUI.presentation;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;
import com.xyz.myproject.GUI.controller.AddAnneeValiderController;
import com.xyz.myproject.model.general.Client;
/**
 * Fenêtre de dialogue d'ajout d'une année financière
 * @author Raoul
 *
 */
public class AjoutAnneeDialog extends JDialog {

	private Container pane;
	private JDateChooser chooserDebut, chooserFin;
	private JRadioButton radioRemplacement, radioTraditionnelle;
	private Client model;
	private boolean edit;

	public AjoutAnneeDialog(Client model, boolean edit) {
		this.setTitle("Ajout d'une année");
		this.edit=edit;
		this.model = model;
		this.setModal(true);

		this.pane = this.getContentPane();
		
		this.pane.setLayout(new BoxLayout(this.pane, BoxLayout.Y_AXIS));
		this.pane.setPreferredSize(new Dimension(300,240));

		this.buildChoixDates();
		this.buildChoixMethode();
		this.init();
		JButton ok = new JButton("ok");
		ok.addMouseListener(new AddAnneeValiderController(this.model, this));
		this.pane.add(ok);


	}

	private void buildChoixDates() {
		JPanel choixDates = new JPanel();
		this.pane.add(choixDates);
		choixDates.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(), "Dates de l'année fiscale"));
		choixDates.setLayout(new BoxLayout(choixDates,BoxLayout.Y_AXIS));
		
		JPanel panelDebut = new JPanel();
		choixDates.add(panelDebut);
		panelDebut.setLayout(new FlowLayout());
		JLabel labelDebut = new JLabel("Date de début de l'année :");
		panelDebut.add(labelDebut);
		chooserDebut = new JDateChooser(null,PARAMETERS_IHM.dateFormat);
		panelDebut.add(chooserDebut);

		
		JPanel panelFin = new JPanel();
		choixDates.add(panelFin);
		panelFin.setLayout(new FlowLayout());
		JLabel labelFin = new JLabel("Date de fin de l'année :");
		panelFin.add(labelFin);
		chooserFin = new JDateChooser(null, PARAMETERS_IHM.dateFormat);
		panelFin.add(chooserFin);
		
	}

	private void buildChoixMethode() {
		JPanel choixMethode = new JPanel();
		choixMethode.setPreferredSize(new Dimension(300, 200));
		choixMethode.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(),"Choix de la méthode de calcul :"));
		choixMethode.setLayout(new BoxLayout(choixMethode,BoxLayout.Y_AXIS));
		this.pane.add(choixMethode);
		
		JPanel panelMethode = new JPanel();
		panelMethode.setMaximumSize(new Dimension(300, 30));
		choixMethode.add(panelMethode);
		panelMethode.setLayout(new FlowLayout());
		JLabel labelMethode = new JLabel("Quelle méthode de calcul choisissez vous ?");
		panelMethode.add(labelMethode);
		labelMethode.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panelRadio = new JPanel();
		panelRadio.setLayout(new FlowLayout());
		choixMethode.add(panelRadio);
		ButtonGroup buttonGroup = new ButtonGroup();
		radioTraditionnelle = new JRadioButton("Méthode traditionnelle");
		buttonGroup.add(radioTraditionnelle);
		radioRemplacement = new JRadioButton("Méthode de remplacement");
		buttonGroup.add(radioRemplacement);
		buttonGroup.setSelected(radioRemplacement.getModel(), true);
		panelRadio.add(radioRemplacement);
		panelRadio.add(radioTraditionnelle);
		
		
	}

	public JDateChooser getChooserDebut() {
		return chooserDebut;
	}

	public void setChooserDebut(JDateChooser chooserDebut) {
		this.chooserDebut = chooserDebut;
	}

	public JDateChooser getChooserFin() {
		return chooserFin;
	}

	public void setChooserFin(JDateChooser chooserFin) {
		this.chooserFin = chooserFin;
	}

	public JRadioButton getRadioRemplacement() {
		return radioRemplacement;
	}

	public void setRadioRemplacement(JRadioButton radioRemplacement) {
		this.radioRemplacement = radioRemplacement;
	}

	public JRadioButton getRadioTraditionnelle() {
		return radioTraditionnelle;
	}

	public void setRadioTraditionnelle(JRadioButton radioTraditionnelle) {
		this.radioTraditionnelle = radioTraditionnelle;
	}
	
	private void init(){
		GregorianCalendar defaultDebut = new GregorianCalendar(Calendar.getInstance(Locale.CANADA_FRENCH).get(Calendar.YEAR),5,1);
		this.getChooserDebut().setDate(defaultDebut.getTime());
		GregorianCalendar defaultFin = new GregorianCalendar(defaultDebut.get(Calendar.YEAR), defaultDebut.get(Calendar.MONTH),defaultDebut.get(Calendar.DAY_OF_MONTH));
		defaultFin.roll(Calendar.YEAR,true);
		defaultFin.set(Calendar.DAY_OF_MONTH,defaultDebut.get(Calendar.DAY_OF_MONTH)-1);
		this.getChooserFin().setDate(defaultFin.getTime());
		
	}
	
	
}
