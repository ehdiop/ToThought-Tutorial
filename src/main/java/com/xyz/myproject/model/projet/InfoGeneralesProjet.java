package com.xyz.myproject.model.projet;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.projet.LieuDeveloppement.LIEUDEV;
import com.xyz.myproject.model.projet.PreuvesAppui.PREUVES;
import com.xyz.myproject.model.projet.RenseignementsRedac.REDACTION;
import com.xyz.myproject.model.sectionsBC.DescriptionTechnique;


/**
 * Les informations générales du projet.
 */
@javax.persistence.Entity
public class InfoGeneralesProjet extends Observable implements java.io.Serializable, Observer {
	
	public enum INFOSPROJET{MODIF, BUT_TRAVAUX, DESC_TECH};
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -2107468678L;
	/**
	 * @generated
	 */
	private Long id;
	/**
	 * Le projet a t il déjà fait l'objet d'une première reclamation ?
	 * 
	 * @generated
	 */
	private boolean premiere_reclam;

	/**
	 * @generated
	 */
	private CodeDomaineScience codeDomaineScience;


	/**
	 * @generated
	 */
	private ButTravaux butTravaux;
	
	private DescriptionTechnique descTech;

	/**
	 * @generated
	 */
	private PreuvesAppui preuvesAppui;
	/**
	 * @generated
	 */
	private ObjectifProjet objectifs_projet;
	/**
	 * @generated
	 */
	private LieuDeveloppement lieu_dev;

	private boolean projetConjoint;

	/**
	 * @generated
	 */
	private boolean depenses_etranger;
	/**
	 * @generated
	 */
	private boolean depenses_autre_partie;
	/**
	 * @generated
	 */
	private boolean depenses_pas_employes;

	/**
	 * @generated
	 */
	private RenseignementsRedac redacteurs;
	


	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	public Long getId() {
		return this.id;
	}

	public InfoGeneralesProjet() {
		super();
		this.codeDomaineScience = new CodeDomaineScience();
		this.butTravaux = ButTravaux.DEV_EXP;
		this.setDescTech(DescriptionTechnique.getDescription(butTravaux));
		this.setPreuvesAppui(new PreuvesAppui());
		this.objectifs_projet = new ObjectifProjet();
		this.setLieu_dev(new LieuDeveloppement());
		this.setRedacteurs(new RenseignementsRedac());
	}



	public InfoGeneralesProjet(boolean premiereReclam, CodeDomaineScience code,
			ButTravaux but, PreuvesAppui preuves, ObjectifProjet objectif,
			LieuDeveloppement lieu, boolean projetConjoint2,
			boolean salaireEtranger, boolean autrePartie,
			boolean autreEmployeDepense, RenseignementsRedac rens) {
		this.setPremiere_reclam(premiereReclam);
		this.setCodeDomaineScience(code);
		this.setButTravaux(but);
		this.setPreuvesAppui(preuves);
		this.setObjectifs_projet(objectif);
		this.setLieu_dev(lieu);
		this.setProjetConjoint(projetConjoint2);
		this.setDepenses_etranger(salaireEtranger);
		this.setDepenses_autre_partie(autrePartie);
		this.setDepenses_pas_employes(autreEmployeDepense);
		this.setRedacteurs(rens);
	}

	/**
	 * Permet de réaffecter l'ensemble des champs par copie profonde
	 * @param infos
	 */
	public void setInfoGeneralesProjet(InfoGeneralesProjet infos) {
		this.setPremiere_reclam(infos.isPremiere_reclam());
		this.setCodeDomaineScience(infos.getCodeDomaineScience());
		this.setButTravaux(infos.getButTravaux());
		this.setPreuvesAppui(infos.getPreuvesAppui());
		this.setObjectifs_projet(infos.getObjectifs_projet());
		this.setLieu_dev(infos.getLieu_dev());
		this.setProjetConjoint( infos.isProjetConjoint());
		this.setDepenses_etranger(infos.isDepenses_etranger());
		this.setDepenses_autre_partie(infos.isDepenses_autre_partie());
		this.setDepenses_pas_employes( infos.isDepenses_pas_employes());
		this.setRedacteurs(infos.getRedacteurs());
	}

