package com.xyz.myproject.GUI.presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.xyz.myproject.GUI.controller.AddAnneeGeneralController;
import com.xyz.myproject.GUI.controller.AddEController;
import com.xyz.myproject.GUI.controller.AddProjetGeneralController;
import com.xyz.myproject.GUI.controller.ChangeProjetController;
import com.xyz.myproject.GUI.controller.MAJAnneeComboController;
import com.xyz.myproject.GUI.controller.MAJAnneeCouranteCombo;
import com.xyz.myproject.GUI.controller.MAJPanelsMOController;
import com.xyz.myproject.GUI.controller.MAJProjetComboController;
import com.xyz.myproject.GUI.controller.MAJProjetCourantCombo;
import com.xyz.myproject.GUI.presentation.general.DialogRD1029;
import com.xyz.myproject.GUI.presentation.general.DialogT661;
import com.xyz.myproject.GUI.presentation.general.PanelEmploye;
import com.xyz.myproject.GUI.presentation.general.PanelEmployesImpliques;
import com.xyz.myproject.GUI.presentation.general.PanelFraisGeneraux;
import com.xyz.myproject.GUI.presentation.general.PanelMO;
import com.xyz.myproject.GUI.presentation.general.PanelMRVR;
import com.xyz.myproject.GUI.presentation.general.PanelSousTraitant;
import com.xyz.myproject.GUI.presentation.projet.PanelDepense;
import com.xyz.myproject.GUI.presentation.projet.PanelDescrTech;
import com.xyz.myproject.GUI.presentation.projet.PanelDescrTechDev;
import com.xyz.myproject.GUI.presentation.projet.PanelDescrTechRech;
import com.xyz.myproject.GUI.presentation.projet.PanelInfo;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.MethodeCalcul;
import com.xyz.myproject.model.projet.ButTravaux;
import com.xyz.myproject.model.projet.DossierAnnee;
import com.xyz.myproject.model.projet.DossierClient;
import com.xyz.myproject.model.projet.ListeProjet;
import com.xyz.myproject.model.projet.Projet;
import com.xyz.myproject.model.sectionsBC.SectionB;
import com.xyz.myproject.model.sectionsBC.SectionC;

@SuppressWarnings("serial")
public class MainFrameDossier extends JDialog {

	private Container pane;
	private JLabel labelClient, labelProjet;
	private Model model;
	private JComboBox<Annee> anneesCombo;
	private JComboBox<Projet> projetsCombo;
	private JTabbedPane paneMo, grandePane;
	private JMenuItem t661;

	// Constantes statiques
	private static Dimension maxLabelGauche = new Dimension(300, 50);
	private static ImageIcon iconePlus = new ImageIcon("ressources"
			+ File.separator + "iconefi.png");
	private static ImageIcon iconePlusPressed = new ImageIcon("ressources"
			+ File.separator + "iconefipressed.png");
	private static Dimension dimensionCombos = new Dimension(80, 20);
	private static Dimension dimensionAddButton = new Dimension(25, 25);
	private static Insets insetPanels = new Insets(0, 5, 5, 5);
	private static final String panelMoTitle = "Traitements et salaires";
	private static final String paneMRVRTitle = "MRVR";
	private static final String panelProjetTitre = "Projet";
	public static final String panelDescriptionTitre = "Description technique";
	private static final String panelFraisGTitre = "Frais généraux";
	
	/**
	 * L'index de l'onglet MRVR ou Frais Généraux
	 */
	private static final int indexMRVR = 2;

	public MainFrameDossier(Client client) {
//		Annee anneeModel = client.getDossierClient().getDossiersAnnee()
//				.get(client.getDossierClient().getAnnees().get(0)).getAnnee();
		Annee anneeModel = client.getDossierClient().getAnnees().get(0);
		System.out.println("MainFrameDossier L95 : "+client.getDossierClient().getDossiersAnnee().containsKey(anneeModel));
//		System.out.println("MainFrameDossier L96 : "+client.getDossierClient().getDossiersAnnee().containsKey(anneeModel2));
		ListeProjet projets = client.getDossierClient().getDossierAnnee(anneeModel).getProjets();
		
		
		Projet projetModel = (projets.size() != 0) ? projets.get(0) : null;
		this.model = new Model(client);

		this.model.setAnnee(anneeModel);
		this.pane = this.getContentPane();
		this.pane.setLayout(new BorderLayout());
		this.init();
		this.buildMenuBar();
		this.buildPanelHaut();
		this.buildPanelBas();
		// Controleurs
		ChangeProjetController controller = new ChangeProjetController(
				this.model, this);
		this.model.addObserver(controller);

	}

