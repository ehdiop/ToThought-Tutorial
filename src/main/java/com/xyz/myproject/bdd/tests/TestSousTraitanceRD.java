package com.xyz.myproject.bdd.tests;

import org.hibernate.Session;

import com.xyz.myproject.bdd.utils.Mock;
import com.xyz.myproject.bdd.utils.TransactionOperation;
import com.xyz.myproject.model.general.SousTraitanceRD;
import com.xyz.myproject.model.general.SousTraitant;

public class TestSousTraitanceRD {
	
	public static void testCreate() throws Exception{
		SousTraitanceRD soutRD = new SousTraitanceRD();
		SousTraitant sousTraitant = Mock.sousTraitantCreate();
		new TransactionOperation() {
			
			@Override
			protected void operationBrut(Session session, Object... object) {
				SousTraitanceRD stRd=(SousTraitanceRD)object[1];
				SousTraitant st = ((SousTraitant)object[0]);
				session.save(st);
				stRd.addDepense(st, 3000);
				session.save(stRd);
			}
		}.operation(sousTraitant, soutRD);
	}
	
	public static void main(String[] args) {
		try {
			testCreate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
