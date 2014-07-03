package com.xyz.myproject.GUI.presentation.general;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.xyz.myproject.GUI.controller.MRVRController;
import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.MRVR;

/**
 * Panel MRVR (onglet général, cas du calcul par méthode de remplacement).
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class PanelMRVR extends JPanel {

	/**
	 * Le label affichant la valeur calculée du mrvr.
	 */
	private JLabel mrvrLabel = new JLabel();

	/**
	 * Le label affichant la valeur calculée de la base salariale
	 */
	private JLabel bsLabel = new JLabel();

	private Model model;

	// Static variables

	private static final Dimension margeVerticale = new Dimension(40, 20);
	private static final Dimension margeHorizontale = new Dimension(100, 20);
	private static final Dimension fieldDimension = new Dimension(100, 20);

	public PanelMRVR(Model model) {

		this.model=model;

		this.setLayout(new GridLayout(3, 3, 0, 0));
		this.setBorder(null);
		this.bsLabel.setPreferredSize(fieldDimension);
		this.mrvrLabel.setPreferredSize(fieldDimension);


		this.fillGrid();
		JPanel panelCentral = this.buildPanelCentral();
		panelCentral.setBorder(BorderFactory.createEtchedBorder());
		this.add(panelCentral);
		this.fillGrid();
		
		//Controllers :
		MRVR mrvr = (MRVR)this.model.getDossierAnnee().getInfos().getDepenses().getFraisGeneraux();
		MRVRController controller = new MRVRController(mrvr,this);
		mrvr.addObserver(controller);
		mrvr.tmp();
		
		

	}

	private JPanel buildPanelCentral() {
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();

		JLabel bsTitre = new JLabel("Base salariale");
		bsTitre.setFont(PARAMETERS_IHM.font);
		JLabel mrvrTitre = new JLabel("MRVR");
		mrvrTitre.setFont(PARAMETERS_IHM.font);

		JLabel bsCalculeeLegende = new JLabel(
				"Valeur calculée de la base salariale :");
		JLabel mrvrCalculeLegende = new JLabel("Valeur calculée du mrvr :");

		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		cons.insets = new Insets(0, 10, 0, 0);
		cons.anchor = GridBagConstraints.LINE_START;
		// bsTitre
		panelCentral.add(bsTitre, cons);
		// bsCalculeeLegende
		cons.gridy++;
		panelCentral.add(bsCalculeeLegende, cons);
		// mrvrTitre
		cons.gridy++;
		panelCentral.add(mrvrTitre, cons);
		// mrvrCalculeLegende
		cons.gridy++;
		panelCentral.add(mrvrCalculeLegende, cons);

		// bsLabel
		cons.gridx = 1;
		cons.gridy = 1;
		cons.weightx = 1;
		cons.insets = new Insets(0, 10, 0, 0);
		panelCentral.add(bsLabel, cons);
		// rigid
		cons.gridy++;
		panelCentral.add(Box.createRigidArea(fieldDimension));
		// mrvrLabel
		cons.gridy++;
		panelCentral.add(mrvrLabel, cons);

		return panelCentral;

	}

	private void fillGrid() {
		for (int i = 0; i < 4; i++) {
			this.add(new JPanel());
		}
	}

	public JLabel getMrvrLabel() {
		return mrvrLabel;
	}

	public JLabel getBsLabel() {
		return bsLabel;
	}

}
