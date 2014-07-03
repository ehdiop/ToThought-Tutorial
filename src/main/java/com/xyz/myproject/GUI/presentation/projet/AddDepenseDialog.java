package com.xyz.myproject.GUI.presentation.projet;

import com.xyz.myproject.GUI.presentation.AddEDialog;
import com.xyz.myproject.model.projet.DepenseAbstract;

/**
 * JDialog à ouvrir pour l'ajout d'une dépense par double clic dans l'onglet dépense de l'onglet projet
 * @author Raoul
 *
 * @param <E>
 */

@SuppressWarnings("serial")
public abstract class AddDepenseDialog <E extends DepenseAbstract> extends AddEDialog {
	
	protected E depense;
	protected String titre;
	
	protected AddDepenseDialog(String titre,E depense){
		this.depense = depense;
		this.titre = titre;
		this.setTitle("Ajout/édition d'une dépense");
	}

	public E getDepense() {
		return depense;
	}
}
