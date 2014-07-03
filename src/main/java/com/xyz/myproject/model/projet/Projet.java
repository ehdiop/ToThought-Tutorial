package com.xyz.myproject.model.projet;

import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Vector;

import javax.persistence.Transient;

import com.xyz.myproject.model.controllers.InitiateDescriptionProjetController;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.EmployesImpliques;
import com.xyz.myproject.model.general.ListeEmployee;
import com.xyz.myproject.model.sectionsBC.DescriptionTechnique;

/**
 * Représentation d'un projet.
 */
public class Projet extends Observable implements java.io.Serializable {

	public enum PROJET {
		DESC
	};

	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1140157434L;
	/**
	 * @generated
	 */
	private Long id;
	/**
	 * @generated
	 */
	private InfoGeneralesProjet informationsGenerales;
	/**
	 * @generated
	 */
	private EmployesImpliques employesImp;
	/**
	 * @generated
	 */
	private ListeEmployee employesProjet;
	/**
	 * @generated
	 */
	private String nomProjet;
	/**
	 * @generated
	 */
	private String responsable;
	/**
	 * @generated
	 */
	private GregorianCalendar debut;
	/**
	 * @generated
	 */
	private GregorianCalendar fin;

	private DepensesProjet depenses;

	private DescriptionTechnique description;

	@Transient
	private Annee annee;

	private int numero;

	public Projet() {

	}

	public Projet(InfoGeneralesProjet informationsGenerales,
			EmployesImpliques employesImp, ListeEmployee employesProjet,
			String nomProjet, String responsable, GregorianCalendar debut,
			GregorianCalendar fin, DepensesProjet depenses, Annee annee,
			int numero) {
		super();
		this.setInformationsGenerales(informationsGenerales);
		this.employesImp = employesImp;
		this.employesProjet = employesProjet;
		this.nomProjet = nomProjet;
		this.responsable = responsable;
		this.debut = debut;
		this.fin = fin;
		this.depenses = depenses;
		this.annee = annee;
		this.numero = numero;

	}

	public Projet(String nomProjet, Annee annee, ListeEmployee employes) {
		this(new InfoGeneralesProjet(), new EmployesImpliques(), employes,
				nomProjet, null, null, null, new DepensesProjet(annee), annee,
				0);
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
	public InfoGeneralesProjet getInformationsGenerales() {
		return this.informationsGenerales;
	}

	/**
	 * @generated
	 */
	public void setInformationsGenerales(
			InfoGeneralesProjet informationsGenerales) {
		this.informationsGenerales = informationsGenerales;
		InitiateDescriptionProjetController controller = new InitiateDescriptionProjetController(
				this);
		this.informationsGenerales.addObserver(controller);
	}

	/**
	 * @generated
	 */
	public String toString() {
		return nomProjet;
	}

	/**
	 * @generated
	 */
	public EmployesImpliques getEmployesImp() {
		return this.employesImp;
	}

	/**
	 * @generated
	 */
	public void setEmployesImp(EmployesImpliques employesImp) {
		this.employesImp = employesImp;
	}

	public ListeEmployee getEmployesProjet() {
		return employesProjet;
	}

	public void setEmployesProjet(ListeEmployee employesProjet) {
		this.employesProjet = employesProjet;
	}

	/**
	 * @generated
	 */
	public String getNomProjet() {
		return this.nomProjet;
	}

	/**
	 * @generated
	 */
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	/**
	 * @generated
	 */
	public String getResponsable() {
		return this.responsable;
	}

	/**
	 * @generated
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	/**
	 * @generated
	 */
	public GregorianCalendar getDebut() {
		return this.debut;
	}

	/**
	 * @generated
	 */
	public void setDebut(GregorianCalendar debut) {
		this.debut = debut;
	}

	/**
	 * @generated
	 */
	public GregorianCalendar getFin() {
		return this.fin;
	}

	/**
	 * @generated
	 */
	public void setFin(GregorianCalendar fin) {
		this.fin = fin;
	}

	public DepensesProjet getDepenses() {
		return depenses;
	}

	public void setDepenses(DepensesProjet depenses) {
		this.depenses = depenses;
	}

	public Annee getAnnee() {
		return annee;
	}

	public void setAnnee(Annee annee) {
		this.annee = annee;
	}

	public DescriptionTechnique getDescription() {
		return description;
	}

	public void setDescription(DescriptionTechnique description) {
		this.description = description;
		this.setChanged();
		this.notifyObservers(PROJET.DESC);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Vector<Employee> getEmployesNonImpliques() {
		Vector<Employee> toRet = new Vector<Employee>(this.getEmployesProjet()
				.getList());
		for (Employee employeImp : this.getEmployesImp().getList()) {
			toRet.remove(employeImp);
		}
		return toRet;
	}

}