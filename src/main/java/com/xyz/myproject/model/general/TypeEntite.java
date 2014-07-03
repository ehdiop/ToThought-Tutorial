package com.xyz.myproject.model.general;
/**
 * Lors d'une dépense à un tiers, le formulaire demande quel type d'entité est le tiers. Les types 
 * d'entités admis sont représentés par cet enum.
 * @author Raoul
 *
 */
public enum TypeEntite {
	UNIVCOLLEGE("Université, collège, institut de recherche ou établissement semblable reconnus par Revenu Québec "),
	SOCIETERD("société de R-D sans but lucratif "),
	ASSOC("Association reconnue par Revenu Québec pour entreprendre des activités de R-D"),
	ORGANISME("Organisme reconnu par Revenu Québec qui fait des paiements à des entités visées"),
	AUTRESOCIETE("Autre société résidant au Canada");
	
	private String type;
	
	private TypeEntite(String type){
		this.type = type;
	}
	
	@Override
	public String toString(){
		return this.type;
	}
	
}
