package com.xyz.myproject.model.projet;

/**
 * Conditionne si l'on remplit la section B ou C du formulaire.
 * @author Raoul
 *
 */
public enum ButTravaux {
	
	DEV_EXP("d�veloppement exp�rimental"), RECH_PURE_APP("Recherche pure et appliqu�e");
	
	private String but;
	
	private ButTravaux(String but){
		this.but = but;
	}
	
	public String toString(){
		return this.but;
	}
	
	

}
