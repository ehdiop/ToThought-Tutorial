package com.xyz.myproject.model.general;

/**
 * Non utilisé car ne marchait pas, pas trouvé pourquoi. Permettrait de ne pas réécrire la même chose
 * lorsque l'on étend ListE.
 * @author Raoul
 *
 * @param <E>
 */
public abstract class ListEOb<E> extends ListE<E> {
	
	protected abstract Enum getEnum();
	
	public void add(E e){
		super.add(e, this.getEnum());
	}

	public void remove(E e){
		super.remove(e, this.getEnum());
	
	}
	
	public void remove(int i){
		super.remove(i,this.getEnum());
	}
	
}
