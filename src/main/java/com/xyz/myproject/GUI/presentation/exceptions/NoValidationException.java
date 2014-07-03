package com.xyz.myproject.GUI.presentation.exceptions;

/**
 * Exception à étendre lorsqu'utilisée pour afficher dans une JOptionPane (permet d'afficher un titre
 * à la JOptionPane).
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public abstract class NoValidationException extends Exception {

	public abstract String title();
	
	
}
