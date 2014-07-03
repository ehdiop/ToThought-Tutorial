package com.xyz.myproject.model.general;
/**
 * La liste des fonctions qu'un employé peut occuper
 * @author Raoul
 *
 */
public enum FonctionEnum {
	
	INGENIEUR("ingénieur"), PRESIDENT("président"), MANOEUVRE("manoeuvre"), PROGRAMMEUR("programmeur"),
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
