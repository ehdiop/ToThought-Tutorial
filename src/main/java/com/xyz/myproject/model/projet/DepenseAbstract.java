package com.xyz.myproject.model.projet;

import java.util.Observable;


/**
 * Une dépense projet. Utile pour être observé par les contrôleurs.
 */
public abstract class DepenseAbstract extends Observable {
	/**
	 * @generated
	 */
	protected double montant;
	
	protected String nom;
	/**
	 * @generated
	 */
	/**
	 * @generated
	 */
	public DepenseAbstract() {
	}
	
	
	protected DepenseAbstract(String nom,double montant){
		this.nom=nom;
		this.montant=montant;
	}

	/**
	 * @generated
	 */
	public String toString() {
		return "IDepense" + " montant=" + montant;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getNom() {
		return nom;
	}

	
	
	
	



	
	

	
}