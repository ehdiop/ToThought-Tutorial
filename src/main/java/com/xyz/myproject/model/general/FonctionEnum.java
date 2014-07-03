package com.xyz.myproject.model.general;
/**
 * La liste des fonctions qu'un employ� peut occuper
 * @author Raoul
 *
 */
public enum FonctionEnum {
	
	INGENIEUR("ing�nieur"), PRESIDENT("pr�sident"), MANOEUVRE("manoeuvre"), PROGRAMMEUR("programmeur"),
	SCIENTIFIQUE("scientifique"), TECHNICIEN("technicien");
	
	private String fonction;

	private FonctionEnum(String fonction) {
		this.fonction = fonction;
	}
	
	@Override
	public String toString() {
		return this.fonction;
	}

}
