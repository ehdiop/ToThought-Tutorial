package com.xyz.myproject.model.sectionsBC;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import com.xyz.myproject.model.exceptions.DescriptionTechException;
/**
 * Modélisation d'une question des sections B ou C. Comprend la méthode checkNumberWords() pour
 * vérifier que le nombre de mot maximum n'est pas dépassé. 
 * @author Raoul
 *
 */
@Embeddable
public class Question {
	
	@Transient
	private int maxWords;
	
	private String texte;
	
	
	
	public Question() {
		super();
	}

	public Question(int maxWords){
		super();
		this.texte="";
		this.maxWords = maxWords;
	}

	public Question(int maxWords, String texte) throws DescriptionTechException {
		super();
		this.maxWords = maxWords;
		this.setTexte(texte);
		
	}

	public int getMaxWords() {
		return maxWords;
	}

	public void setMaxWords(int maxWords) {
		this.maxWords = maxWords;
	}

	public String getTexte() {
		return texte;
	}

	public boolean setTexte(String texte) {
		this.texte = texte;
		return true;
		
	}
	
	// Methodes statiques

	private static int numberOfWords(String string){
		return string.trim().split("\\s").length;
	}
	
	public void checkNumberWords() throws DescriptionTechException{
		if(numberOfWords(this.texte)>getMaxWords()){
			throw new DescriptionTechException(maxWords);
		}
		
	}
}
