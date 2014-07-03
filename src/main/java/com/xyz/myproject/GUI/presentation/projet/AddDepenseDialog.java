package com.xyz.myproject.GUI.presentation.projet;

import com.xyz.myproject.GUI.presentation.AddEDialog;
import com.xyz.myproject.model.projet.DepenseAbstract;

/**
 * JDialog � ouvrir pour l'ajout d'une d�pense par double clic dans l'onglet d�pense de l'onglet projet
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
		this.setTitle("Ajout/�dition d'une d�pense");
	}

	public E getDepense() {
		return depense;
	}
}
