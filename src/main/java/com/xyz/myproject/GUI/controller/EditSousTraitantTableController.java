package com.xyz.myproject.GUI.controller;

import javax.swing.JDialog;
import javax.swing.JTable;

import com.xyz.myproject.GUI.presentation.general.AddSousTraitantDialog;
import com.xyz.myproject.GUI.presentation.tabmodels.SousTraitantModel;
import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.projet.DossierClient;

/**
 * Controller gérant l'ouverture d'une boite de dialog d'édition des sous-traitant (lors d'un double
 * clic sur un sous-traitant dans l'onglet "sous traitant".
 * @author Raoul
 *
 */
public class EditSousTraitantTableController extends
		EditEController<AddSousTraitantDialog> {
	
	private JTable table;
	private DossierClient model;

	public EditSousTraitantTableController(JDialog owner, JTable table, DossierClient dossier) {
		super(owner, table);
		this.model=dossier;
		this.table=table;
		
	}

	@Override
	protected void fillField(AddSousTraitantDialog dialog) {
		SousTraitant sousTraitant = ((SousTraitantModel) this.table.getModel())
				.getModel().get(this.table.getSelectedRow());
		dialog.setNomField(sousTraitant.getNom());
		dialog.setAdresseField(sousTraitant.getAdresse());
		dialog.setDescriptionField(sousTraitant.getDescription());
		dialog.setVilleField(sousTraitant.getVille());
		dialog.setProvinceCombo(sousTraitant.getProvince());
		dialog.setCpField(sousTraitant.getCp().getCp_value());
		dialog.setTypeST(sousTraitant.getType());
		dialog.setOuiField(sousTraitant.isDep());
		dialog.setNonField(!sousTraitant.isDep());
		dialog.setNeField(sousTraitant.getNe().getNe());
		dialog.setnProvField(sousTraitant.getNumProv().getNumProv());
		dialog.setNeqField(sousTraitant.getNeq().getNeq());
		
	}

	@Override
	protected AddSousTraitantDialog getInstance() {
		return new AddSousTraitantDialog(true,table,model);
	}

}