	private void buildPanelHaut() {
		// Instanciation du panelHaut
		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(BorderFactory.createEtchedBorder());
		panelHaut.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
		this.pane.add(panelHaut, BorderLayout.NORTH);

		// Panel information
		JPanel panelInfo = new JPanel();

		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
		JLabel labelClient = new JLabel("Entreprise : "
				+ this.model.getClient().getEntreprise());
		labelClient.setMaximumSize(maxLabelGauche);
		this.labelProjet = new JLabel("Projet : "
				+ ((this.model.getProjet() != null) ? this.model.getProjet()
						: "aucun"));
		labelProjet.setMaximumSize(maxLabelGauche);
		panelInfo.add(labelClient);
		panelInfo.add(labelProjet);
		panelHaut.add(panelInfo);

		// Panel Annee
		JPanel panelAnnee = new JPanel();
		panelHaut.add(panelAnnee);
		panelAnnee.setLayout(new GridBagLayout());
		GridBagConstraints consAnnee = new GridBagConstraints();

		JLabel labelAnnee = new JLabel("année");
		consAnnee.gridx = 1;
		consAnnee.gridy = 0;
		consAnnee.gridwidth = 1;
		consAnnee.gridheight = 1;
		consAnnee.weightx = 0;
		consAnnee.weighty = 0;
		consAnnee.insets = insetPanels;
		panelAnnee.add(labelAnnee, consAnnee);

		JButton addButtonAnnee = new JButton(iconePlus);
		addButtonAnnee.addMouseListener(new AddAnneeGeneralController(this,
				this.getClientModel(), false));
		addButtonAnnee.setPreferredSize(dimensionAddButton);
		addButtonAnnee.setPressedIcon(iconePlusPressed);
		consAnnee.gridx = 0;
		consAnnee.gridy = 1;
		consAnnee.gridwidth = 1;
		panelAnnee.add(addButtonAnnee, consAnnee);

		this.anneesCombo.setSelectedItem(this.getAnneeModel());
		this.anneesCombo.setPreferredSize(dimensionCombos);
		consAnnee.gridx = 1;
		consAnnee.gridwidth = 1;
		panelAnnee.add(this.anneesCombo, consAnnee);

		// Panel projet
		JPanel panelProjet = new JPanel();
		panelProjet.setLayout(new GridBagLayout());
		panelHaut.add(panelProjet);
		GridBagConstraints consProjet = new GridBagConstraints();
		consProjet.gridx = 0;
		consProjet.gridy = 1;
		consProjet.gridwidth = 1;
		consProjet.insets = insetPanels;

		JButton addButtonProjet = new JButton(iconePlus);
		addButtonProjet.addMouseListener(new AddProjetGeneralController(this,
				this.getModel()));
		addButtonProjet.setPressedIcon(iconePlusPressed);
		addButtonProjet.setPreferredSize(dimensionAddButton);
		panelProjet.add(addButtonProjet, consProjet);

		consProjet.gridx = 1;
		consProjet.gridy = 0;
		JLabel labelProjet2 = new JLabel("projet");
		panelProjet.add(labelProjet2, consProjet);

		consProjet.gridy = 1;

		this.projetsCombo.setPreferredSize(dimensionCombos);
		panelProjet.add(this.projetsCombo, consProjet);

	}

