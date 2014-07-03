package com.xyz.myproject.model.general;

/**
 * Liste des sous-traitants. Utile pour être observé par les controllers.
 * @author Raoul
 *
 */
public class ListeST extends ListE<SousTraitant> {
	
	public enum SOUT{MODIF};
	
	public void remove(SousTraitant st){
		super.remove(st, SOUT.MODIF);
	}
	
	public void remove(int i){
		super.remove(i,SOUT.MODIF);
	}
	
	public void add(SousTraitant st){
		super.add(st,SOUT.MODIF);
	}
	
}
