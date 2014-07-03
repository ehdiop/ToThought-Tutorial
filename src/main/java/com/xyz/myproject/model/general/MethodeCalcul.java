package com.xyz.myproject.model.general;
/**
 * Enum représentant la méthode de calcul.
 * @author Raoul
 *
 */
public enum MethodeCalcul {
	
	REMPLACEMENT("remplacement"), TRADITIONNELLE("traditionnelle"); 
	private String methode;
	
	private MethodeCalcul(String methode){
		this.methode = methode;
	}
	
	@Override
	public String toString(){
		return methode;
	}

}
