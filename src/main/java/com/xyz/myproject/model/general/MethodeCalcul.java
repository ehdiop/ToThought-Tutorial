package com.xyz.myproject.model.general;
/**
 * Enum repr�sentant la m�thode de calcul.
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
