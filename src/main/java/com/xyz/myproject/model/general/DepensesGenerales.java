package com.xyz.myproject.model.general;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

import com.xyz.myproject.model.controllers.MAJValeurMRVRController;
import com.xyz.myproject.model.projet.Employee;
import com.xyz.myproject.model.projet.Equipement50;
import com.xyz.myproject.model.projet.Equipement90;
import com.xyz.myproject.model.projet.FraisGeneraux;
import com.xyz.myproject.model.projet.FraisGenerauxTrad;
import com.xyz.myproject.model.projet.Location50;
import com.xyz.myproject.model.projet.Location90;
import com.xyz.myproject.model.projet.MaterielConsomme;
import com.xyz.myproject.model.projet.MaterielTransforme;

/**
 * Classe représentant les dépenses pour l'ensemble d'un dossier (ensemble des
 * projets d'une année fiscale)
 * 
 * @author Raoul
 * 
 */

public class DepensesGenerales extends Depense implements java.io.Serializable {

	@Transient
	protected FraisGeneraux fraisGeneraux;

	/**
	 * @generated
	 */
	protected static final long serialVersionUID = -1462499305L;
	/**
	 * @generated
	 */
	protected Long id;

	protected TSGeneralEtr traitementEtr;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "boni", column = @Column(name = "boni")),
			@AttributeOverride(name = "mo_determinee", column = @Column(name = "mo_determinee_ca")),
			@AttributeOverride(name = "mo_non_determinee", column = @Column(name = "mo_non_determinee_ca")),
			@AttributeOverride(name = "mo_soutien", column = @Column(name = "mo_soutien"))

	})
	protected TSGeneralCanada tSCanada;

	protected SousTraitanceRD sout_rd;

	protected SousTraitanceSoutien sout_soutien;

	/**
	 * Mappe un employé déterminé ayant exercé des activités de RSDE au Canada
	 * avec les informations de salaires nécessaires au calcul du MRVR
	 */
	protected MapLigneMRVR depensesIndivSalaireCa;

	/**
	 * Mappe un employé déterminé ayant exercé des activités de RSDE à
	 * l'étranger avec les informations de salaires nécessaires au calcul du
	 * MRVR
	 */
	protected MapLigneMRVR depensesIndivSalaireEtr;

	/**
	 * @generated
	 */
	protected DepensesGenerales() {
		this(new Annee());
	}

	public DepensesGenerales(Equipement50 eqt_50, MaterielConsomme mat_conso,
			MaterielTransforme mat_transf, Equipement90 eqt_90,
			FraisGeneraux fraisGeneraux, TSGeneralEtr traitementEtr,
			TSGeneralCanada tSCanada, Annee annee, SousTraitanceRD sout_rd,
			SousTraitanceSoutien sout_soutien, Location50 loc50,
			Location90 loc90) {
		super(annee, eqt_50, mat_conso, mat_transf, eqt_90, loc50, loc90);

		this.fraisGeneraux = fraisGeneraux;
		this.traitementEtr = traitementEtr;
		this.tSCanada = tSCanada;
		this.sout_rd = sout_rd;
		this.sout_soutien = sout_soutien;
		//----------------------------------------------------------------
		// AJOUT
		this.depensesIndivSalaireCa = new MapLigneMRVR();
		this.depensesIndivSalaireEtr = new MapLigneMRVR();
		//----------------------------------------------------------------
	}

	public DepensesGenerales(Annee annee) {

		this(new Equipement50(), new MaterielConsomme(),
				new MaterielTransforme(), new Equipement90(), (annee
						.getMethod() == MethodeCalcul.REMPLACEMENT) ? new MRVR(
						annee) : new FraisGenerauxTrad(), null, null, annee,
				new SousTraitanceRD(), new SousTraitanceSoutien(),
				new Location50(), new Location90());
		TSGeneralCanada tsGeneralCa = new TSGeneralCanada();
		TSGeneralEtr tsGeneralEtr = new TSGeneralEtr();
		this.settSCanada(tsGeneralCa);
		this.setTraitementEtr(tsGeneralEtr);
		this.depensesIndivSalaireCa = new MapLigneMRVR();
		this.depensesIndivSalaireEtr = new MapLigneMRVR();

		// Dans le cas de la méthode de remplacement, on instancie les valeurs
		// du MRVR
		if (annee.getMethod() == MethodeCalcul.REMPLACEMENT) {
			((MRVR) this.getFraisGeneraux()).setTraitementCanada(tsGeneralCa);
			((MRVR) this.getFraisGeneraux()).setTraitementEtr(tsGeneralEtr);
			((MRVR) this.getFraisGeneraux())
					.setLignesTableauCa(this.depensesIndivSalaireCa);
			((MRVR) this.getFraisGeneraux())
					.setLignesTableauEtr(this.depensesIndivSalaireEtr);
			MAJValeurMRVRController controllerMAJMRVR=new MAJValeurMRVRController((MRVR)this.getFraisGeneraux());
			this.depensesIndivSalaireCa.addObserver(controllerMAJMRVR);
			this.depensesIndivSalaireEtr.addObserver(controllerMAJMRVR);

		}

	}

	/**
	 * @generated
	 */
	public String toString() {
		return "Depenses" + " id=" + id + (char) 10
				+ " Main d'oeuvre non determinee au canada=" + (char) 10
				+ " Main d'oeuvre non determinee etranger=" + (char) 10
				+ "frais generaux=" + this.fraisGeneraux;
	}

	public FraisGeneraux getFraisGeneraux() {
		return this.fraisGeneraux;
	}

	/**
	 * @generated
	 */
	protected void setFraisGeneraux(FraisGeneraux fraisGeneraux) {
		this.fraisGeneraux = fraisGeneraux;
	}

	/**
	 * @generated
	 */
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dep_id")
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
	public TSGeneralEtr getTraitementEtr() {
		return this.traitementEtr;
	}

	/**
	 * @generated
	 */
	public void setTraitementEtr(TSGeneralEtr traitementEtr) {
		this.traitementEtr = traitementEtr;
	}

	public TSGeneralCanada gettSCanada() {
		return tSCanada;
	}

	public void settSCanada(TSGeneralCanada tSCanada) {
		this.tSCanada = tSCanada;
	}

	public SousTraitanceRD getSout_rd() {
		return sout_rd;
	}

	public void setSout_rd(SousTraitanceRD sout_rd) {
		this.sout_rd = sout_rd;
	}

	public SousTraitanceSoutien getSout_soutien() {
		return sout_soutien;
	}

	public void setSout_soutien(SousTraitanceSoutien sout_soutien) {
		this.sout_soutien = sout_soutien;
	}

	public MapLigneMRVR getDepensesIndivSalaireCa() {
		return depensesIndivSalaireCa;
	}

	public MapLigneMRVR getDepensesIndivSalaireEtr() {
		return depensesIndivSalaireEtr;
	}

	public void addDepenseSalaireIndivCa(Employee e, MRVR.LigneTableau ligne) {
		this.depensesIndivSalaireCa.put(e, ligne);
	}

	public void addDepenseSalaireIndivEtr(Employee e, MRVR.LigneTableau ligne) {

		this.depensesIndivSalaireEtr.put(e, ligne);
	}

	public static void main(String[] args) {

	}

}