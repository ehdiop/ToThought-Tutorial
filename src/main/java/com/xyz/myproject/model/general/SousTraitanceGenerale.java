package com.xyz.myproject.model.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.xyz.myproject.model.projet.DepenseAbstract;

/**
 * Classe abstraite mod�lisant les d�penses de sous-traitance pour le dossier projet. Les d�penses de sous-traitance
 * ne sont ici pas diff�renci�es par projet. Pour une ann�e fiscale, on fait correspondre un sous-traitant
 * avec l'ensemble des d�penses qui lui ont �t� vers�e pour cette ann�e. La mise � jour de ces montants
 * est faite par le controleur DepensesController, lorsque les d�penses de sous-traitance pour un projet
 * sont modifi�es (classes DepenseST_RD et DepenseST_Soutien agr�g�es dans DepensesSousTraitance<?>). Cette
 * classe abstraite est �tendue par SousTraitanceRD et SousTraitance_Soutien
 * @author Raoul
 *
 */
public abstract class SousTraitanceGenerale extends DepenseAbstract {
	public enum SOUT_GEN{MODIF};

	protected Map<SousTraitant, Double> depenses;

	/**
	 * @generated
	 */
	public SousTraitanceGenerale(){
		this.depenses = new HashMap<SousTraitant, Double>();
	}
	
	public synchronized void addDepense(SousTraitant sousTraitant, double montant) {
		if(this.depenses.get(sousTraitant)==null){
			this.setDepense(sousTraitant, montant);
		}
		else{
			double tmp = this.depenses.get(sousTraitant);
			this.setDepense(sousTraitant,tmp+montant);
		}
		this.setChanged();
		this.notifyObservers(SOUT_GEN.MODIF);
	}
	
	public void clear(){
		this.depenses.clear();
		this.setChanged();
		this.notifyObservers(SOUT_GEN.MODIF);
	}
	

	public void setDepense(SousTraitant sousTraitant, double montant){
		this.depenses.put(sousTraitant, montant);
	}
	
	public Map<SousTraitant, Double> getDepenses() {
		return depenses;
	}

	public void setDepenses(HashMap<SousTraitant, Double> depenses) {
		this.depenses = depenses;
	}
	
	public double getMontantVerse(SousTraitant st){
		double toRet = (this.getDepenses().get(st)!=null)?this.getDepenses().get(st):0;
		
		return toRet;
	}
	
	/**
	 * Retourne le montant vers� aux sous traitants avec lien de d�pendance dans l'ann�e
	 * @return
	 */
	public double getMontantVerseDep(){
		return this.getMontantTotal(true);
	}
	
	/**
	 * Retourne le montant vers� aux sous traitant sans lien de d�pendance dans l'ann�e
	 * @return
	 */
	public double getMontantVerseNonDep(){
		return this.getMontantTotal(false);
	}
	
	private double getMontantTotal(boolean dep){
		Set<SousTraitant> keySet = this.getDepenses().keySet();
		double toRet=0;
		for(SousTraitant key : keySet){
			if(key.isDep()!=dep)continue;
			toRet+=this.getMontantVerse(key);
		}
		return toRet;
	}
	
	public int size(){
		return depenses.size();
	}

}
