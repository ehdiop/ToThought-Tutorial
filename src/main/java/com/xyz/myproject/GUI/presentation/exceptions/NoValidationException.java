package com.xyz.myproject.GUI.presentation.exceptions;

/**
 * Exception � �tendre lorsqu'utilis�e pour afficher dans une JOptionPane (permet d'afficher un titre
 * � la JOptionPane).
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public abstract class NoValidationException extends Exception {

	public abstract String title();
	
	
}
