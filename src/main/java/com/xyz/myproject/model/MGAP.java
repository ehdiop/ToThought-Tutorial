package com.xyz.myproject.model;

import java.util.Collections;
import java.util.HashMap;
/**
 * Les valeurs du MGAP selon les années. A noter qu'à partir de 2014, les valeurs seront bidons. Ce qui n'est
 * pas très grave a priori, puisque le MRVR est calculé à titre indicatif. Cette classe devra disparaitre 
 * quand le programme sera muni d'une base de données avec laquelle intéragir.
 * @author Raoul
 *
 */
public class MGAP {
	
	/**
	 * Represents the correspondance during a year and the value of the mgap
	 */
	private static HashMap<Integer, Integer> mgap;
	
	static{
		mgap = new HashMap<Integer, Integer>();
		mgap.put(2004, 40500);
		mgap.put(2005, 41100);
		mgap.put(2006, 42100);
		mgap.put(2007, 43700);
		mgap.put(2008, 44900);
		mgap.put(2009, 46300);
		mgap.put(2010, 47200);
		mgap.put(2011, 48300);
		mgap.put(2012, 50100);
		mgap.put(2013, 51100);
		
	}
	
	public static int getMgap(int year){
		Integer tmp = mgap.get(year);
		if(tmp==null){
			return mgap.get(Collections.max(mgap.keySet()));
		}
		else{
			return tmp;
		}
	}
	
	public static void setMgap(int year, int value){
		mgap.put(year, value);
	}

}
