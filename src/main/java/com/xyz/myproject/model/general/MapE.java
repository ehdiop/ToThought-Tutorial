package com.xyz.myproject.model.general;

import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;
import java.util.Set;
/**
 * Map générique, utile pour être observé par les controllers.
 * @author Raoul
 *
 * @param <E>
 * @param <V>
 */
public class MapE<E,V> extends Observable {
	
	protected HashMap<E, V> map;
	
	public MapE(){
		this.map=new HashMap<E, V>();
	}
	
	public V get(E key){
		return map.get(key);
	}
	
	protected void put(E key, V v, Enum message){
		this.map.put(key,v);
		this.setChanged();
		this.notifyObservers(message);
	}
	
	protected void remove(E key, Enum message){
		this.map.remove(key);
		this.setChanged();
		this.notifyObservers(message);
	}
	
	public Collection<V> values(){
		return this.map.values();
	}
	
	public Set<E> keySet(){
		return map.keySet();
	}
	
	public void clear(){
		map.clear();
	}
	
	public int size(){
		return map.size();
	}
}
