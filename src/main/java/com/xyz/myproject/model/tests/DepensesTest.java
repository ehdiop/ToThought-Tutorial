package com.xyz.myproject.model.tests;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.xyz.myproject.bdd.utils.Mock;
import com.xyz.myproject.model.exceptions.ClientException;
import com.xyz.myproject.model.general.Client;

public class DepensesTest extends TestCase {
	
	@Test
	public void testMAJDepensesGeneralesCreation() throws ClientException{
		List<Client> clients = Mock.buildClient();
		double actual =clients.get(0).getDossierClient().getDossiersAnnee().get(0).getInfos().getDepenses().getEqt_50().getMontant();
		assertEquals(12000.0, actual);
	}
	
	@Test
	public void testMAJDepensesMODetermineeEtr() throws ClientException{
		List<Client> clients = Mock.buildClient();
		clients.get(0).getDossierClient().getDossiersAnnee().get(0).getProjets().get(0).getDepenses().setMoDetermineeEtr(5000);
		double actual = clients.get(0).getDossierClient().getDossiersAnnee().get(0).getProjets().get(0).getDepenses().getTsProjetEtr().getMo_determinee();
		assertEquals(5000.0, actual);
	}
	
	@Test
	public void testMAJDepensesMODetermineeEtr2() throws ClientException{
		List<Client> clients = Mock.buildClient();
		clients.get(0).getDossierClient().getDossiersAnnee().get(0).getProjets().get(0).getDepenses().setMoDetermineeEtr(5000);
		clients.get(0).getDossierClient().getDossiersAnnee().get(0).getProjets().get(1).getDepenses().setMoDetermineeEtr(2000);
		double actual = clients.get(0).getDossierClient().getDossiersAnnee().get(0).getInfos().getDepenses().getTraitementEtr().getMo_determinee();
		assertEquals(7000.0, actual);
	}
	
	@Test
	public void testMAJDepensesMatTransf() throws ClientException{
		List<Client> clients = Mock.buildClient();
		clients.get(0).getDossierClient().getDossiersAnnee().get(0).getProjets().get(0).getDepenses().setMat_transf(5000);
		clients.get(0).getDossierClient().getDossiersAnnee().get(0).getProjets().get(1).getDepenses().setMat_transf(2000);
		double actual = clients.get(0).getDossierClient().getDossiersAnnee().get(0).getInfos().getDepenses().getMat_transf().getMontant();
		assertEquals(7000.0,actual);
	}
	
	@Test
	public void testMAJDepensesMatConso() throws ClientException{
		List<Client> clients = Mock.buildClient();
		clients.get(0).getDossierClient().getDossiersAnnee().get(0).getProjets().get(0).getDepenses().setMat_conso(5000);
		clients.get(0).getDossierClient().getDossiersAnnee().get(0).getProjets().get(1).getDepenses().setMat_conso(2000);
		double actual = clients.get(0).getDossierClient().getDossiersAnnee().get(0).getInfos().getDepenses().getMat_conso().getMontant();
		assertEquals(7000.0,actual);
	}
	
	
	
}
