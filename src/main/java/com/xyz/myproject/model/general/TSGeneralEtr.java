package com.xyz.myproject.model.general;

import javax.persistence.Embeddable;

/**
 * The class representing the salaries for work realized outside Canada. A proposition for the value of
 * main d'oeuvre non determinee is updated when the values of salaries for déterminés employees is changed,
 * following this rule (see Guide T661, ligne 307) :
 * ----------------------------------------------------------------------------------------------------------
 * Le montant des salaires admissibles pour les travaux de RSDE effectués à l'étranger doit correspondre
 * au moindre des montants A et B suivant :
 * Montant A : le total des traitements ou salaires pour les travaux de RSDE effectués à l'étranger
 * Montant B : 10% du total des traitements ou salaires relatifs à la RSDE pour les travaux de RSDE effectués
 * au Canada
 * ----------------------------------------------------------------------------------------------------------
 * The proposition for the value, stocked in mo_non_determinee_proposee, is updated when the value of salaries
 * for determinés employees is changed, and that Montant B < Montant A. 
 * 
 * @author Raoul
 *
 */
@Embeddable
public class TSGeneralEtr extends TSGeneral {
	
	private double mo_non_determinee_proposee;
	
	public enum TSGEN_ETR{MO_NON_DET};
	
	public TSGeneralEtr(){
		super();
	}
	
	public TSGeneralEtr(double mo_non_determinee, double mo_determinee,double boni){
		super(mo_non_determinee, mo_determinee, 0, boni);
	}
	
	public void set_propo_mo_non_determinee(double propo_non_determ){
		this.mo_non_determinee_proposee = propo_non_determ;
	}
	
	@Override
	public void setMo_non_determinee(double mo){
		super.setMo_non_determinee(mo);
		this.setChanged();
		this.notifyObservers(TSGEN_ETR.MO_NON_DET);
	}

}
