package com.xyz.myproject.model.general;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;

import com.xyz.myproject.bdd.utils.Mock;
import com.xyz.myproject.model.CalendarLib;
import com.xyz.myproject.model.MGAP;
import com.xyz.myproject.model.PourcentageMRVR;
import com.xyz.myproject.model.controllers.MAJValeurMRVRController;
import com.xyz.myproject.model.projet.Employee;
import com.xyz.myproject.model.projet.FraisGeneraux;
/**
 * Modélisation du MRVR. Contient les méthodes de calcul du MRVR.
 * @author Raoul
 *
 */

@javax.persistence.Entity
public class MRVR extends FraisGeneraux implements java.io.Serializable {

	public enum MRVREVENT{RECALCULE};
	

	private static final long serialVersionUID = -354379589L;

	private Long id;

	private Annee annee;

	private MapLigneMRVR lignesTableauCa;
	private MapLigneMRVR lignesTableauEtr;




	/**
	 * Traitements et salaires des employes au canada
	 */
	private TSGeneralCanada traitementCanada;
	/**
	 * Traitements et salaires des employes à l'étranger
	 */
	private TSGeneralEtr traitementEtr;


	private double mrvrCalcule = 0;

	private double bsCalculee = 0;

	/**
	 * @generated
	 */
	public MRVR() {
		this(new Annee(), new TSGeneralCanada(), new TSGeneralEtr(),
				new MapLigneMRVR(), new MapLigneMRVR());
	}

	public MRVR(Annee annee, TSGeneralCanada tsCa, TSGeneralEtr tsEtr,
			MapLigneMRVR determinesCanada, MapLigneMRVR determinesEtr) {
		this.annee = annee;
		this.lignesTableauCa = determinesCanada;
		this.lignesTableauEtr = determinesEtr;
		this.setTraitementCanada(tsCa);
		this.setTraitementEtr(tsEtr);

	}

	public MRVR(Annee annee) {
		this();
		this.annee = annee;
	}

	public Annee getAnnee() {
		return annee;
	}

	public void setAnnee(Annee annee) {
		this.annee = annee;
	}


	public MapLigneMRVR getLignesTableauCa() {
		return lignesTableauCa;
	}

	public void setLignesTableauCa(MapLigneMRVR lignesTableauCa) {
		this.lignesTableauCa = lignesTableauCa;
	}

	public MapLigneMRVR getLignesTableauEtr() {
		return lignesTableauEtr;
	}

	public void setLignesTableauEtr(MapLigneMRVR lignesTableauEtr) {
		this.lignesTableauEtr = lignesTableauEtr;
	}

	public TSGeneralCanada getTraitementCanada() {
		return traitementCanada;
	}

	public void setTraitementCanada(TSGeneralCanada traitementCanada) {
		this.traitementCanada = traitementCanada;
		MAJValeurMRVRController controller = new MAJValeurMRVRController(this);
		this.traitementCanada.addObserver(controller);
	}

	public TSGeneralEtr getTraitementEtr() {
		return traitementEtr;
	}

	public void setTraitementEtr(TSGeneralEtr traitementEtr) {
		this.traitementEtr = traitementEtr;
		MAJValeurMRVRController controller = new MAJValeurMRVRController(this);
		this.traitementEtr.addObserver(controller);

	}



	public double getMrvrCalcule() {
		return mrvrCalcule;
	}

	public void setMrvrCalcule(double mrvrCalcule) {
		this.mrvrCalcule = mrvrCalcule;
		this.setChanged();
		this.notifyObservers(MRVREVENT.RECALCULE);
	}

	public double getBsCalculee() {
		return bsCalculee;
	}

	public void setBsCalculee(double bsCalculee) {
		this.bsCalculee = bsCalculee;
		this.setChanged();
		this.notifyObservers(MRVREVENT.RECALCULE);
	}

