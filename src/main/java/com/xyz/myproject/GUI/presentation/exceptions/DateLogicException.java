package com.xyz.myproject.GUI.presentation.exceptions;
/**
 * Exception � lever lorsqu'une date de d�but est post�rieure � une date de fin.
 * @author Raoul
 *
 */
@SuppressWarnings("serial")
public class DateLogicException extends NoValidationException {

	private DateType dateType;
	
	public DateLogicException(DateType dateType) {
		this.dateType=dateType;
	}

	@Override
	public String toString() {
		return "La date de d�but d'"+this.dateType.toString()+" doit �tre ant�rieure � sa date de fin";
	}
	
	public String title(){
		return "Probl�me de date";
	}

	public enum DateType {
		PROJET("un projet"), ANNEE("une ann�e financi�re");
		private String value;

		private DateType(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}
	}
}