	/**
	 * @generated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPremiere_reclam() {
		return premiere_reclam;
	}

	public void setPremiere_reclam(boolean premiere_reclam) {
		this.premiere_reclam = premiere_reclam;
	}

	public CodeDomaineScience getCodeDomaineScience() {
		return codeDomaineScience;
	}

	public void setCodeDomaineScience(CodeDomaineScience codeDomaineScience) {
		this.codeDomaineScience = codeDomaineScience;
	}


	public ButTravaux getButTravaux() {
		return butTravaux;
	}

	public void setButTravaux(ButTravaux butTravaux) {
		this.butTravaux = butTravaux;
		this.setChanged();
		this.notifyObservers(INFOSPROJET.BUT_TRAVAUX);
	}

	public PreuvesAppui getPreuvesAppui() {
		return preuvesAppui;
	}

	public void setPreuvesAppui(PreuvesAppui preuvesAppui) {
		this.preuvesAppui = preuvesAppui;
		this.preuvesAppui.addObserver(this);
	}

	public ObjectifProjet getObjectifs_projet() {
		return objectifs_projet;
	}

	public void setObjectifs_projet(ObjectifProjet objectifs_projet) {
		this.objectifs_projet = objectifs_projet;
	}

	public LieuDeveloppement getLieu_dev() {
		return lieu_dev;
	}

	public void setLieu_dev(LieuDeveloppement lieu_dev) {
		
		this.lieu_dev = lieu_dev;
		this.lieu_dev.addObserver(this);
		
		this.setChanged();
		this.notifyObservers(INFOSPROJET.MODIF);
		
	}

	public boolean isDepenses_etranger() {
		return depenses_etranger;
	}

	public void setDepenses_etranger(boolean depenses_etranger) {
		this.depenses_etranger = depenses_etranger;
		this.setChanged();
		this.notifyObservers(INFOSPROJET.MODIF);
	}

	public boolean isDepenses_autre_partie() {
		return depenses_autre_partie;
	}

	public void setDepenses_autre_partie(boolean depenses_autre_partie) {
		this.depenses_autre_partie = depenses_autre_partie;
		this.setChanged();
		this.notifyObservers(INFOSPROJET.MODIF);
	}

	public boolean isDepenses_pas_employes() {
		return depenses_pas_employes;
	}

	public void setDepenses_pas_employes(boolean depenses_pas_employes) {
		this.depenses_pas_employes = depenses_pas_employes;
		this.setChanged();
		this.notifyObservers(INFOSPROJET.MODIF);
	}

	public RenseignementsRedac getRedacteurs() {
		return redacteurs;
	}

	public void setRedacteurs(RenseignementsRedac redacteurs) {
		this.redacteurs = redacteurs;
		this.redacteurs.addObserver(this);
		
		this.setChanged();
		this.notifyObservers(INFOSPROJET.MODIF);
	}

	public boolean isProjetConjoint() {
		return projetConjoint;
	}

	public void setProjetConjoint(boolean projetConjoint) {
		this.projetConjoint = projetConjoint;
	}
	
	

	public DescriptionTechnique getDescTech() {
		return descTech;
	}

	public void setDescTech(DescriptionTechnique descTech) {
		this.descTech = descTech;
		this.setChanged();
		this.notifyObservers(INFOSPROJET.DESC_TECH);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1==LIEUDEV.MODIF || arg1==REDACTION.MODIF || arg1 == PREUVES.MODIF){
			this.setChanged();
			this.notifyObservers(INFOSPROJET.MODIF);
		}
	}
	
	
	
	

}