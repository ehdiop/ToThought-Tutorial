package com.xyz.myproject.model.general;

public enum TypeSousTraitant {
	
	ENTREPRISE("Entreprise"), INDIVIDU("Individu"), ENTITE(
			"Entité agrée aux fins de la RS&DE");
	
	private String type;

	private TypeSousTraitant(String type) {
		this.type = type;
	}
	
	@Override
	public String toString(){
		return this.type;
	}
	
	
	
	public String getType() {
		return type;
	}


}
