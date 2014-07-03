package com.xyz.myproject.model.exceptions;


public class EmailException extends Exception{

	public EmailException(){
		super();
	}
	
	public String toString(){
		return "L'email rentré ne semble pas conforme";
	}
}
