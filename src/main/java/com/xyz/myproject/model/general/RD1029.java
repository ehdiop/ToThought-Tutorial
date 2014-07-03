package com.xyz.myproject.model.general;
/**
 * Modélisation du RD1029.
 * @author Raoul
 *
 */
public class RD1029 {
	
	private RD1029Partie2 partie2;
	private RD1029Partie3 partie3;
	
	public RD1029(){
		this.partie3=new RD1029Partie3();
		this.partie2=new RD1029Partie2();
	}

	public RD1029Partie3 getPartie3() {
		return partie3;
	}

	public void setPartie3(RD1029Partie3 partie3) {
		this.partie3 = partie3;
	}

	public RD1029Partie2 getPartie2() {
		return partie2;
	}

	public void setPartie2(RD1029Partie2 partie2) {
		this.partie2 = partie2;
	}
	

	

	
	
	

}
