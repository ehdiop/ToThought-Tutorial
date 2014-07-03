package com.xyz.myproject.model.general;
/**
 * Les types de sous-traitants admis (dans le cas "entit�", il s'agit d'une d�pense � un tiers, et non
 * d'une d�pense de sous-traitance).
 * @author Raoul
 *
 */
public enum TypeST {
	
	INDIVIDU("individu"), ENTREPRISE("entreprise"), ENTITE("Entit� agr��e aux fins de la RSDE");
	
	private String nom;

	private TypeST(String nom){
		this.nom=nom;
	}
	
	@Override
	public String toString(){
		return this.nom;
	}
}
