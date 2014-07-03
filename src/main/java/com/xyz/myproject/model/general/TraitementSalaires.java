package com.xyz.myproject.model.general;

import java.util.Observable;

import javax.persistence.MappedSuperclass;

import com.xyz.myproject.model.projet.DepenseAbstract;

/**
 * The basic information for salaries. This abstract class is extended by
 * classes representing the salaries by project and for the general file.
 * 
 * @generated
 */

@MappedSuperclass
public abstract class TraitementSalaires extends DepenseAbstract implements java.io.Serializable {

	private static final long serialVersionUID = -1102278243L;
	
	
	protected double mo_non_determinee;

	protected double mo_soutien;

	protected double mo_determinee;

	protected TraitementSalaires() {
		this(0, 0, 0);
	}

	protected TraitementSalaires(double mo_non_determinee, double mo_determinee,
			double mo_soutien) {
		super();
		this.mo_non_determinee = mo_non_determinee;
		this.mo_determinee = mo_determinee;
		this.mo_soutien = mo_soutien;
	}

	public double getMo_non_determinee() {
		return mo_non_determinee;
	}

	public void setMo_non_determinee(double mo_non_determinee) {
		this.mo_non_determinee = mo_non_determinee;
	
	}

	public double getMo_soutien() {
		return mo_soutien;
	}

	public void setMo_soutien(double mo_soutien) {
		this.mo_soutien = mo_soutien;

	}

	public double getMo_determinee() {
		return mo_determinee;
	}

	public void setMo_determinee(double mo_determinee) {
		this.mo_determinee = mo_determinee;

	}
	
	public double getTotal(){
		return this.getMo_determinee()+this.getMo_non_determinee()+this.getMo_soutien();
	}

	/**
	 * @generated
	 */
	public String toString() {
		return "TraitementSalaires";
	}

}