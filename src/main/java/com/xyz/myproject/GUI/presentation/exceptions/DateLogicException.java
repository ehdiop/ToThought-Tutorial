package com.xyz.myproject.GUI.presentation.exceptions;
/**
 * Exception à lever lorsqu'une date de début est postérieure à une date de fin.
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
		return "La date de début d'"+this.dateType.toString()+" doit être antérieure à sa date de fin";
	}
	
	public String title(){
		return "Problème de date";
	}

	public enum DateType {
		PROJET("un projet"), ANNEE("une année financière");
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
