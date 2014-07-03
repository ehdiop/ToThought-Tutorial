 package com.xyz.myproject.model.sectionsBC;

import javax.persistence.Embeddable;


/**
 * Oups ! Je crois que j'utilise jamais ce truc là. Modélisé deux fois on dirait.
 */
@Embeddable
public class TableauSecB {
	
	private boolean creation_materiaux;
	private boolean creation_procedes;
	private boolean amelioration_materiaux;
	private boolean amelioration_procedes;
	
	
	
	public TableauSecB() {
		super();
	}

	public TableauSecB(boolean creation_materiaux, boolean creation_procedes,
			boolean amelioration_materiaux, boolean amelioration_procedes) {
		super();
		this.creation_materiaux = creation_materiaux;
		this.creation_procedes = creation_procedes;
		this.amelioration_materiaux = amelioration_materiaux;
		this.amelioration_procedes = amelioration_procedes;
	}

	public boolean isCreation_materiaux() {
		return creation_materiaux;
	}

	public void setCreation_materiaux(boolean creation_materiaux) {
		this.creation_materiaux = creation_materiaux;
	}

	public boolean isCreation_procedes() {
		return creation_procedes;
	}

	public void setCreation_procedes(boolean creation_procedes) {
		this.creation_procedes = creation_procedes;
	}

	public boolean isAmelioration_materiaux() {
		return amelioration_materiaux;
	}

	public void setAmelioration_materiaux(boolean amelioration_materiaux) {
		this.amelioration_materiaux = amelioration_materiaux;
	}

	public boolean isAmelioration_procedes() {
		return amelioration_procedes;
	}

	public void setAmelioration_procedes(boolean amelioration_procedes) {
		this.amelioration_procedes = amelioration_procedes;
	}
	
	
	
	
	

}