package com.xyz.myproject.model.exceptions;
/**
 * exception renvoyée lorsqu'un champ de l'objet client est vide
 * @author Raoul
 *
 */
public class ClientException extends Exception{
	
	private String champ;

	public ClientException(String champ) {
		super();
		this.champ = champ;
	}
	
	@Override
	
	public String toString() {
		return "Le champ "+champ+" ne peut pas être vide";
	}
	
	

}
