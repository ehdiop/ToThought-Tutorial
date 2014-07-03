package com.xyz.myproject.bdd.tests;

import org.hibernate.Session;

import com.xyz.myproject.bdd.utils.Mock;
import com.xyz.myproject.bdd.utils.TransactionOperation;
import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.projet.DepenseST_RD;

public class TestDepSousTraitance {
	
	public static void testCreate() throws Exception{
		
		new TransactionOperation() {
			
			@Override
			protected void operationBrut(Session session, Object... object) {
				SousTraitant sout = Mock.sousTraitantCreate();
				session.save(sout);
				DepenseST_RD dep_sout_rd = new DepenseST_RD(100, sout);
				session.save(dep_sout_rd);
			}
		}.operation();
	}
	
	public static void main(String[] args) {
		try {
			testCreate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
