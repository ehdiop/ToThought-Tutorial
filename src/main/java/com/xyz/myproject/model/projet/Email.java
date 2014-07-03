package com.xyz.myproject.model.projet;


import com.xyz.myproject.model.exceptions.EmailException;

/**
 * Représentation d'un email avec vérification de la cohérence.
 */
@javax.persistence.Embeddable
public class Email implements java.io.Serializable {
	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1892562210L;
	/**
	 * @generated
	 */

	private String email;
	private org.apache.commons.validator.routines.EmailValidator emailValidator = org.apache.commons.validator.routines.EmailValidator
			.getInstance();

	public Email(){
		this.email="";
	}

	/**
	 * @throws EmailException
	 * @generated
	 */
	public Email(String email) throws EmailException {
		this.email = email;
		if (!emailValidator.isValid(email)) {
			if (!email.equals("")) {
				throw new EmailException();
			}
		}

	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @generated
	 */
	public String toString() {
		return this.email;
	}

	/**
	 * @generated
	 */

}