	private void buildPanelBas() {
		JPanel panelBas = new JPanel();
		panelBas.setLayout(new BorderLayout());
		panelBas.setPreferredSize(new Dimension(900, 500));
		this.pane.add(panelBas, BorderLayout.CENTER);
		// Pane General/projet
		this.grandePane = new JTabbedPane();
		panelBas.add(grandePane);
		// Pane Generale
		JTabbedPane petitePane = new JTabbedPane();
		grandePane.add(petitePane, "General");

		// Main d'oeuvre
		this.paneMo = new JTabbedPane();
		this.paneMo.add(
				new PanelEmploye(this, this.getClientModel(), this
						.getAnneeModel()), "Employés");
		petitePane.add(this.paneMo, "Main d'oeuvre");

		// Sous traitant
		JPanel panelSousTraitant = new PanelSousTraitant(this,
				this.getDossierClient());
		petitePane.add(panelSousTraitant, "Sous-traitants");

		// MO
		System.out.println("MainFrameDossier L225 (valeur du model) : "+this.getDossierAnneeModel());
		PanelMO panelMO = new PanelMO(this, this.getDossierAnneeModel());
		this.model.addObserver(new MAJPanelsMOController(this.model, this));
		this.paneMo.add(panelMO, panelMoTitle);

		// Frais généraux
		if (this.model.getAnnee().getMethod() == MethodeCalcul.REMPLACEMENT) {
			JPanel panelMRVR = new PanelMRVR(this.getModel());
			this.paneMo.add(panelMRVR, paneMRVRTitle);
		} else {
			JPanel panelFraisG = new PanelFraisGeneraux(this.getModel());
			this.paneMo.add(panelFraisG, panelFraisGTitre);
		}

		// Pane projet
		if (this.model.getProjet() != null) {
			this.majProjetPane();
		} else {
			this.setPanelProjet(new JTabbedPane(), false);
		}

	}

	private void buildMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("menu");
		menuBar.add(menu);
		JMenuItem importation = new JMenuItem("Importer un fichier excel");
		JMenuItem export = new JMenuItem("Exporter les annexes");
		JMenuItem revenir = new JMenuItem("Revenir à la liste client");
		JMenu formulaires = new JMenu("Formulaires");
		menu.add(importation);
		menu.add(export);
		menu.add(revenir);
		menu.add(formulaires);
		
		this.t661 = new JMenuItem("T661");
		this.t661.addMouseListener(new AddEController<DialogT661>(this){
			@Override
			public DialogT661 getInstance(){
				return new DialogT661(MainFrameDossier.this.model);
			}
		});
		JMenuItem rd1029 = new JMenuItem("RD 1029.7");
		rd1029.addMouseListener(new AddEController<DialogRD1029>(this) {

			@Override
			public DialogRD1029 getInstance() {
				return new DialogRD1029(MainFrameDossier.this.model);
			}
		});
		
