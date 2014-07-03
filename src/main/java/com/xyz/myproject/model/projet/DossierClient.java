package com.xyz.myproject.model.projet;

import java.util.HashMap;
import java.util.Observable;

import com.xyz.myproject.model.controllers.EmployeeLigneTableauController;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.ListeAnnee;
import com.xyz.myproject.model.general.ListeEmployee;
import com.xyz.myproject.model.general.ListeEmployee.EMPLOYEE;
import com.xyz.myproject.model.general.ListeST;
import com.xyz.myproject.model.general.MapLigneMRVR;

/**
 * Le dossier client représente les informations qui sont relatives au client, et donc indépendantes 
 * de l'année et du projet.
 */
@javax.persistence.Entity
public class DossierClient extends Observable implements java.io.Serializable  {
	
	public enum DOSSIERCLIENT{ANNEE}
	/**
	 * @generated
	 */
	private HashMap<Annee, DossierAnnee> dossiersAnnee;
	/**
	 * @generated
	 */
	private static final long serialVersionUID = 146464252L;
	/**
	 * @generated
	 */
	private Long id;

	private ListeEmployee employes;

	private ListeST sousTraitants;

	/**
	 * @generated
	 */
	public DossierClient() {
		this(new HashMap<Annee, DossierAnnee>());
	}

	public DossierClient(HashMap<Annee, DossierAnnee> dossiersAnnee) {
		super();
		this.dossiersAnnee = dossiersAnnee;
		this.employes = new ListeEmployee();
		this.sousTraitants=new ListeST();
	}

	public ListeAnnee getAnnees() {
		ListeAnnee annees = new ListeAnnee(this.getDossiersAnnee()
				.keySet());
		return annees;
	}

	public void addDossierAnnee(DossierAnnee dossierAnnee) {
		this.dossiersAnnee.put(dossierAnnee.getAnnee(), dossierAnnee);
		DossierAnnee leDossier = this.dossiersAnnee.get(dossierAnnee.getAnnee());
		try{
			MapLigneMRVR depensesCa = leDossier.getInfos().getDepenses().getDepensesIndivSalaireCa();
			MapLigneMRVR depensesEtr = leDossier.getInfos().getDepenses().getDepensesIndivSalaireEtr();
			EmployeeLigneTableauController controller = new EmployeeLigneTableauController(
					 depensesCa, depensesEtr, this.getEmployes(),leDossier.getAnnee());
			this.getEmployes().addObserver(controller);
			this.getEmployes().setChanged();
			this.getEmployes().notifyObservers(EMPLOYEE.ADD);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		this.setChanged();
		this.notifyObservers(DOSSIERCLIENT.ANNEE);
		
	}

	public void removeDossierAnnee(DossierAnnee dossierAnnee) {
		this.dossiersAnnee.remove(dossierAnnee);
	}

	public DossierAnnee getDossierAnnee(Annee annee) {
		return this.getDossiersAnnee().get(annee);
	}

	public HashMap<Annee, DossierAnnee> getDossiersAnnee() {
		return dossiersAnnee;
	}

	public void setDossiersAnnee(HashMap<Annee, DossierAnnee> dossiersAnnee) {
		this.dossiersAnnee = dossiersAnnee;
	}

	public ListeEmployee getEmployes() {
		return employes;
	}

	public void setEmployes(ListeEmployee employes) {
		this.employes = employes;
	}

	public ListeST getSousTraitants() {
		return sousTraitants;
	}

	public void setSousTraitants(ListeST sousTraitants) {
		this.sousTraitants = sousTraitants;
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
		return "DossierClient" + " id=" + id;
	}
}