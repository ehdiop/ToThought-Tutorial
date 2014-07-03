package com.xyz.myproject.model.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.xyz.myproject.model.exceptions.EmailException;
import com.xyz.myproject.model.projet.Email;

public class EmailTest {
	
	public void testRightEmail(String string){
		try{
			Email email = new Email(string);
		}
		catch(EmailException e){
			fail("shouldn't raise an exception");
		}
	}
	
	public void testWrongEmailNoTest(String string) throws EmailException{
		Email email = new Email(string);
		
	}
	
	@Test(expected = EmailException.class)
	public void testWrongEmail() throws EmailException{
		testWrongEmailNoTest("bernard.fr");
	}
	
	@Test
	public void testEmail1() {
		testRightEmail("bernard@hotmail.fr");
		testRightEmail("bertrand_dubus@f-iniciativas.fr");
		testRightEmail("je/an-.-truc@free.fr");
		testRightEmail("triffoNTournesol@titin.net");
		
	}

}
