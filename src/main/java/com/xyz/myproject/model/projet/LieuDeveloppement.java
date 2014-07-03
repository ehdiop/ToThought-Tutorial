package com.xyz.myproject.model.projet;

import java.util.Observable;


/**
 * Le lieu de développement, une information demandée dans les infos générales du projet.
 */
@javax.persistence.Entity
public class LieuDeveloppement extends Observable implements java.io.Serializable {
	
	public enum LIEUDEV{MODIF};
	/**
	 * @generated
	 */
	private boolean labo;
	/**
	 * @generated
	 */
	private boolean usine_comm;
	/**
	 * @generated
	 */
	private boolean install_dediee;
	
	private boolean autre;
	
	private String valueAutre;
	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1843126281L;
	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	public LieuDeveloppement() {
	}

	

	public boolean isLabo() {
		return labo;
	}



	public void setLabo(boolean labo) {
		this.labo = labo;
	}



	public boolean isUsine_comm() {
		return usine_comm;
	}



	public void setUsine_comm(boolean usine_comm) {
		this.usine_comm = usine_comm;
	}



	public boolean isInstall_dediee() {
		return install_dediee;
	}



	public void setInstall_dediee(boolean install_dediee) {
		this.install_dediee = install_dediee;
	}



	/**
	 * @generated
	 */
	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	public Long getId() {
		return this.id;
	}

	/**
	 * @generated
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	

	public boolean isAutre() {
		return autre;
	}



	public void setAutre(boolean autre) {
		this.autre = autre;
		this.setChanged();
		this.notifyObservers(LIEUDEV.MODIF);
	}
	
	



	public String getValueAutre() {
		return valueAutre;
	}



	public void setValueAutre(String valueAutre) {
		this.valueAutre = valueAutre;
	}



	/**
	 * @generated
	 */
	public String toString() {
		return "LieuDeveloppement" + " labo=" + labo + " usine_comm="
				+ usine_comm + " install_dediee=" + install_dediee + " id="
				+ id;
	}
}