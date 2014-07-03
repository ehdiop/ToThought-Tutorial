package com.xyz.myproject.model.general;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.xyz.myproject.model.PARAMETERS;
import com.xyz.myproject.model.controllers.AnneeController;
/**
 * Modélisation d'une année
 * @author Raoul
 *
 */
@Entity
@Table(name = "annee")
public class Annee extends Observable {
	
	// Enums for observable/observer pattern
	
	public enum CHANGE_DATE {CHANGE_BEGINNING, CHANGE_END};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="annee_id")
	private long id;
	
	
	private Calendar annee_date_debut;
	
	
	private Calendar annee_date_fin;

	@Type(type="com.xyz.myproject.bdd.enums.MethodeCalculUserType")
	@Column(name = "annee_methode")
	
	private MethodeCalcul method;

	public Annee() {
		this(getDefaultBeginningDate(), getDefaultEndingDate(),MethodeCalcul.REMPLACEMENT);
	}

	public Annee(Calendar annee_date_debut, Calendar annee_date_fin,
			MethodeCalcul method) {
		super();
		this.addObserver(new AnneeController());
		this.setAnnee_date_debut(annee_date_debut);
		this.setAnnee_date_fin(annee_date_fin);
		this.method = method;
	}
	
	
	
	
	public MethodeCalcul getMethod() {
		return method;
	}

	public void setMethod(MethodeCalcul method) {
		this.method = method;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getAnnee_date_debut() {
		return annee_date_debut;
	}

	public void setAnnee_date_debut(Calendar annee_date_debut) {
		this.annee_date_debut = annee_date_debut;
		//this.setChanged();
		//this.notifyObservers(CHANGE_DATE.CHANGE_BEGINNING);
	}

	@Temporal(TemporalType.DATE)
	public Calendar getAnnee_date_fin() {
		return annee_date_fin;
	}

	public void setAnnee_date_fin(Calendar annee_date_fin) {
		
		this.annee_date_fin = annee_date_fin;
		//this.setChanged();
		//this.notifyObservers(CHANGE_DATE.CHANGE_END);
	}
	
	/**
	 * This method is called to check the 
	 * @param debut
	 * @param fin
	 * @return
	 */
	public boolean timeSequenceOk(Calendar debut, Calendar fin){
		boolean isOk=true;
		
		if(debut==null||fin==null)return true;
		
		try{
			isOk = fin.compareTo(debut)>0;
		}
		catch(NullPointerException e){
			
		}
		catch(IllegalArgumentException e){
			
		}
		return isOk;
		
	}
	
	
	public String toString(){
		
		return ""+this.annee_date_fin.get(Calendar.YEAR);
		
	}
	
	/**
	 * The default begin date for a year. To improve later
	 * @return the default begin date of the fiscal year
	 */
	public static Calendar getDefaultBeginningDate(){
		GregorianCalendar debut = new GregorianCalendar(PARAMETERS.LOCALE);
		debut.set(Calendar.DAY_OF_MONTH, 1);
		debut.set(Calendar.MONTH, 5);
		return debut;
	}
	
	/**
	 * The default ending date for the fiscal year. To improve later
	 * @return the default ending date for the fiscal year
	 */
	public static Calendar getDefaultEndingDate(){
		GregorianCalendar fin = new GregorianCalendar(PARAMETERS.LOCALE);
		fin.set(Calendar.DAY_OF_MONTH, 31);
		fin.set(Calendar.MONTH, 4);

		fin.add(Calendar.YEAR,1);
		return fin;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean sameYear(Annee annee){
		return annee.getAnnee_date_debut().get(Calendar.YEAR) == this.getAnnee_date_debut().get(Calendar.YEAR);
	}
	
	@Override
	public int hashCode() {
		return (int) this.getAnnee_date_fin().getTimeInMillis();
	}
	
	public int getFinChiffre(){
		return this.getAnnee_date_fin().get(Calendar.YEAR);
	}

}
