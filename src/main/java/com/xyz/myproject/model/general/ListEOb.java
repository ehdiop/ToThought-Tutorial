package com.xyz.myproject.model.general;

/**
 * Non utilis� car ne marchait pas, pas trouv� pourquoi. Permettrait de ne pas r��crire la m�me chose
 * lorsque l'on �tend ListE.
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
