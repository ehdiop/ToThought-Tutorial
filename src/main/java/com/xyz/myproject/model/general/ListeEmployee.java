package com.xyz.myproject.model.general;

import com.xyz.myproject.model.projet.Employee;


/**
 * Liste d'employé (relatif à un dossier client, indépendamment de l'année). Etend ListE<E>, lui même
 * étendant observable.
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
