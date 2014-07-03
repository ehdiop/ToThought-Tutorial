package com.xyz.myproject.model.projet;


/**
 * Les objectifs du projet, une information demandée dans les infos du projet.
 */
@javax.persistence.Entity
public class ObjectifProjet implements java.io.Serializable {
	/**
	 * @generated
	 */
	private boolean dev_materiaux;
	/**
	 * @generated
	 */
	private boolean am_materiaux;
	/**
	 * @generated
	 */
	private boolean dev_proc;
	/**
	 * @generated
	 */
	private boolean am_proc;
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1739219518L;
	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	public ObjectifProjet() {
	}

	

	public boolean isDev_materiaux() {
		return dev_materiaux;
	}



	public void setDev_materiaux(boolean dev_materiaux) {
		this.dev_materiaux = dev_materiaux;
	}



	public boolean isAm_materiaux() {
		return am_materiaux;
	}



	public void setAm_materiaux(boolean am_materiaux) {
		this.am_materiaux = am_materiaux;
	}



	public boolean isDev_proc() {
		return dev_proc;
	}



	public void setDev_proc(boolean dev_proc) {
		this.dev_proc = dev_proc;
	}



	public boolean isAm_proc() {
		return am_proc;
	}



	public void setAm_proc(boolean am_proc) {
		this.am_proc = am_proc;
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

	/**
	 * @generated
	 */
	public String toString() {
		return "ObjectifProjet" + " dev_materiaux=" + dev_materiaux
				+ " am_materiaux=" + am_materiaux + " dev_proc=" + dev_proc
				+ " am_proc=" + am_proc + " id=" + id;
	}
}