	/**
	 * @generated
	 */
	public String toString() {
		return "MRVR" + " id=" + id;
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
	 * Calcul du montant de la ligne 816 correspondant à la somme des dépenses
	 * en salaire des employés déterminés pour des activités de RSDE. Prend en
	 * compte le MGAP.
	 * 
	 * @return le montant de la ligne 816, la somme de chaque ligne du tableau
	 *         de la section A partie 5 du T661
	 */
	private long montantLigne816() {
		long toRet = 0;
		ArrayList<LigneTableau> toutesLignes = new ArrayList<MRVR.LigneTableau>(
				this.getLignesTableauCa().values());
		toutesLignes.addAll(this.lignesTableauEtr.values());
		for (LigneTableau ligneTab : toutesLignes) {
			toRet += ligneTab.calculMontantCol6();
		}
		return toRet;
	}

	/**
	 * Cette fonction calcule le montant de la base salariale (ligne 818) à
	 * partir des salaires des employés non déterminés pour les activités de
	 * RSDE exercées à l'étranger et au Canada, et à partir des traitements et
	 * salaires des employés déterminés calculés par la fonction
	 * montantLigne816()
	 * 
	 * @return le montant de la base salariale (ligne 818)
	 */
	public long montantBaseSalariale() {
		double l810 = this.getTraitementCanada().getMo_non_determinee()
				+ this.getTraitementEtr().getMo_non_determinee();
		double l812 = this.getTraitementCanada().getBoni()
				+ this.getTraitementEtr().getBoni();
		double l814 = l810-l812;
		if(l814<0)l814=0;
		double l816 = this.montantLigne816();
		return (long) (l814 + l816);
	}

	/**
	 * Calcule le MRVR en appliquant un taux à la base salariale. Cette méthode
	 * prend en compte les caractéristiques de l'année fiscale traitée pour
	 * appliquer les taux correspondants.
	 * 
	 * @return la valeur du MRVR, montant de la ligne 820 du T661
	 */
	public long calculMRVR() {
		Calendar debutAnnee = this.getAnnee().getAnnee_date_debut();
		Calendar finAnnee = this.getAnnee().getAnnee_date_fin();
		int anneeDebut = debutAnnee.get(Calendar.YEAR);
		int anneeFin = finAnnee.get(Calendar.YEAR);
		double baseSalariale = montantBaseSalariale();

		//

		int nbJourAnneeDebut = debutAnnee
				.getActualMaximum(Calendar.DAY_OF_YEAR)
				- debutAnnee.get(Calendar.DAY_OF_YEAR) + 1;
		int nbJourAnneeFin = finAnnee.get(Calendar.DAY_OF_YEAR);
		CalendarLib.display(debutAnnee);

		if (PourcentageMRVR.pourcentageMRVR(anneeDebut) != PourcentageMRVR
				.pourcentageMRVR(anneeFin)) {
			int joursAnneeFiscale = nbJourAnneeDebut + nbJourAnneeFin;
			double toRet;

			toRet = Math
					.round(((double) nbJourAnneeDebut / (double) joursAnneeFiscale)
							* baseSalariale
							* PourcentageMRVR.pourcentageMRVR(anneeDebut));
			toRet += ((double) nbJourAnneeFin / (double) joursAnneeFiscale)
					* baseSalariale * PourcentageMRVR.pourcentageMRVR(anneeFin);
			return Math.round(toRet);
		} else {
			return Math.round(PourcentageMRVR.pourcentageMRVR(anneeFin)
					* baseSalariale);
		}

	}
	
	public void tmp(){
		this.setChanged();
		this.notifyObservers(MRVREVENT.RECALCULE);
	}

	/**
	 * Représente une ligne du tableau du calcul de la base salariale
	 * 
	 * @author Raoul
	 * 
	 */
	public static class LigneTableau extends Observable {
		private Employee employe;
		/**
		 * Total des traitements ou salaires pour l'année
		 */
		private double traitementsEmploye;
		/**
		 * Pourcentage de temps consacré à la RSDE (max 75%)
		 */
		private double tempsConsacre;
		/**
		 * Nombre de jours travaillés dans l'année
		 */
		private int nbJourW;

		/**
		 * L'information de l'année est nécessaire pour savoir quelle valeur du
		 * MGAP utiliser.
		 */
		private Annee annee;

		public enum LIGNEMRVR {
			MODIF
		};

		public LigneTableau(Employee employe, double traitements,
				double tempsConsacre, int nbW, Annee annee) {
			this.employe = employe;
			this.traitementsEmploye = traitements;
			this.tempsConsacre = tempsConsacre;
			this.nbJourW = nbW;
			this.annee = annee;
		}

		public Employee getEmploye() {
			return employe;
		}

		public void setEmploye(Employee employe) {
			this.employe = employe;
		}

		public double getTraitementsEmploye() {
			return traitementsEmploye;
		}

		public void setTraitementsEmploye(double traitementsEmploye) {
			this.traitementsEmploye = traitementsEmploye;
			this.setChanged();
			this.notifyObservers(LIGNEMRVR.MODIF);
		}

		public double getTempsConsacre() {
			return tempsConsacre;
		}

		public void setTempsConsacre(double tempsConsacre) {
			this.tempsConsacre = tempsConsacre;
			this.setChanged();
			this.notifyObservers(LIGNEMRVR.MODIF);
		}

		public int getNbJourW() {
			return nbJourW;
		}

		public void setNbJourW(int nbJourW) {
			this.nbJourW = nbJourW;
			this.setChanged();
			this.notifyObservers(LIGNEMRVR.MODIF);
		}

		public Annee getAnnee() {
			return annee;
		}

		public void setAnnee(Annee annee) {
			this.annee = annee;
		}

		/**
		 * Montant de la colonne 6, correspondant au moins élevé des montants
		 * des colonnes 4 et 5, soit le montant moins élevé entre les salaires
		 * RSDE des employés déterminés et 2.5*mgap au prorata des jours
		 * travaillés.
		 * 
		 * @return le montant le moins élevé de la colonne 4 et 5
		 */
		public long calculMontantCol6() {
			return Math.min(this.montantColonne4(), this.montantColonne5());
		}

		/**
		 * 2.5*mgap au prorata des jours travaillés dans l'année
		 * 
		 * @return 2.5*mgap de l'année en cours à la fin de l'année d'imposition
		 */
		private long montantColonne5() {

			int mgap = MGAP.getMgap(this.getAnnee().getFinChiffre());

			return Math.round(2.5 * mgap * this.getNbJourW() / 365);
		}

		private long montantColonne4() {
			return Math.round(this.getTraitementsEmploye()
					* this.getTempsConsacre());
		}

		@Override
		public int hashCode() {
			return this.getEmploye().hashCode();
		}
		
		@Override
		public String toString() {
			return this.employe+" "+this.traitementsEmploye+" "+this.tempsConsacre;
		}
		
		

	}

	public static void main(String[] args) {
		Annee annee = new Annee(new GregorianCalendar(2012, 5, 1),
				new GregorianCalendar(2013, 4, 31), MethodeCalcul.REMPLACEMENT);
		TSGeneralCanada traitementsCa = new TSGeneralCanada(321264, 0, 0, 8425);
		TSGeneralEtr traitementEtr = new TSGeneralEtr();

		LigneTableau ligneTab1 = new LigneTableau(new Employee(), 95183,
				0.71929, 365, annee);
		LigneTableau ligneTab2 = new LigneTableau(new Employee(), 72519,
				0.74953, 365, annee);
		MapLigneMRVR hash1 = new MapLigneMRVR();
		hash1.put(Mock.employeesCreate().get(0), ligneTab1);
		MapLigneMRVR hash2 = new MapLigneMRVR();
		hash2.put(Mock.employeesCreate().get(1), ligneTab2);
		MRVR mrvr = new MRVR(annee, traitementsCa, traitementEtr, hash1, hash2);

		System.out.println(mrvr.calculMRVR());

	}

}