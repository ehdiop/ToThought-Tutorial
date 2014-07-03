package com.xyz.myproject.model.projet;

import java.util.Observable;


/**
 * Les renseignement sur les rédacteurs des section B et C.
 */

public class RenseignementsRedac extends Observable implements java.io.Serializable {
	
	public enum REDACTION{MODIF};
	/**
	 * @generated
	 */
	private boolean employe_implique_boolean;
	
	private Employee employe_implique;
	/**
	 * @generated
	 */
	private boolean autre_employe_boolean;
	
	private Employee autre_employe;
	
	private boolean consultant;
	/**
	 * @generated
	 */
	private String consultant_externe="";
	/**
	 * @generated
	 */
	private String firme_consultant="";

	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1704673242L;
	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	public RenseignementsRedac() {
	}

	/**
	 * @generated
	 */
	public String toString() {
		return "RenseignementsRedac" + " employe_implique=" + employe_implique
				+ " autre_employe=" + autre_employe + " consultant_externe="
				+ consultant_externe + " firme_consultant=" + firme_consultant
				+ " id=" + id;
	}

	

	public boolean isEmploye_implique_boolean() {
		return employe_implique_boolean;
	}

	public void setEmploye_implique_boolean(boolean employe_implique_boolean) {
		this.employe_implique_boolean = employe_implique_boolean;
		this.setChanged();
		this.notifyObservers(REDACTION.MODIF);
	}

	public boolean isAutre_employe_boolean() {
		return autre_employe_boolean;
	}

	public void setAutre_employe_boolean(boolean autre_employe_boolean) {
		this.autre_employe_boolean = autre_employe_boolean;
		this.setChanged();
		this.notifyObservers(REDACTION.MODIF);
	}

	public String getConsultant_externe() {
		return consultant_externe;
	}

	public void setConsultant_externe(String consultant_externe) {
		this.consultant_externe = consultant_externe;
	}

	public String getFirme_consultant() {
		return firme_consultant;
	}

	public void setFirme_consultant(String firme_consultant) {
		this.firme_consultant = firme_consultant;
	}

	public boolean isConsultant() {
		return consultant;
	}

	public void setConsultant(boolean consultant) {
		this.consultant = consultant;
		this.setChanged();
		this.notifyObservers(REDACTION.MODIF);
	}

	public Employee getEmploye_implique() {
		return employe_implique;
	}

	public void setEmploye_implique(Employee employe_implique) {
		this.employe_implique = employe_implique;
	}

	public Employee getAutre_employe() {
		return autre_employe;
	}

	public void setAutre_employe(Employee autre_employe) {
		this.autre_employe = autre_employe;
		this.setChanged();
		this.notifyObservers(REDACTION.MODIF);
		
	}
	
	

	
	
}