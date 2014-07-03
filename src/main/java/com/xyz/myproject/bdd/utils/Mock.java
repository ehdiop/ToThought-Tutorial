package com.xyz.myproject.bdd.utils;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import com.xyz.myproject.model.exceptions.ClientException;
import com.xyz.myproject.model.exceptions.EmailException;
import com.xyz.myproject.model.exceptions.NEException;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.CodePostal;
import com.xyz.myproject.model.general.FonctionEnum;
import com.xyz.myproject.model.general.InfoGenerales;
import com.xyz.myproject.model.general.MethodeCalcul;
import com.xyz.myproject.model.general.NumeroEntreprise;
import com.xyz.myproject.model.general.NumeroIdProv;
import com.xyz.myproject.model.general.Province;
import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.general.TypeST;
import com.xyz.myproject.model.projet.DepenseST_RD;
import com.xyz.myproject.model.projet.DepenseST_Soutien;
import com.xyz.myproject.model.projet.DepensesProjet;
import com.xyz.myproject.model.projet.DossierAnnee;
import com.xyz.myproject.model.projet.DossierClient;
import com.xyz.myproject.model.projet.Employee;
import com.xyz.myproject.model.projet.ListeProjet;
import com.xyz.myproject.model.projet.Projet;

public class Mock {

	public static List<Client> buildClient() throws ClientException {
		GregorianCalendar debut2012 = new GregorianCalendar(2012, 0, 1);
		GregorianCalendar fin2012 = new GregorianCalendar(2012, 11, 31);
		GregorianCalendar debut2013 = new GregorianCalendar(2013, 0, 1);
		GregorianCalendar fin2013 = new GregorianCalendar(2013, 0, 1);
		MethodeCalcul methode = MethodeCalcul.REMPLACEMENT;

		Annee a2012 = new Annee(debut2012, fin2012, methode);
		Annee a2013 = new Annee(debut2013, fin2013, methode);

		Projet projetInfo = new Projet(
				"Implementation d'un logiciel de crédit d'impot", a2012, null);
		Projet projetCouche = new Projet(
				"Couche d'incontinance en fibre massante pour les peaux sensibles",
				a2012, null);
		Projet projetInso = new Projet(
				"Insonorisation des fourchettes en plastique", a2012, null);
		ListeProjet projets2012 = new ListeProjet();
		projets2012.add(projetCouche);
		projets2012.add(projetInfo);
		ListeProjet projets2013 = new ListeProjet();
		projets2012.add(projetInso);

		// Depenses
		projetInfo.getDepenses().setEqt50(3000);
		projetInfo.getDepenses().setEqt90(2000);
		projetInso.getDepenses().setEqt50(9000);

		DossierAnnee dossierAnnee12 = new DossierAnnee(a2012, projets2012,
				new InfoGenerales());
		DossierAnnee dossierAnnee13 = new DossierAnnee(a2013, projets2013,
				new InfoGenerales());
		HashMap<Annee,DossierAnnee> dossiersAnnee = new HashMap<Annee,DossierAnnee>();
		dossiersAnnee.put(dossierAnnee12.getAnnee(),dossierAnnee12);
		dossiersAnnee.put(dossierAnnee13.getAnnee(),dossierAnnee13);

		DossierClient dossierClient = new DossierClient(dossiersAnnee);
		Client client = new Client("F.Iniciativas", "417 rue saint pierre",
				"Montréal", Province.QC, new CodePostal(),
				new NumeroEntreprise(), new NumeroIdProv(), dossierClient);
		List<Client> clients = new ArrayList<Client>();
		clients.add(client);
		Client client2 = new Client("Risoli", "truc", "truc",null,null,null,null,null);
		clients.add(client2);
		return clients;
	}

	public static SousTraitant sousTraitantCreate() {
		SousTraitant sousTraitant = null;
		try {
			sousTraitant = new SousTraitant("Camembert Président",
					"Fabrication de camembert et vente", "rue des tulipes",
					"Montréal", Province.QC, "HY", TypeST.ENTREPRISE,null,
					false, "123456789FP0001", "123", "456");
		} catch (NEException e) {
			e.printStackTrace();
		}

		return sousTraitant;
	}

	public static Vector<SousTraitant> sousTraitantsCreate() {
		Vector<SousTraitant> sousTraitants = new Vector<SousTraitant>();
		SousTraitant st1 = sousTraitantCreate();
		sousTraitants.add(st1);
		try {
			SousTraitant st2 = new SousTraitant("Fistulator",
					"Guérison de fistules", "Rue perdue", "Nouvelle Ornans",
					Province.QC, "HY", TypeST.ENTREPRISE,null, true,
					"123456789FP0001", "9494", "90493");
			sousTraitants.add(st2);
		} catch (NEException e) {
			e.printStackTrace();
		}
		return sousTraitants;
	}

