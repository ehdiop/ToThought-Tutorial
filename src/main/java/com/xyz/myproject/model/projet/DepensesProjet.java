package com.xyz.myproject.model.projet;

import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.Depense;


/**
 * Représente les dépenses d'un projet
 * @author Raoul
 *
 */
public  class DepensesProjet extends Depense {
	
	public enum DEP_PROJET{MODIF};
	
	protected TSProjetCanada tsProjetCa;
	protected TSProjetEtr tsProjetEtr;
	protected DepensesSousTraitance<DepenseST_RD> sout_rd;
	protected DepensesSousTraitance<DepenseST_Soutien> sout_soutien;

	public DepensesProjet(Annee annee, Equipement50 eqt_50,
			MaterielConsomme mat_conso, MaterielTransforme mat_transf,
			Equipement90 eqt_90, TSProjetCanada tsCa, TSProjetEtr tsEtr,
			DepensesSousTraitance<DepenseST_RD> sout_rd, DepensesSousTraitance<DepenseST_Soutien> sout_soutien, Location50 loc50, Location90 loc90) {
		super(annee, eqt_50, mat_conso, mat_transf, eqt_90, loc50, loc90);
		this.tsProjetCa = tsCa;
		this.tsProjetEtr = tsEtr;
		this.sout_rd = sout_rd;
		this.sout_soutien = sout_soutien;
	}

	public DepensesProjet(Annee annee) {
		super(annee);
		this.tsProjetCa = new TSProjetCanada();
		this.tsProjetEtr = new TSProjetEtr();
		this.sout_rd = new DepensesSousTraitance<DepenseST_RD>();
		this.sout_soutien = new DepensesSousTraitance<DepenseST_Soutien>();
	}

	public TSProjetCanada getTsProjetCa() {
		return tsProjetCa;
	}

	public void setTsProjetCa(TSProjetCanada tsProjetCa) {
		this.tsProjetCa = tsProjetCa;
	}

	public TSProjetEtr getTsProjetEtr() {
		return tsProjetEtr;
	}

	public void setTsProjetEtr(TSProjetEtr tsProjetEtr) {
		this.tsProjetEtr = tsProjetEtr;
	}
	
	public void setMoDetermineeEtr(double mo_determinee){
		this.getTsProjetEtr().setMo_determinee(mo_determinee);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.ST_ETR_DET);
		this.setChanged();
		this.notifyObservers(DEP_PROJET.MODIF);
	}
	
	public void setMoNonDetermineeEtr(double mo_non_determinee){
		this.getTsProjetEtr().setMo_non_determinee(mo_non_determinee);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.ST_ETR_NON_DET);
		this.setChanged();
		this.notifyObservers(DEP_PROJET.MODIF);
	}
	
	public void setMoDetermineeCa(double mo_determinee){
		this.getTsProjetCa().setMo_determinee(mo_determinee);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.ST_CA_DET);
		this.setChanged();
		this.notifyObservers(DEP_PROJET.MODIF);
	}
	
	public void setMoNonDetermineeCa(double mo_non_determinee){
		this.getTsProjetCa().setMo_non_determinee(mo_non_determinee);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.ST_CA_NON_DET);
		this.setChanged();
		this.notifyObservers(DEP_PROJET.MODIF);
	}
	
	
	public void setMoSoutien(double mo_soutien){
		this.getTsProjetCa().setMo_soutien(mo_soutien);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.MO_SOUT);
		this.setChanged();
		this.notifyObservers(DEP_PROJET.MODIF);
	}
	
	public void setEqt50(double eqt_50){
		this.getEqt_50().setMontant(eqt_50);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.EQ_50);
	}

	public void setEqt90(double eqt_90){
		this.getEqt_90().setMontant(eqt_90);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.EQ_90);
	}
	
	public void addSoutSoutien(DepenseST_Soutien dep_st_soutien){
		this.sout_soutien.add(dep_st_soutien);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.ST_SOUT);
	}
	
	public void addSoutRSDE(DepenseST_RD dep_st_rd){
		this.sout_rd.add(dep_st_rd);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.ST_RSDE);
	}
	
	public void setMat_conso(double materiauxConsommes){
		this.mat_conso.setMontant(materiauxConsommes);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.MAT_CONSO);
	}
	
	public void setMat_transf(double materiauxTransformes){
		this.mat_transf.setMontant(materiauxTransformes);
		this.setChanged();
		this.notifyObservers(EVENT_DEP.MAT_TRANSF);
	}

	public DepensesSousTraitance<DepenseST_RD> getSout_rd() {
		return sout_rd;
	}
	
	public double getSous_rd_montant(){
		
		return this.getSout_rd().total();
	}

	public void setSout_rd(DepensesSousTraitance<DepenseST_RD> sout_rd) {
		this.sout_rd = sout_rd;
	}

	public DepensesSousTraitance<DepenseST_Soutien> getSout_soutien() {
		return sout_soutien;
	}
	
	public double getSout_soutien_montant(){
		
		return sout_soutien.total();
	}

	public void setSout_soutien(DepensesSousTraitance<DepenseST_Soutien> sout_soutien) {
		this.sout_soutien = sout_soutien;
	}
	

	
}
