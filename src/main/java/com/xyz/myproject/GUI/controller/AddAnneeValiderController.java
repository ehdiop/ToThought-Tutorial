package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import com.xyz.myproject.GUI.presentation.AjoutAnneeDialog;
import com.xyz.myproject.GUI.presentation.exceptions.DateLogicException;
import com.xyz.myproject.GUI.presentation.exceptions.NoDateFilled;
import com.xyz.myproject.GUI.presentation.exceptions.DateLogicException.DateType;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.MethodeCalcul;
import com.xyz.myproject.model.projet.DossierAnnee;
/**
 * Controller à ajouter sur le bouton ok de la boite de dialogue d'ajout/edition d'année
 * @author Raoul
 *
 */
public class AddAnneeValiderController extends MouseAdapter{
	private Client model;
	private AjoutAnneeDialog dialog;
	
	public AddAnneeValiderController(Client client, AjoutAnneeDialog dialog){
		this.model = client;
		this.dialog=dialog;
	}

	@Override
	public void mouseClicked(MouseEvent e){
		Annee annee;
		
		try{
		JDateChooser chooserDebut = this.dialog.getChooserDebut();
		GregorianCalendar debut  = new GregorianCalendar();
		if(chooserDebut.getDate()==null){
			throw new NoDateFilled();
		}
		debut.setTimeInMillis(chooserDebut.getDate().getTime());
		
		JDateChooser chooserFin = this.dialog.getChooserFin();
		GregorianCalendar fin = new GregorianCalendar();
		if(chooserFin.getDate()==null){
			throw new NoDateFilled();
		}
		fin.setTimeInMillis(chooserFin.getDate().getTime());
		
		if(debut.after(fin)){
			throw new DateLogicException(DateType.ANNEE);
		}
		
		
		MethodeCalcul methode = (this.dialog.getRadioRemplacement().isSelected())?MethodeCalcul.REMPLACEMENT:MethodeCalcul.TRADITIONNELLE;
		annee = new Annee(debut,fin,methode);
		DossierAnnee dossierAnnee = new DossierAnnee(annee);
		
		this.model.getDossierClient().addDossierAnnee(dossierAnnee);
		
		this.dialog.dispose();
		}
		
		catch(NoDateFilled ex){
			JOptionPane.showMessageDialog(this.dialog, ex.toString(),ex.title() , JOptionPane.WARNING_MESSAGE);
		} catch (DateLogicException ex2) {
			JOptionPane.showMessageDialog(this.dialog, ex2.toString(),ex2.title(), JOptionPane.WARNING_MESSAGE);
		}
	}
}
