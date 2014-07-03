package com.xyz.myproject.model.projet;

import javax.persistence.Transient;

import com.xyz.myproject.model.controllers.DepensesController;
import com.xyz.myproject.model.controllers.MAJ_RD1029.MAJ_RD1029_Partie2Ctrl;
import com.xyz.myproject.model.controllers.MAJ_RD1029.MAJ_RD1029_SalairesCtrl;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.InfoGenerales;
import com.xyz.myproject.model.general.RD1029;
import com.xyz.myproject.model.general.T661;

/**
 * Cette classe contient les informations relatives à une demande de crédit
 * d'impôt RSDE. La classe agrège donc les informations relatives à l'année
 * financière, les informations générales du dossier et les infor- mations
 * relatives à chaque projet.
 */
public class DossierAnnee implements java.io.Serializable {

	@Transient
	private Annee annee;
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1659626000L;
	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	private ListeProjet projets;

	/**
	 * @generated
	 */
	private InfoGenerales infos;

	private DepensesController depensesController;

	private T661 t661;

	private RD1029 rd1029;

	public DossierAnnee() {

		this(null, new ListeProjet(), null);

	}

	public DossierAnnee(Annee annee) {
		this(annee, new ListeProjet(), new InfoGenerales(annee));
	}

	public DossierAnnee(Annee annee, ListeProjet projets, InfoGenerales infos) {
		super();
		this.annee = annee;
		this.projets = projets;
		this.infos = infos;
		this.t661 = new T661();
		this.rd1029 = new RD1029();
		MAJ_RD1029_SalairesCtrl rd1029SalairesCtrl = new MAJ_RD1029_SalairesCtrl(this);
		MAJ_RD1029_Partie2Ctrl rd1029_Partie2Ctrl = new MAJ_RD1029_Partie2Ctrl(this.getInfos().getDepenses(), this.getRd1029().getPartie2());
		this.infos.getDepenses().gettSCanada().addObserver(rd1029SalairesCtrl);
		this.infos.getDepenses().getTraitementEtr().addObserver(rd1029SalairesCtrl);
		this.infos.getDepenses().getSout_rd().addObserver(rd1029SalairesCtrl);
		this.infos.getDepenses().getSout_soutien().addObserver(rd1029SalairesCtrl);
		this.infos.getDepenses().getSout_rd().addObserver(rd1029_Partie2Ctrl);
		this.infos.getDepenses().getSout_soutien().addObserver(rd1029_Partie2Ctrl);
		this.depensesController = new DepensesController(infos.getDepenses(),
				this.projets);
		this.projets.addObserver(depensesController);
		for (int i = 0; i < this.projets.size(); i++) {
			this.projets.get(i).getDepenses().addObserver(depensesController);
		}

		this.projets.setChanged();
		this.projets.notifyObservers();
	}

	public void addProjet(Projet projet) {
		projet.getDepenses().addObserver(depensesController);
		this.projets.add(projet);
	}

	public void deleteProjet(Projet projet) {
		this.projets.remove(projet);
	}

	public Annee getAnnee() {
		return annee;
	}

	public void setAnnee(Annee annee) {
		this.annee = annee;
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
		return "DossierAnnee " + this.getAnnee();
	}

	public ListeProjet getProjets() {
		return projets;
	}

	public void setProjets(ListeProjet projets) {
		this.projets = projets;
	}

	public InfoGenerales getInfos() {
		return infos;
	}

	public void setInfos(InfoGenerales infos) {
		this.infos = infos;
	}

	public T661 getT661() {
		return t661;
	}

	public RD1029 getRd1029() {
		return rd1029;
	}

}