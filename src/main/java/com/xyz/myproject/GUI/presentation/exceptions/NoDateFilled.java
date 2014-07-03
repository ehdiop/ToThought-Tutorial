package com.xyz.myproject.GUI.presentation.exceptions;
/**
 * Exception à lever lorsqu'une date à remplir n'a pas été remplie.
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
		return "L'un des champs de type date à renseigner n'a pas été rempli.";
	}

}
