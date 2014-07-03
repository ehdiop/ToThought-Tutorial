package com.xyz.myproject.model.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.persistence.Transient;

import com.xyz.myproject.model.projet.Employee;


/**
 * Info générales du client. Regroupe l'année, les dépenses générales, la liste des employés.
 */
public class InfoGenerales extends Observable implements java.io.Serializable {
	
	public enum INFOGE{MODIF};
	/**
	 * @generated
	 */
	private List<Employee> employes;
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1218912358L;
	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	private DepensesGenerales depenses;
	
	@Transient
	private Annee annee;
	
	private double salairesNonPayes = 0;

	/**
	 * @generated
	 */
	public InfoGenerales() {
		
		
		this.annee = new Annee();
		this.depenses=new DepensesGenerales(annee);
		this.employes=new ArrayList<Employee>();
	}
	
	public InfoGenerales(Annee annee){
		this(new ArrayList<Employee>(), new DepensesGenerales(annee),annee);
	}
	
	

	public InfoGenerales(List<Employee> employes, DepensesGenerales depenses, Annee annee) {
		super();
		this.employes = employes;
		this.depenses = depenses;
		this.annee = annee;
	}



	/**
	 * @generated
	 */
	public List<Employee> getEmployes() {
		return this.employes;
	}

	/**
	 * @generated
	 */
	public void setEmployes(List<Employee> employes) {
		this.employes = employes;
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
		return "InfoGenerales" + " id=" + id;
	}


	public DepensesGenerales getDepenses() {
		return this.depenses;
	}

	/**
	 * @generated
	 */
	public void setDepenses(DepensesGenerales depenses) {
		this.depenses = depenses;
	}

	public double getSalairesNonPayes() {
		return salairesNonPayes;
	}

	public void setSalairesNonPayes(double salairesNonPayes) {
		this.salairesNonPayes = salairesNonPayes;
		this.setChanged();
		this.notifyObservers(INFOGE.MODIF);
	}
	
	
}