package com.xyz.myproject.model.projet;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.xyz.myproject.model.exceptions.EmailException;
import com.xyz.myproject.model.general.FonctionEnum;

/**
 * Un employé
 */
@javax.persistence.Entity
public class Employee implements java.io.Serializable {
	
	/**
	 * @generated
	 */
	@Column(name="employe_nom")
	private String nom;
	/**
	 * @generated
	 */
	@Column(name="employe_prenom")
	private String prenom;
	/**
	 * @generated
	 */
	private FonctionEnum fonction;
	
	@Column(name="employe_qualification")
	private String qualification;
	/**
	 * @generated
	 */
	@Column(name="employe_determine")
	private boolean determine;
	/**
	 * @generated
	 */
	@Column(name="employe_email")
	private Email email;
	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1717520232L;
	/**
	 * @generated
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="employe_id")
	private UUID id;

	/**
	 * @generated
	 */
	public Employee() {
	}

	public Employee(String nom, String prenom, FonctionEnum fonction,
			String qualification, boolean determine, Email email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.qualification = qualification;
		this.determine = determine;
		this.email = email;
		this.id=UUID.randomUUID();
	}
	
	

	public Employee(String nom, String prenom, FonctionEnum fonction,
			String qualification, boolean determine, String email) throws EmailException {
		this(nom,prenom,fonction,qualification,determine,new Email(email));
	}

	/**
	 * Copie profonde d'un employé
	 * @param e
	 */
	public void setEmployee(Employee e){
		this.setDetermine(e.isDetermine());
		this.setEmail(e.getEmail());
		this.setNom(e.getNom());
		this.setPrenom(e.getPrenom());
		this.setQualification(e.getQualification());
		this.setFonction(e.getFonction());
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public FonctionEnum getFonction() {
		return fonction;
	}

	public void setFonction(FonctionEnum fonction) {
		this.fonction = fonction;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public boolean isDetermine() {
		return determine;
	}

	public void setDetermine(boolean determine) {
		this.determine = determine;
	}

	/**
	 * @generated
	 */
	@javax.persistence.Embedded
	public Email getEmail() {
		return this.email;
	}

	/**
	 * @generated
	 */
	public void setEmail(Email email) {
		this.email = email;
	}

	/**
	 * @generated
	 */
	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@Column(name="employe_id")
	public UUID getId() {
		return this.id;
	}

	/**
	 * @generated
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String toString() {
		return this.prenom + " " + this.nom;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Employee) && this.getId().equals(((Employee)obj).getId());
	}
	
	@Override
	public int hashCode() {
		return this.getId().toString().hashCode();
	}
}