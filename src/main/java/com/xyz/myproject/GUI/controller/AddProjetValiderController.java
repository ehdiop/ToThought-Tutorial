package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.xyz.myproject.GUI.presentation.MainFrameDossier;
import com.xyz.myproject.GUI.presentation.exceptions.DateLogicException;
import com.xyz.myproject.GUI.presentation.exceptions.DateLogicException.DateType;
import com.xyz.myproject.GUI.presentation.exceptions.EmptyField;
import com.xyz.myproject.GUI.presentation.exceptions.NoDateFilled;
import com.xyz.myproject.GUI.presentation.exceptions.NoValidationException;
import com.xyz.myproject.GUI.presentation.projet.AddProjetDialog;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.controllers.DepensesController;
import com.xyz.myproject.model.projet.Projet;

/**
 * Ce controller crée un projet après validation de l'utilisateur de la JDialog d'ajout d'un projet.
 * Le projet est ensuite ajouté la liste des projets du dossier année. 
 * 
 * @author Raoul
 *
 */
public class AddProjetValiderController extends MouseAdapter {

	private Model model;
	private AddProjetDialog dialog;

	

	public AddProjetValiderController(Model model,
			AddProjetDialog dialog) {
		super();
		this.model = model;
		this.dialog = dialog;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			int numero = (Integer) dialog.getNumSpinner().getValue();
			String titre = dialog.getTitreField().getText();
			if(titre==null||titre.replace(" ","").equals("")){
				throw new EmptyField("titre");
			}
			String responsable = dialog.getRespField().getText();
			Date dateDebut = dialog.getDebutChooser().getDate();
			if (dateDebut == null) {
				throw new NoDateFilled();
			}
			GregorianCalendar debut = new GregorianCalendar();
			debut.setTimeInMillis(dateDebut.getTime());
			
			Date dateFin = dialog.getFinChooser().getDate();
			if(dateFin==null){
				throw new NoDateFilled();
			}
			GregorianCalendar fin = new GregorianCalendar();
			fin.setTimeInMillis(dateFin.getTime());
			
			if(debut.after(fin)){
				throw new DateLogicException(DateType.PROJET);
			}
			
			Projet projet = new Projet(titre, this.model.getAnnee(), this.model.getDossierClient().getEmployes());
			projet.setDebut(debut);
			projet.setFin(fin);
			projet.setResponsable(responsable);
			projet.setNumero(numero);
			MAJPanelDescriptionType controller2 = new MAJPanelDescriptionType(this.model, (MainFrameDossier)dialog.getParent());
			projet.getInformationsGenerales().addObserver(controller2);
			DepensesController depenseController = new DepensesController(this.model.getDossierAnnee().getInfos().getDepenses(), this.model.getDossierAnnee().getProjets());
			projet.getDepenses().addObserver(depenseController);
			this.model.getListeProjets().add(projet);
			this.dialog.dispose();
		} catch (NoValidationException ex) {
			JOptionPane.showMessageDialog(dialog, ex.toString(), ex.title(), JOptionPane.WARNING_MESSAGE);
		}

	}

}
