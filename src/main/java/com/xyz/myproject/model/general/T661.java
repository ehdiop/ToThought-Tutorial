package com.xyz.myproject.model.general;
/**
 * Modélisation du formulaire T661
 * @author Raoul
 *
 */
public class T661 {

	private T661Partie3 partie3;
	private T661Partie4 partie4;
	private T661Partie7 partie7;

	private T661(T661Partie3 partie3, T661Partie4 partie4, T661Partie7 partie7) {
		super();
		this.partie3 = partie3;
		this.partie4 = partie4;
		this.partie7 = partie7;
	}
	
	public T661(){
		this(new T661Partie3(),new T661Partie4(), new T661Partie7());
	}

	public T661Partie3 getPartie3() {
		return partie3;
	}

	public T661Partie4 getPartie4() {
		return partie4;
	}

	public T661Partie7 getPartie7() {
		return partie7;
	}

}