	public static Vector<Annee> anneesCreate() {
		Annee annee1 = new Annee(new GregorianCalendar(Locale.CANADA_FRENCH),
				new GregorianCalendar(2014, 06, 31), MethodeCalcul.REMPLACEMENT);
		Annee annee2 = new Annee(new GregorianCalendar(2014, 07, 1),
				new GregorianCalendar(2015, 06, 31), MethodeCalcul.REMPLACEMENT);
		Vector<Annee> annees = new Vector<Annee>();
		annees.add(annee1);
		annees.add(annee2);
		return annees;
	}

//	public static Vector<Projet> projetsCreate() {
//		Projet projet1 = new Projet(
//				"Amélioration du système de messagerie vocale", anneesCreate()
//						.get(0));
//		Projet projet2 = new Projet("Amélioration des contenants colorés",
//				anneesCreate().get(0));
//		Vector<Projet> toRet = new Vector<Projet>();
//		toRet.add(projet1);
//		toRet.add(projet2);
//		return toRet;
//	}

	public static List<Employee> employeesCreate() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		try {
			Employee employe1 = new Employee("Martignoni", "Raphaël",
					FonctionEnum.INGENIEUR, "0 an", false, "raphou@hotmail.fr");
			Employee employe2 = new Employee("Aveledo", "Antonio",
					FonctionEnum.PRESIDENT, "5 ans", false, "");
			listEmployees.add(employe1);
			listEmployees.add(employe2);
		} catch (EmailException e) {
		}

		return listEmployees;
	}

//	public static List<MRVR.LigneTableau> moDetermineeDetailCreate() {
//		List<MRVR.LigneTableau> moDeterminee = new ArrayList<MRVR.LigneTableau>();
//		MRVR.LigneTableau ligneTab1 = new MRVR.LigneTableau(employeesCreate()
//				.get(0), 95183, 0.71929, 365, 2012);
//		MRVR.LigneTableau ligneTab2 = new MRVR.LigneTableau(employeesCreate()
//				.get(1), 72519, 0.74953, 365,2012);
//		moDeterminee.add(ligneTab1);
//		moDeterminee.add(ligneTab2);
//		return moDeterminee;
//	}
//
//	public static Projet projetCreate() {
//		EmployesProjet employesProjet = new EmployesProjet(employeesCreate());
//		EmployesImpliques employesImpliques = new EmployesImpliques();
//		employesImpliques.add(employesProjet.get(0));
//
//		Annee annee = anneesCreate().get(0);
//		Projet projet = new Projet(new InfoGeneralesProjet(),
//				employesImpliques, employesProjet,
//				"Implémentation de logiciels révolutionnaires", "Jean Bon",
//				new GregorianCalendar(Locale.CANADA_FRENCH),
//				new GregorianCalendar(2014, 8, 06), new DepensesProjet(annee),
//				annee);
//		return projet;
//	}
	
	public static DepensesProjet depensesProjetCreate(){
		DepensesProjet depProjet =  new DepensesProjet(anneesCreate().get(0));
		depProjet.setEqt50(300);
		depProjet.setEqt90(400);
		depProjet.setLocation50(100);
		depProjet.setLocation90(500);
		depProjet.setMat_conso(300);
		depProjet.setMat_transf(145);
		depProjet.setMoDetermineeCa(40000);
		depProjet.setMoNonDetermineeCa(30000);
		depProjet.setMoDetermineeEtr(20000);
		depProjet.setMoNonDetermineeEtr(15000);
		
		return depProjet;
		
	}
	
	public static List<DepenseST_RD> depensesSTRDcreate(){
		List<SousTraitant> sousTraitants =sousTraitantsCreate();
		DepenseST_RD depense1 = new DepenseST_RD(300,sousTraitants.get(0));
		DepenseST_RD depense2 = new DepenseST_RD(400, sousTraitants.get(1));
		List<DepenseST_RD> toRet = new ArrayList<DepenseST_RD>();
		toRet.add(depense1);
		toRet.add(depense2);
		return toRet;
	}
	
	public static List<DepenseST_Soutien> depenseSTSoutCreate(){
		List<SousTraitant> sousTraitants =sousTraitantsCreate();
		DepenseST_Soutien depense1 = new DepenseST_Soutien(300,sousTraitants.get(0));
		DepenseST_Soutien depense2 = new DepenseST_Soutien(400, sousTraitants.get(1));
		List<DepenseST_Soutien> toRet = new ArrayList<DepenseST_Soutien>();
		toRet.add(depense1);
		toRet.add(depense2);
		return toRet;
	}
}
