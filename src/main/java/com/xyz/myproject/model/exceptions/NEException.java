package com.xyz.myproject.model.exceptions;
/**
 * Renvoyé lorsque le numéro d'entreprise n'est pas conforme à la norme.
 * @author Raoul
 *
 */
public class NEException extends Exception {
	
	public enum NE_EXC_CODE{NE, NUM_PROV, NEQ};
	private NE_EXC_CODE ne_code;

	public NEException(NE_EXC_CODE ne_code){
		this.ne_code = ne_code;
	}
	
	public String titre(){
		return "numero d'entreprise incorrect";
	}

	@Override
	public String toString() {
		String type_num="", abrev="", exemple="";
		
		switch(ne_code){
		case NE: {
			type_num = "Le numéro d'entreprise (NE)";
			abrev = "NE";
			exemple = "123456789 RP 0001";
		}
		}
		return type_num+" n'est pas correct. Exemple de "+abrev+" : "+exemple;
	}
	
	
	
	

}
