package com.xyz.myproject.model.general;
/**
 * Pour l'instant que le Québec. 
 * @author Raoul
 *
 */

// modif perso 
// remplacement de enum par class
// also QC{"Quebec"}; supprimé
public enum Province {
	
	QC("Québec");
	
	private String province;
	private Province(String province){
		this.province = province;
	}
	
	public String toString(){
		return this.province;
	}

	
	

}
