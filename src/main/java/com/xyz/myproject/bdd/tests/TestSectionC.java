package com.xyz.myproject.bdd.tests;

import org.hibernate.Session;

import com.xyz.myproject.bdd.utils.TransactionOperation;
import com.xyz.myproject.model.sectionsBC.SectionC;

public class TestSectionC {
	
	public static void main(String[] args) {
		try {
			testCreate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testCreate() throws Exception{
		
		SectionC sectionC = new SectionC("On a bien avancé", "on a fait des travaux");
		
		new TransactionOperation() {
			
			@Override
			protected void operationBrut(Session session, Object... object) {
				session.save((SectionC)object[0]);
			}
			
		}.operation(sectionC);
	}

}
