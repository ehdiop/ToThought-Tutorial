package com.xyz.myproject.model.projet;

import java.util.HashMap;
import java.util.Iterator;

import com.xyz.myproject.model.general.SousTraitant;
/**
 * Permet de retrouver une dépense de sous-traitance à partir du sous-traitant avec un cout minimal (des fois
 * qu'on ait des centaines de millier de dépenses de sous-traitance, qui sait...).
 * @author Raoul
 *
 * @param <E>
 */
public class DepensesSousTraitance<E extends DepenseSousTraitance> extends DepenseAbstract {
	
	public enum DEP_ST{MODIF};
	
	protected HashMap<SousTraitant,E> depenses;
	
	public DepensesSousTraitance(){
		this.depenses=new HashMap<SousTraitant, E>();
	}

	public void add(E dep){
		this.depenses.put(dep.getSousTraitant(),dep);
		this.setChanged();
		this.notifyObservers(DEP_ST.MODIF);
	}
	
	public void remove(SousTraitant st){
		this.depenses.remove(st);
		this.setChanged();
		this.notifyObservers(DEP_ST.MODIF);
	}
	
	public E get(SousTraitant key){
		return this.depenses.get(key);
	}
	
	public double total(){
		double total=0;
		Iterator<SousTraitant> it = depenses.keySet().iterator();
		while(it.hasNext()){
			total+=depenses.get(it.next()).getMontant();
		}
		return total;
	}

	public HashMap<SousTraitant, E> getDepenses() {
		return depenses;
	}

	public void setDepenses(HashMap<SousTraitant, E> depenses) {
		this.depenses = depenses;
	}
	
	
}
