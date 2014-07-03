package com.xyz.myproject.model.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
/**
 * Liste générique. Utile pour être observé par les controllers.
 * @author Raoul
 *
 * @param <E>
 */
public class ListE<E> extends Observable {

	private ArrayList<E> liste;

	public ListE() {
		this(null);
	}

	public ListE(List<E> list) {
		this.liste = new ArrayList<E>();
		if (list != null) {
			for (E e : list) {
				this.liste.add(e);
			}
		}
	}

	public E add(E e, Enum message) {
		this.liste.add(e);
		if(this.countObservers()>0){
			this.setChanged();
			this.notifyObservers(message);
		}
		return e;
	}

	public E remove(E e, Enum message) {
		this.liste.remove(e);
		if(this.countObservers()>0){
			this.setChanged();
			
			this.notifyObservers(message);
		}
		return e;
		
	}
	
	public E remove(int i, Enum message){
		E e=this.liste.remove(i);
		if(this.countObservers()>0){
			this.setChanged();
			this.notifyObservers(message);
		}
		return e;
	}

	public E get(int i) {
		return this.liste.get(i);
	}

	public E get(E e) {
		int index = 0;
		boolean found = false;
		while (!found && index < this.liste.size()) {
			found = this.liste.get(index).equals(e);
			index++;
		}

		if (found) {
			return this.liste.get(index - 1);
		}
		return null;
	}
	

	public int size() {
		return this.liste.size();
	}
	
	public List<E> getList(){
		return this.liste;
	}
	
	public boolean contains(Object o){
		return this.liste.contains(o);
	}
	
	public void setChanged(){
		super.setChanged();
	}
	
	public void notifyObservers(Object o){
		super.notifyObservers(o);
	}

}
