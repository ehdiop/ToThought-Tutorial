package com.xyz.myproject.model.general;
/**
 * Les types de sous-traitants admis (dans le cas "entité", il s'agit d'une dépense à un tiers, et non
 * d'une dépense de sous-traitance).
 * @author Raoul
 *
 */
public enum TypeST {
	
	INDIVIDU("individu"), ENTREPRISE("entreprise"), ENTITE("Entité agréée aux fins de la RSDE");
	
	private String nom;

	private TypeST(String nom){
		this.nom=nom;
	}
	
	@Override
	public String toString(){
		return this.nom;
	}
}
