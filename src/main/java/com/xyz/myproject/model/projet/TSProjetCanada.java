package com.xyz.myproject.model.projet;

import com.xyz.myproject.model.general.TraitementSalaires;
/**
 * Les dépenses de traitements et salaires générales des employés travaillant au Canada.
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
