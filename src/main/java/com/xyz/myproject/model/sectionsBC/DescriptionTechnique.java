package com.xyz.myproject.model.sectionsBC;

import java.util.Observable;

import com.xyz.myproject.model.projet.ButTravaux;

/**
 * Retourne la description technique (SectionB ou SectionC) en fonction du ButTravaux.
 * @author Raoul
 *
 */
public abstract class DescriptionTechnique extends Observable {
	
	public static DescriptionTechnique getDescription(ButTravaux butTravaux){
		if(butTravaux==ButTravaux.DEV_EXP){
			return new SectionB();
		}
		else{
			return new SectionC();
		}
	}

}
