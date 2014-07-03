package com.xyz.myproject.model.projet;


/**
 * Liste des projets. Utile pour être observé par les controleurs.
 */
import com.xyz.myproject.model.general.ListE;

public class ListeProjet extends ListE<Projet> {
	

	public ListeProjet(){
		super();
	}
	

	public void add(Projet projet) {
		super.add(projet, EVENT_DEP.CHGT_PROJET);
		

	}

	public void remove(Projet projet) {
		super.remove(projet, EVENT_DEP.CHGT_PROJET);
		
	}


	

	public void setChanged() {
		super.setChanged();
	}

	public void notifyObservers() {
		if (this.countObservers() > 0) {
			this.notifyObservers(EVENT_DEP.CHGT_PROJET);
		}
	}

}
