package com.xyz.myproject.model.general;
/**
 * Modélisation des dépenses. Etendu par DepensesGenerales et DepensesProjet
 */

import java.util.Observable;

import com.xyz.myproject.model.projet.Equipement50;
import com.xyz.myproject.model.projet.Equipement90;
import com.xyz.myproject.model.projet.Location50;
import com.xyz.myproject.model.projet.Location90;
import com.xyz.myproject.model.projet.MaterielConsomme;
import com.xyz.myproject.model.projet.MaterielTransforme;

public abstract class Depense extends Observable{

	protected Annee annee;

	protected Equipement50 eqt_50;

	protected MaterielConsomme mat_conso;

	protected MaterielTransforme mat_transf;

	protected Equipement90 eqt_90;
	
	protected Location50 location50;
	
	protected Location90 location90;



	protected Depense(Annee annee, Equipement50 eqt_50,
			MaterielConsomme mat_conso, MaterielTransforme mat_transf,
			Equipement90 eqt_90, Location50 loc50, Location90 loc90) {
		super();
		this.annee = annee;

		// Dans le cas de la méthode traditionnelle, les dépenses de location
		// d'équipement utilisé entre 50 et 90 % du temps à
		// la RSDE sont mises à 0.
		this.eqt_50 = eqt_50;

		if (annee.getMethod() == MethodeCalcul.TRADITIONNELLE) {
			eqt_50.setMontant(0);
		}
		this.mat_conso = mat_conso;
		this.mat_transf = mat_transf;
		this.eqt_90 = eqt_90;
		this.location50 = loc50;
		this.location90=loc90;

	}

	protected Depense(Annee annee) {
		this(annee, new Equipement50(), new MaterielConsomme(),
				new MaterielTransforme(), new Equipement90(), new Location50(), new Location90());
	}

	public Annee getAnnee() {
		return annee;
	}

	public void setAnnee(Annee annee) {
		this.annee = annee;
	}

	public Equipement50 getEqt_50() {
		return eqt_50;
	}

	public void setEqt_50(Equipement50 eqt_50) {
		this.eqt_50 = eqt_50;
	}

	public MaterielConsomme getMat_conso() {
		return mat_conso;
	}

	public void setMat_conso(MaterielConsomme mat_conso) {
		this.mat_conso = mat_conso;
	}

	public MaterielTransforme getMat_transf() {
		return mat_transf;
	}

	public void setMat_transf(MaterielTransforme mat_transf) {
		this.mat_transf = mat_transf;
	}

	public Equipement90 getEqt_90() {
		return eqt_90;
	}

	public void setEqt_90(Equipement90 eqt_90) {
		this.eqt_90 = eqt_90;
	}

	public Location50 getLocation50() {
		return location50;
	}

	public void setLocation50(Location50 location50) {
		this.location50 = location50;
	}

	public Location90 getLocation90() {
		return location90;
	}

	public void setLocation90(Location90 location90) {
		this.location90 = location90;
	}
	
	public void setLocation90(double loc90){
		this.location90.setMontant(loc90);
	}
	
	public void setLocation50(double loc50){
		this.location50.setMontant(loc50);
	}


	
	
	
	

}
