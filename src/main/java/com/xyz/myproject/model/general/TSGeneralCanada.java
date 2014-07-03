package com.xyz.myproject.model.general;


import javax.persistence.Embeddable;

/**
 * The class representing the salaries for work realized in Canada
 * @author Raoul
 *
 */
@Embeddable

public class TSGeneralCanada extends TSGeneral {
	
	public enum EVENT_TSGEN_CA {MO_NON_DET};
	

	
	public TSGeneralCanada(){
		super();
	}
	
	public TSGeneralCanada(double mo_non_determinee_ca, double mo_determinee_ca, double mo_soutien,  double boni){
		super(mo_non_determinee_ca, mo_determinee_ca, mo_soutien, boni);
	}
	
	
	

	@Override
	public void setMo_non_determinee(double mo_non_determinee) {
		super.setMo_non_determinee(mo_non_determinee);
		this.setChanged();
		this.notifyObservers(EVENT_TSGEN_CA.MO_NON_DET);
	}

}