		formulaires.add(t661);
		formulaires.add(rd1029);
		this.setJMenuBar(menuBar);
	}

	private void init() {
		this.anneesCombo = new JComboBox<Annee>(this.getClientModel()
				.getDossierClient().getAnnees());
		MAJAnneeComboController controllerAnnee1 = new MAJAnneeComboController(
				this, this.model);
		this.getDossierClient().addObserver(controllerAnnee1);
		MAJAnneeCouranteCombo controllerAnnee2 = new MAJAnneeCouranteCombo(
				this.model, this);
		this.model.addObserver(controllerAnnee2);
		this.anneesCombo.addActionListener(controllerAnnee2);

		this.projetsCombo = new JComboBox<Projet>(new Vector<Projet>(this
				.getDossierClient().getDossierAnnee(this.getAnneeModel())
				.getProjets().getList()));
		MAJProjetComboController controllerCombo = new MAJProjetComboController(
				this, this.getDossierAnneeModel().getProjets());
		this.getDossierAnneeModel().getProjets().addObserver(controllerCombo);
		this.model.addObserver(controllerCombo);
		MAJProjetCourantCombo controllerCombo2 = new MAJProjetCourantCombo(
				this, model);
		this.model.addObserver(controllerCombo2);
		this.projetsCombo.addActionListener(controllerCombo2);
		
	}

	// GETTERS AND SETTERS

	public JLabel getLabelClient() {
		return labelClient;
	}

	public void setLabelClient(JLabel labelClient) {
		this.labelClient = labelClient;
	}

	public JLabel getLabelProjet() {
		return labelProjet;
	}

	public void setLabelProjet(JLabel labelProjet) {
		this.labelProjet = labelProjet;

	}

	public JComboBox<Annee> getAnneesCombo() {
		return anneesCombo;
	}

	public void setAnneesCombo(JComboBox<Annee> anneesCombo) {
		this.anneesCombo = anneesCombo;
	}

	public JComboBox<Projet> getProjetsCombo() {
		return projetsCombo;
	}

	public void setProjetsCombo(JComboBox<Projet> projetsCombo) {
		this.projetsCombo = projetsCombo;
	}

	public Client getClientModel() {
		return this.model.getClient();
	}

	public Annee getAnneeModel() {
		return this.model.getAnnee();
	}

	public void setAnneeModel(Annee anneeModel) {
		this.model.setAnnee(anneeModel);
	}

	public Projet getProjetModel() {
		return this.model.getProjet();
	}

	public void setProjetModel(Projet projetModel) {
		this.model.setProjet(projetModel);
	}

	public DossierAnnee getDossierAnneeModel() {
		return this.model.getDossierAnnee();
	}

	public DossierClient getDossierClient() {
		return this.model.getDossierClient();
	}

	/**
	 * Retire l'onglet MRVR/Frais Generaux.
	 */
	private void removeOngletMRVR() {
		try {
			this.paneMo.remove(paneMo.indexOfTab(panelFraisGTitre));

		} catch (IndexOutOfBoundsException e) {

		}
		try {
			this.paneMo.remove(paneMo.indexOfTab(paneMRVRTitle));

		} catch (IndexOutOfBoundsException e) {

		}
	}

	public void setPanelMO(PanelMO panelMO) {
		try {
			this.paneMo.remove(paneMo.indexOfTab(panelMoTitle));
		} catch (IndexOutOfBoundsException e) {

		}

		this.paneMo.add(panelMO, panelMoTitle, 1);
	}

	public void setPanelMRVR(PanelMRVR panelMRVR) {
		this.removeOngletMRVR();
		this.paneMo.add(panelMRVR, paneMRVRTitle, indexMRVR);
	}

	public void setPanelFraisGen(PanelFraisGeneraux panel) {
		this.removeOngletMRVR();
		this.paneMo.add(panel, panelFraisGTitre, indexMRVR);
	}

	public void setPanelProjet(JTabbedPane panelProjet, boolean enabled) {
		try {
			this.grandePane
					.remove(this.grandePane.indexOfTab(panelProjetTitre));
		} catch (IndexOutOfBoundsException e) {

		}
		this.grandePane.add(panelProjet, panelProjetTitre, 1);
		this.grandePane.setEnabledAt(
				this.grandePane.indexOfTab(panelProjetTitre), enabled);
	}

	public void setPanelDescription(PanelDescrTech panel) {
		JTabbedPane paneProjet = (JTabbedPane) this.grandePane
				.getComponentAt(this.grandePane.indexOfTab(panelProjetTitre));
		int index = paneProjet.indexOfTab(panelDescriptionTitre);
		try {
			paneProjet.remove(index);

		} catch (IndexOutOfBoundsException e) {

		}
		paneProjet.add(panel, panelDescriptionTitre, paneProjet.getTabCount());
	}

	public void majProjetPane() {

		this.setPanelProjet((model.getProjet() != null) ? buildProjetPane()
				: new JTabbedPane(), this.getProjetModel() != null);
	}

	private JTabbedPane buildProjetPane() {
		// Pane projet
		JTabbedPane projetPane = new JTabbedPane();

		// Pane employe implique

		projetPane.add(new PanelEmployesImpliques(this, this.getModel()),
				"Employés impliqués");

		// Pane depenses

		projetPane.add(new PanelDepense(this, this.model), "Dépenses");

		// Pane Informations générales

		projetPane.add(new PanelInfo(this.model), "Informations générales");

		// Pane description technique

		PanelDescrTech panelDesc;
		if (this.model.getProjet().getInformationsGenerales().getButTravaux() == ButTravaux.DEV_EXP) {
			panelDesc = new PanelDescrTechDev(this.model);
			panelDesc.fillWith((SectionB) this.model.getProjet()
					.getInformationsGenerales().getDescTech());
		} else {
			panelDesc = new PanelDescrTechRech(this.model);
			panelDesc.fillWith((SectionC) this.model.getProjet()
					.getInformationsGenerales().getDescTech());
		}
		projetPane.add(panelDesc, MainFrameDossier.panelDescriptionTitre);
		return projetPane;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
