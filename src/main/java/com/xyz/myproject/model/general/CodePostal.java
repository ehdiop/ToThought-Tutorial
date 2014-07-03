package com.xyz.myproject.model.general;
/**
 * Modélisation d'un code postal, à compléter si intéressant.
 * @author Raoul
 *
 */
@javax.persistence.Embeddable
public class CodePostal implements java.io.Serializable {

	/**
	 * @generated
	 */
	private static final long serialVersionUID = -2006723258L;
	
	
	private String cp_value;

	/**
	 * @generated
	 */
	public CodePostal() {
	}
	
	

	public CodePostal(String cp_value) {
		super();
		this.cp_value = cp_value;
	}
	
	




	public String getCp_value() {
		return cp_value;
	}



	public void setCp_value(String cp_value) {
		this.cp_value = cp_value;
	}



	/**
	 * @generated
	 */
	public String toString() {
		return this.cp_value;
	}

}
