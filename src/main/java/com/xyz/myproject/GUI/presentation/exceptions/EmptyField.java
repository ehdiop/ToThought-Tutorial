package com.xyz.myproject.GUI.presentation.exceptions;

/**
 * Exception à lever lorsqu'un champ à remplir obligatoirement est vide à la validation.
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
		return "Le champ "+this.field+" ne devrait pas être vide";
	}

}
