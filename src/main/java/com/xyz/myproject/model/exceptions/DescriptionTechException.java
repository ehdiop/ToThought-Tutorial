package com.xyz.myproject.model.exceptions;

import com.xyz.myproject.GUI.presentation.exceptions.NoValidationException;

/**
 * Exception renvoy�e lorsque le nombre de mot d'une question de la description technique est sup�rieur �
 * celui autoris�.
 * @author Raoul
 *
 */
public class DescriptionTechException extends NoValidationException {
	
	private int maxWords;
	
	public DescriptionTechException(int maxWords) {
		super();
		this.maxWords = maxWords;
	}
	
	@Override
	public String toString(){
		String message = "Le nombre de mot maximum est d�pass�. Le nombre maximum de mot est de "+maxWords;
		return message;
	}

	@Override
	public String title() {
		return "Avertissement : limite de mots d�pass�e";
	}
	
	
	
	

}
