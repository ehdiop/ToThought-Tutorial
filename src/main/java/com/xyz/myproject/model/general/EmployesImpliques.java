package com.xyz.myproject.model.general;

import java.util.List;

import com.xyz.myproject.model.projet.Employee;

/**
 * Les employés impliqués. Utile pour être observé par les controllers.
 * @author Raoul
 *
 */

public class EmployesImpliques extends ListE<Employee> implements java.io.Serializable{
	
	public EmployesImpliques(){
		super();
	}
	
	public EmployesImpliques(List<Employee> list){
		super(list);
	}
	
	public void add(Employee e){
		super.add(e, null);
	}
	
	public void remove(Employee e){
		super.remove(e,null);
	}

}