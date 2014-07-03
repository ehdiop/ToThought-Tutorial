package com.xyz.myproject.model;

import java.util.Observable;

import com.xyz.myproject.GUI.controller.MAJProjetCourantController;
import com.xyz.myproject.model.controllers.ModelChangeController;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.ListeEmployee;
import com.xyz.myproject.model.projet.DossierAnnee;
import com.xyz.myproject.model.projet.DossierClient;
import com.xyz.myproject.model.projet.EVENT_DEP;
import com.xyz.myproject.model.projet.ListeProjet;
import com.xyz.myproject.model.projet.Projet;
/**
 * Le modèle utilisé pour la PAC. 
 * @author Raoul
 *
 */
public class Model extends Observable {

	private Client client;
	private Annee annee;
	private Projet projet;
	private ListeProjet projets;
	private DossierAnnee dossierAnnee;

	public enum MODEL {
		CLIENT, ANNEE, PROJET, DOSSIERANNEE
	};

	public Model(Client client, Annee annee, Projet projet) {
		super();
		this.addObserver(new ModelChangeController(this));
		this.setClient(client);
		this.setAnnee(annee);
		this.setProjet(projet);

	}
	
	public Model(Client client){
		this.addObserver(new ModelChangeController(this));
		this.setClient(client);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
		this.setChanged();
		this.notifyObservers(MODEL.CLIENT);
	}

	public Annee getAnnee() {
		return annee;
	}

	public void setAnnee(Annee annee) {
		this.annee = annee;
		this.setChanged();
		this.notifyObservers(MODEL.ANNEE);
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
		
		this.setChanged();
		this.notifyObservers(MODEL.PROJET);
	}

	

	public DossierAnnee getDossierAnnee() {
		return dossierAnnee;
	}

	public void setDossierAnnee(DossierAnnee dossierAnnee) {
		this.dossierAnnee = dossierAnnee;
		this.setChanged();
		this.notifyObservers(MODEL.DOSSIERANNEE);
	}

	public DossierClient getDossierClient() {
		return this.client.getDossierClient();
	}
	
	public ListeProjet getListeProjets(){
		return this.projets;
	}
	
	public void setListeProjets(ListeProjet listeProjet){
		this.projets = listeProjet;
		MAJProjetCourantController controller = new MAJProjetCourantController(
				this, this.getDossierAnnee().getProjets());
		this.getDossierAnnee().getProjets().addObserver(controller);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.CHGT_PROJET);
	}
	
	public ListeEmployee getEmployees(){
		return this.getDossierClient().getEmployes();
	}

}
