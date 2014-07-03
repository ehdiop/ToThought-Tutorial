package com.xyz.myproject.model.projet;

import com.xyz.myproject.model.general.TraitementSalaires;
/**
 * Les d�penses de traitements et salaires g�n�rales des employ�s travaillant au Canada.
 * @author Raoul
 *
 */
public class TSProjetCanada extends TraitementSalaires {

	public TSProjetCanada() {
		super();
	}
	
	public TSProjetCanada(double mo_non_determinee, double mo_determinee,
			double mo_soutien){
		super(mo_non_determinee, mo_determinee,
				mo_soutien);
		
	}
}
