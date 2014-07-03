package com.xyz.myproject.GUI.presentation.exceptions;

/**
 * Exception � lever lorsqu'un champ � remplir obligatoirement est vide � la validation.
 * @author Raoul
 *
 */
public class EmptyField extends NoValidationException {
	
	private String field;

	public EmptyField(String field) {
		super();
		this.field = field;
	}
	
	public String title(){
		return "Champ vide";
	}
	
	@Override
	public String toString() {
		return "Le champ "+this.field+" ne devrait pas �tre vide";
	}

}
