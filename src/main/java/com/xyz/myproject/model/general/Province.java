package com.xyz.myproject.model.general;
/**
 * Pour l'instant que le Qu�bec. 
 * @author Raoul
 *
 */

// modif perso 
// remplacement de enum par class
// also QC{"Quebec"}; supprim�
public enum Province {
	
	QC("Qu�bec");
	
	private String province;
	private Province(String province){
		this.province = province;
	}
	
	public String toString(){
		return this.province;
	}

	
	

}
