package com.xyz.myproject.model.general;


/**
 * Numéro d'identification provincial
 * @generated
 */
@javax.persistence.Embeddable
public class NumeroIdProv implements java.io.Serializable {
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -357941490L;
	
	private String numProv;

	/**
	 * @generated
	 */
	public NumeroIdProv() {
	}

	public NumeroIdProv(String numProv) {
		super();
		this.numProv = numProv;
	}	
	
	

	public String getNumProv() {
		return numProv;
	}

	public void setNumProv(String numProv) {
		this.numProv = numProv;
	}

	/**
	 * @generated
	 */
	public String toString() {
		return this.numProv;
	}


}