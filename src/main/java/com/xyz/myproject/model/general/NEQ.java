package com.xyz.myproject.model.general;

/**
 * Num�ro d'identification Qu�bec. Aucune impl�mentation. A creuser pour faire
 * comme le num�ro d'entreprise (NumeroEntreprise) si int�ressant.
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