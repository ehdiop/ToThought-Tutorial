package com.xyz.myproject.model.general;
/**
 * Modélisation de la partie 3 du T661
 * @author Raoul
 *
 */
public class T661Partie3 {

	private int QCCredit, ontaInnov, ontaParrain, ontaRSDE, colomb, alberta,
			autresAidProv, aidGouvProv, autreTypeGouv, nonGouv, CIIPasse,
			ventes, deducDemandee;

	public T661Partie3(int qCCredit, int ontaInnov, int ontaParrain,
			int ontaRSDE, int colomb, int alberta, int autresAidProv,
			int aidGouvProv, int autreTypeGouv, int nonGouv, int cIIPasse,
			int ventes, int deducDemandee) {
		super();
		this.QCCredit = qCCredit;
		this.ontaInnov = ontaInnov;
		this.ontaParrain = ontaParrain;
		this.ontaRSDE = ontaRSDE;
		this.colomb = colomb;
		this.alberta = alberta;
		this.autresAidProv = autresAidProv;
		this.aidGouvProv = aidGouvProv;
		this.autreTypeGouv = autreTypeGouv;
		this.nonGouv = nonGouv;
		this.CIIPasse = cIIPasse;
		this.ventes = ventes;
		this.deducDemandee = deducDemandee;
	}
	
	public T661Partie3(){
		
	}

	public int getQCCredit() {
		return QCCredit;
	}

	public void setQCCredit(int qCCredit) {
		QCCredit = qCCredit;
	}

	public int getOntaInnov() {
		return ontaInnov;
	}

	public void setOntaInnov(int ontaInnov) {
		this.ontaInnov = ontaInnov;
	}

	public int getOntaParrain() {
		return ontaParrain;
	}

	public void setOntaParrain(int ontaParrain) {
		this.ontaParrain = ontaParrain;
	}

	public int getOntaRSDE() {
		return ontaRSDE;
	}

	public void setOntaRSDE(int ontaRSDE) {
		this.ontaRSDE = ontaRSDE;
	}

	public int getColomb() {
		return colomb;
	}

	public void setColomb(int colomb) {
		this.colomb = colomb;
	}

	public int getAlberta() {
		return alberta;
	}

	public void setAlberta(int alberta) {
		this.alberta = alberta;
	}

	public int getAutresAidProv() {
		return autresAidProv;
	}

	public void setAutresAidProv(int autresAidProv) {
		this.autresAidProv = autresAidProv;
	}

	public int getAidGouvProv() {
		return aidGouvProv;
	}

	public void setAidGouvProv(int aidGouvProv) {
		this.aidGouvProv = aidGouvProv;
	}

	public int getAutreTypeGouv() {
		return autreTypeGouv;
	}

	public void setAutreTypeGouv(int autreTypeGouv) {
		this.autreTypeGouv = autreTypeGouv;
	}

	public int getNonGouv() {
		return nonGouv;
	}

	public void setNonGouv(int nonGouv) {
		this.nonGouv = nonGouv;
	}

	public int getCIIPasse() {
		return CIIPasse;
	}

	public void setCIIPasse(int cIIPasse) {
		CIIPasse = cIIPasse;
	}

	public int getVentes() {
		return ventes;
	}

	public void setVentes(int ventes) {
		this.ventes = ventes;
	}

	public int getDeducDemandee() {
		return deducDemandee;
	}

	public void setDeducDemandee(int deducDemandee) {
		this.deducDemandee = deducDemandee;
	}
	
	

}
