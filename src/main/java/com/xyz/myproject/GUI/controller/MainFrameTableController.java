package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import com.xyz.myproject.GUI.presentation.AjoutAnneeDialog;
import com.xyz.myproject.GUI.presentation.MainFrameDossier;
import com.xyz.myproject.GUI.presentation.Tools;
import com.xyz.myproject.GUI.presentation.tabmodels.ClientModel;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.ListClient;

/**
 * Le controleur de la JTable de la frame principale.
 * Comportement :
 * Clic droit : un menu s'ouvre avec la possibilité d'éditer le client, d'ouvrir le client, 
 * ou de le supprimer
 * double clic gauche : s'il n'existe pas d'année financière, une JDialog s'ouvre pour créer une année
 * financière, s'il en existe une, on ouvre MainFrameDossier
 * @author Raoul
 *
 */
public class MainFrameTableController extends MouseAdapter implements Observer {

	private JTable jtable;
	private ListClient model;
	private JFrame frame;

	public MainFrameTableController(JTable jtable, ListClient model,
			JFrame frame) {
		super();
		this.jtable = jtable;
		this.model = model;
		this.frame = frame;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ListClient.LISTE_CLIENT message = (ListClient.LISTE_CLIENT) arg1;
		switch (message) {
		case MODIF:
			((ClientModel) jtable.getModel()).fireTableDataChanged();
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			JPopupMenu popupMenu = new JPopupMenu();
			JMenuItem editer = new JMenuItem("éditer");
			
			// Récupération du client
			Client client = ((ClientModel) this.jtable.getModel())
					.getClients().get(this.jtable.rowAtPoint(e.getPoint()));
			editer.addMouseListener(new MainFrameAjouterClientController(frame, model, client,true, jtable));
			
			JMenuItem nouvelleAnnee = new JMenuItem("nouvelle année");
			nouvelleAnnee.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					Client passedModel = MainFrameTableController.this.model.get(MainFrameTableController.this.jtable.rowAtPoint(e.getPoint()));
					AjoutAnneeDialog ajoutAnnee = new AjoutAnneeDialog(passedModel, false);
					ajoutAnnee.pack();
					ajoutAnnee.setModal(true);
					ajoutAnnee.setLocationRelativeTo(frame);
					ajoutAnnee.setVisible(true);
				}

			});

			JMenuItem ouvrir = new JMenuItem("ouvrir");
			popupMenu.add(editer);
			popupMenu.add(nouvelleAnnee);
			popupMenu.add(ouvrir);
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		} else {
			
			// DOUBLE CLIC
			if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
				// Récupération du client
				Client client = ((ClientModel) this.jtable.getModel())
						.getClients().get(this.jtable.getSelectedRow());
				
				//-------------------------------------------------------------------------------------------------------------
				System.out.println(client.getVille());
				//-------------------------------------------------------------------------------------------------------------

				// Ouverture du dossier-client : on vérifie si une année a déjà été créée
				if (client.getDossierClient().getDossiersAnnee().size() == 0
						|| client.getDossierClient().getDossiersAnnee().get(client.getDossierClient().getAnnees().get(0))
								.getAnnee() == null) {
					Client passedModel = MainFrameTableController.this.model.get(MainFrameTableController.this.jtable.rowAtPoint(e.getPoint()));

					Tools.displayChildDialog(new AjoutAnneeDialog(passedModel, false), frame);
				} else {
					MainFrameDossier mainFrameDossier = new MainFrameDossier(
							client);

					mainFrameDossier.pack();
					mainFrameDossier.setLocationRelativeTo(this.frame);
					mainFrameDossier.setModal(true);

					mainFrameDossier.setVisible(true);
				}
			}
		}

	}

}
