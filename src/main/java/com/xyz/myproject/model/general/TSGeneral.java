package com.xyz.myproject.model.general;


import javax.persistence.MappedSuperclass;

/**
 * The class to represent salaries for a whole file (not by project).
 * 
 * @author Raoul
 * 
 */

@SuppressWarnings("serial")
@MappedSuperclass
public class TSGeneral extends TraitementSalaires {
	public enum SALAIRES{MODIF};

	protected double boni;

	public enum TSGEN{BONI};


	protected TSGeneral() {
		super();
		boni = 0;
	}

	protected TSGeneral(double mo_non_determinee, double mo_determinee,
			double mo_soutien, double boni) {
		super(mo_non_determinee, mo_determinee, mo_soutien);
		this.boni = boni;
	}

	
	public double getBoni() {
		return boni;
	}

	public void setBoni(double boni) {
		this.boni = boni;
		this.setChanged();
		this.notifyObservers(TSGEN.BONI);
	}
	
	@Override
	public void setMo_non_determinee(double mo_non_determinee) {
		super.setMo_non_determinee(mo_non_determinee);
		this.setChanged();
		this.notifyObservers(SALAIRES.MODIF);
	}
	
	@Override
	public void setMo_determinee(double mo_determinee){
		super.setMo_determinee(mo_determinee);
		this.setChanged();
		this.notifyObservers(SALAIRES.MODIF);
	}
	
	@Override
	public void setMo_soutien(double mo_soutien){
		super.setMo_soutien(mo_soutien);
		this.setChanged();
		this.notifyObservers(SALAIRES.MODIF);
	}

}
