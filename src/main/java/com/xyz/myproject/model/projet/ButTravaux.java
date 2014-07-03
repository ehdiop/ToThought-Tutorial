package com.xyz.myproject.model.projet;

/**
 * Conditionne si l'on remplit la section B ou C du formulaire.
 * @author Raoul
 *
 */
public enum ButTravaux {
	
	DEV_EXP("développement expérimental"), RECH_PURE_APP("Recherche pure et appliquée");
	
	private String but;
	
	private ButTravaux(String but){
		this.but = but;
	}
	
	public String toString(){
		return this.but;
	}
	
	

}
