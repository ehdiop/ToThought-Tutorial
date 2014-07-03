package com.xyz.myproject.bdd.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.hibernate.Session;

import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.CodePostal;
import com.xyz.myproject.model.general.MethodeCalcul;
import com.xyz.myproject.model.general.NumeroEntreprise;
import com.xyz.myproject.model.general.NumeroIdProv;
import com.xyz.myproject.model.general.Province;

public class TestBDD {
	
	public static void testAnneeEcriture() throws Exception{
		GregorianCalendar today = new GregorianCalendar(Locale.CANADA_FRENCH);
		GregorianCalendar nextYear = new GregorianCalendar(Locale.CANADA_FRENCH);
		nextYear.add(Calendar.YEAR, 1);
		Annee annee = new Annee(today,nextYear,MethodeCalcul.REMPLACEMENT);
		new TransactionOperation() {
			
			@Override
			protected void operationBrut(Session session, Object... object) {
				session.save((Annee)object[0]);
			}
		}.operation(annee);
	}
	
	public static void testAnneeRead() throws Exception{
		new TransactionOperation() {
			
			@Override
			protected void operationBrut(Session session, Object... object) {
				Annee annee = (Annee) session.get(Annee.class, Long.parseLong(1+""));
				System.out.println(annee);
			}
		}.operation();
	}
	
	public static void testClientEcriture() throws Exception{
		NumeroEntreprise ne = new NumeroEntreprise("123456789FP0001");
		NumeroIdProv nIdProv = new NumeroIdProv();
//		NEQ neq = new NEQ();
		Client client = new Client("F.Iniciativas", "417 rue saint pierre", "Montréal", Province.QC, new CodePostal("HEYDH"),ne, nIdProv,null);
		
		new TransactionOperation() {
			
			@Override
			protected void operationBrut(Session session, Object... object) {
				session.save((Client)object[0]);
			}
		}.operation(client);
	}
	
	public static void testClientRead()throws Exception{
		
		
		new TransactionOperation() {
			
			@Override
			protected void operationBrut(Session session, Object... object) {
				Client client = (Client)session.get(Client.class, Long.parseLong(""+5));
				System.out.println(client);
			}
		}.operation();
	}
	
	
	public static void main(String[] args) {
		try {
			testClientRead();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
