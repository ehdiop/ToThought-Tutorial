package com.xyz.myproject.model.exceptions;

/**
 * Regroupe les exceptions rejetées pour des problèmes liés aux dates. Instances can only be built using 
 * throwing method, passing a CAL_EXC enum in argument. This is to allow several cases for CalendarException
 * and control the displayed messages inside the concerned class.
 * WRONG_CAL_SEQUENCE : 
 * @author Raoul
 *
 */
public class CalendarException {
	
	private String message;
	
	public enum CAL_EXC{WRONG_CAL_SEQUENCE}

	private CalendarException(String message) {
		super();
		this.message = message;
	}
	
	public String toString(){
		return this.message;
	}
	
	public CalendarException throwing(CAL_EXC exception_type){
		String message="";
		switch(exception_type){
		case WRONG_CAL_SEQUENCE : message = "La date de début est inférieure à la date de fin";break;
		
		}
		return new CalendarException(message);
	}

}
