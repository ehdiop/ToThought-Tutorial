package com.xyz.myproject.bdd.tests;

import org.hibernate.Session;

import com.xyz.myproject.bdd.utils.TransactionOperation;
import com.xyz.myproject.model.sectionsBC.SectionB;

public class TestSectionB {

	public static void main(String[] args) {
		try {
			testCreation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testCreation() throws Exception {
		SectionB sectionB = new SectionB("on a fait plein de progrès",
				"mais y avait des obstacles, hein...",
				"Du coup nous avons travaillé");
		new TransactionOperation() {

			@Override
			protected void operationBrut(Session session, Object... object) {
				session.save((SectionB)object[0]);
			}
		}.operation(sectionB);
	}

}
