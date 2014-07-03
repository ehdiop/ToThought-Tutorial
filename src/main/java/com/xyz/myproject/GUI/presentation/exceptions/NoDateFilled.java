package com.xyz.myproject.GUI.presentation.exceptions;
/**
 * Exception � lever lorsqu'une date � remplir n'a pas �t� remplie.
 * @author Raoul
 *
 */

@SuppressWarnings("serial")
public class NoDateFilled extends NoValidationException {
	
	@Override
	public String title(){
		return "Date manquante";
	}
	@Override
	public String toString() {
		return "L'un des champs de type date � renseigner n'a pas �t� rempli.";
	}

}
