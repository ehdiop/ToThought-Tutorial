package com.xyz.myproject.model.general;

/**
 * Numéro d'identification Québec. Aucune implémentation. A creuser pour faire
 * comme le numéro d'entreprise (NumeroEntreprise) si intéressant.
 * 
 * @generated
 */
@javax.persistence.Embeddable
public class NEQ implements java.io.Serializable {
	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1041348908L;
	/**
	 * @generated
	 */

	private String neq;

	/**
	 * @generated
	 */
	public NEQ() {
	}

	public NEQ(String neq) {
		super();
		this.neq = neq;
	}

	public String getNeq() {
		return neq;
	}

	public void setNeq(String neq) {
		this.neq = neq;
	}

	/**
	 * @generated
	 */
	public String toString() {
		return this.neq;
	}
}