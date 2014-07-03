package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.xyz.myproject.GUI.presentation.exceptions.EmptyField;
import com.xyz.myproject.GUI.presentation.general.AddSousTraitantDialog;
import com.xyz.myproject.GUI.presentation.tabmodels.SousTraitantModel;
import com.xyz.myproject.model.exceptions.NEException;
import com.xyz.myproject.model.general.CodePostal;
import com.xyz.myproject.model.general.ListeST;
import com.xyz.myproject.model.general.ListeST.SOUT;
import com.xyz.myproject.model.general.NEQ;
import com.xyz.myproject.model.general.NumeroEntreprise;
import com.xyz.myproject.model.general.NumeroIdProv;
import com.xyz.myproject.model.general.Province;
import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.general.TypeEntite;
import com.xyz.myproject.model.general.TypeST;
import com.xyz.myproject.model.projet.DossierClient;

/**
 * Controller utilisé lors de la confirmation de l'ajout/édition d'un
 * sous-traitant
 * 
 * @author Raoul
 * 
 */
public class AddSousTraitantValiderController extends MouseAdapter implements Observer {

	private JTable table;
	private boolean edit;
	private JDialog dialog;
	private DossierClient model;

	public AddSousTraitantValiderController(JTable table, boolean edit,
			JDialog dialog, DossierClient model) {
		super();
		this.table = table;
		this.edit = edit;
		this.dialog = dialog;
		this.model = model;
	}

	@Override
	public void update(Observable arg0, Object message) {
		if(((ListeST.SOUT)message)==SOUT.MODIF){
			((SousTraitantModel)table.getModel()).fireTableDataChanged();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
		String nom = ((AddSousTraitantDialog) this.dialog).getNomField()
				.getText();
		if(nom==null || nom.replace(" ", "").equals(""))throw new EmptyField("nom");
		String description = ((AddSousTraitantDialog) this.dialog)
				.getDescriptionField().getText();
		String adresse = ((AddSousTraitantDialog) this.dialog)
				.getAdresseField().getText();
		String ville = ((AddSousTraitantDialog) this.dialog).getVilleField()
				.getText();
		Province province = (Province) ((AddSousTraitantDialog) this.dialog)
				.getProvinceCombo().getSelectedItem();
		CodePostal cp = new CodePostal((((AddSousTraitantDialog)this.dialog).getCpField().getText()));
		TypeST typeST = (TypeST)((AddSousTraitantDialog)this.dialog).getTypeST().getSelectedItem();
		TypeEntite typeEntite = (TypeEntite)((AddSousTraitantDialog)this.dialog).getTypeEntiteCombo().getSelectedItem();
		boolean dep = ((AddSousTraitantDialog)this.dialog).getOuiField().isSelected();
		String neStr = ((AddSousTraitantDialog)this.dialog).getNeField().getText();
		String idProv = ((AddSousTraitantDialog)this.dialog).getnProvField().getText();
		String neq = ((AddSousTraitantDialog)this.dialog).getNeqField().getText();
		NumeroEntreprise ne = new NumeroEntreprise();
		boolean dispose = true;
		try{
			ne = new NumeroEntreprise(neStr);
		}
		catch(NEException nex){
			int choix = JOptionPane.showConfirmDialog(this.dialog, nex.toString()+(char)10+"Conserver ce NE ?",nex.titre(),JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			dispose = choix == JOptionPane.YES_OPTION;
		}
		finally{
			if(dispose){
				ne.setNe(neStr);
				SousTraitant st = new SousTraitant(nom, description, adresse, ville, province, cp, typeST, typeEntite, dep, ne, new NumeroIdProv(idProv), new NEQ(neq));
				
				if(this.edit){
					//this.model.getSousTraitants().remove(this.table.rowAtPoint(e.getPoint()));
					this.model.getSousTraitants().remove(this.table.getSelectedRow());

				}
				this.model.getSousTraitants().add(st);
				this.dialog.dispose();
				
			}
		}
		}
		catch(EmptyField ex){
			JOptionPane.showMessageDialog(this.dialog, ex.toString(), ex.title(), JOptionPane.WARNING_MESSAGE);
		}
	}

	

}
