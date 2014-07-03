package com.xyz.myproject.model.general;

import java.util.List;

import com.xyz.myproject.model.projet.Employee;

/**
 * Les employés du projet. Référencé, mais sans doute pas utilisé. On utilise
 * les employés de l'entreprise (contrairement à CCHRD), indépendemment des
 * projets, et les employés impliqués dans le projet (EmployesProjet).
 */
public class EmployesProjet extends ListE<Employee> implements
		java.io.Serializable {

	public EmployesProjet() {
		super();
	}

	public EmployesProjet(List<Employee> list) {
		super(list);
	}
}