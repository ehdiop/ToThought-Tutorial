package com.xyz.myproject.model.general;

/**
 * Modélisation de la partie 2 du RD1029.7
 * @author Raoul
 *
 */
public class RD1029Partie2 extends MapE<SousTraitant, Double> {
	

	public RD1029Partie2() {
		super();
	}
	
	public void put(SousTraitant st, double montant){
		super.put(st,montant,null);
	}
	
	public void remove(SousTraitant st){
		super.remove(st, null);
	}
	
	

}
