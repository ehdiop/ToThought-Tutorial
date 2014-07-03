package com.xyz.myproject.model.projet;

import com.xyz.myproject.model.general.TraitementSalaires;

/**
 * Traitements et salaires des employ�s travaillant � l'�tranger.
 * @author Raoul
 *
 */
public class TSProjetEtr extends TraitementSalaires {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7797967980867234206L;

	public TSProjetEtr() {
		super();
	}

	public TSProjetEtr(double mo_non_determinee, double mo_determinee) {
		super(mo_non_determinee, mo_determinee, 0);
	}
}
