package com.xyz.myproject.model.general;
/**
 * Lors d'une d�pense � un tiers, le formulaire demande quel type d'entit� est le tiers. Les types 
 * d'entit�s admis sont repr�sent�s par cet enum.
 * @author Raoul
 *
 */
public enum TypeEntite {
	UNIVCOLLEGE("Universit�, coll�ge, institut de recherche ou �tablissement semblable reconnus par Revenu Qu�bec "),
	SOCIETERD("soci�t� de R-D sans but lucratif "),
	ASSOC("Association reconnue par Revenu Qu�bec pour entreprendre des activit�s de R-D"),
	ORGANISME("Organisme reconnu par Revenu Qu�bec qui fait des paiements � des entit�s vis�es"),
	AUTRESOCIETE("Autre soci�t� r�sidant au Canada");
	
	private String type;
	
	private TypeEntite(String type){
		this.type = type;
	}
	
	@Override
	public String toString(){
		return this.type;
	}
	
}
