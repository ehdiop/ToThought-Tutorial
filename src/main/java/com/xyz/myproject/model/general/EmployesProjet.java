package com.xyz.myproject.model.general;

import java.util.List;

import com.xyz.myproject.model.projet.Employee;

/**
 * Les employ�s du projet. R�f�renc�, mais sans doute pas utilis�. On utilise
 * les employ�s de l'entreprise (contrairement � CCHRD), ind�pendemment des
 * projets, et les employ�s impliqu�s dans le projet (EmployesProjet).
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