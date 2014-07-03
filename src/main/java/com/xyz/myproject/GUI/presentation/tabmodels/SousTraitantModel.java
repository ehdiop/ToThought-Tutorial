package com.xyz.myproject.GUI.presentation.tabmodels;

import java.util.List;

import com.xyz.myproject.model.general.SousTraitant;
/**
 * Modèle utilisé pour la JTable des sous-traitant (onglet général>sous-traitant)
 * @author Raoul
 *
 */
public class SousTraitantModel extends EModel<SousTraitant> {
	
	
	static{
		entete = new String[]{"Nom", "Description", "Lien de dépendance"};

	}
	

	public SousTraitantModel(List<SousTraitant> sousTraitants) {
		super();

		this.model = sousTraitants;
	}
	
	

	@Override
	public Object getValueAt(int row, int column) {
		SousTraitant leST = this.getModel().get(row);
		
		switch(column){
		case 0 : return leST.getNom();
		case 1 : return leST.getDescription();
		case 2 : return (leST.isDep())?"oui":"non";
		}
		return "";
	}

}
