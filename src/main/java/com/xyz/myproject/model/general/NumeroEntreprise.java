package com.xyz.myproject.model.general;

import com.xyz.myproject.model.exceptions.NEException;
import com.xyz.myproject.model.exceptions.NEException.NE_EXC_CODE;
/**
 * Modélisation du numéro d'entreprise. Utilise une regex pour vérifier que le numéro entré respecte la norme.
 * @author Raoul
 *
 */
@javax.persistence.Embeddable
public class NumeroEntreprise implements java.io.Serializable {


	private static final long serialVersionUID = -2110173051L;
	
	private final static String regex;
	
	static{
		String tmp = "\\d{9}[A-Z]{2}0{3}[12]";
		regex = tmp+"|";
	}
	
	private String ne;

	
	public NumeroEntreprise() {
	}
	
	
	public NumeroEntreprise(String ne) throws NEException {
		super();
		this.ne = ne.replaceAll(" ", "");
		if(!this.ne.matches(regex)){
			throw new NEException(NE_EXC_CODE.NE);
		}
	}


	public String toString() {
		return ne;
	}
	
	
	
	public String getNe() {
		return ne;
	}


	public void setNe(String ne) {
		this.ne = ne;
	}


	public static void main(String[] args) {
		try {
			NumeroEntreprise ne=new NumeroEntreprise("123456789FP0001");
			System.out.println(ne);
		} catch (NEException e) {
			e.printStackTrace();
		}
	}

}
