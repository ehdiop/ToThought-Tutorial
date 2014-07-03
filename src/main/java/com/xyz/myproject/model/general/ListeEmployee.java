package com.xyz.myproject.model.general;

import com.xyz.myproject.model.projet.Employee;


/**
 * Liste d'employ� (relatif � un dossier client, ind�pendamment de l'ann�e). Etend ListE<E>, lui m�me
 * �tendant observable.
 * @author Raoul
 *
 */
public class ListeEmployee extends ListE<Employee> {

	public enum EMPLOYEE{MODIF, ADD, DEL}

//	@Override
//	protected Enum getEnum() {
//		return EMPLOYEE.MODIF;
//	}
	
	public void add(Employee e){
		super.add(e, EMPLOYEE.MODIF);
		this.setChanged();
		this.notifyObservers(EMPLOYEE.ADD);
	}
	
	public void remove(Employee e){
		super.remove(e,EMPLOYEE.MODIF);
		this.setChanged();
		this.notifyObservers(EMPLOYEE.DEL);
	}
	
	public void remove(int i){
		super.remove(i, EMPLOYEE.MODIF);
		this.setChanged();
		this.notifyObservers(EMPLOYEE.DEL);
	}
	
	
	
}
