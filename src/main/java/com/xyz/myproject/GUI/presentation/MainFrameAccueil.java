package com.xyz.myproject.GUI.presentation;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import DAO.DAOListeClients;

import com.xyz.myproject.GUI.controller.MainFrameAjouterClientController;
import com.xyz.myproject.GUI.controller.MainFrameTableController;
import com.xyz.myproject.GUI.presentation.tabmodels.ClientModel;
import com.xyz.myproject.model.general.ListClient;

/**
 * La fenêtre principale contenant un tableau avec la liste des clients et le nombre de leurs projets. Depuis
 * cette fenêtre il est possible de rajouter un client, créer une nouvelle année, ouvrir la fenêtre pour un
 * dossier particulier et éditer les données d'un client.
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class MainFrameAccueil extends JFrame{
	
	private Container conteneur = this.getContentPane();
	public ListClient model;
	
	public MainFrameAccueil(){
		super("Calculs de crédits d'impôt");
		
		DAOListeClients daoListe;
		try {
			daoListe = new DAOListeClients();
			this.model = daoListe.find();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		this.model = new ListClient();  // c'est ici qu'il faut appeler la DAO
		this.setPreferredSize(new Dimension(800, 500));
		
		this.setLayout(new BoxLayout(this.conteneur, BoxLayout.Y_AXIS));
		JPanel panel = new JPanel();

		
		panel.setPreferredSize(new Dimension(500, 300));
		panel.setMaximumSize(new Dimension(500, 300));
		
		panel.setBorder(BorderFactory.createEtchedBorder());
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JTable jtable = new  JTable(new ClientModel(model));
		MainFrameTableController mfController = new MainFrameTableController(jtable,model, this);
		
		model.addObserver(mfController);
		jtable.addMouseListener(mfController);
		
		jtable.setAutoCreateRowSorter(true);
		JScrollPane scroll = new JScrollPane(jtable);
		scroll.setPreferredSize(new Dimension(500,300));
		
		panel.add(scroll);
		panel.setAlignmentX(CENTER_ALIGNMENT);
		JButton ajouter = new JButton("ajouter");
		ajouter.addMouseListener(new MainFrameAjouterClientController(this, model,null, false, jtable));
		ajouter.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(ajouter);
		
		this.conteneur.add(Box.createVerticalGlue());
		this.conteneur.add(panel);
		this.conteneur.add(Box.createVerticalGlue());

		this.placeAuCentre();
		
	}
	
	/**
	 * 
	 * @return L'ordonnée du centre de l'écran
	 */
	private int getHeightCenter(){
		return( Toolkit.getDefaultToolkit().getScreenSize().height/2);
	}
	
	/**
	 * 
	 * @return L'abscisse du centre de l'écran.
	 */
	private int getWidthCenter(){
		return (Toolkit.getDefaultToolkit().getScreenSize().width/2);
	}
	
	/**
	 * Positionne une JFrame au centre de l'écran.
	 */
	
	private void placeAuCentre(){
		this.setLocation((int)(getWidthCenter()-this.getPreferredSize().getWidth()/2), (int)(getHeightCenter()-this.getPreferredSize().getHeight()/2));
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrameAccueil myFrame = new MainFrameAccueil();
		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
