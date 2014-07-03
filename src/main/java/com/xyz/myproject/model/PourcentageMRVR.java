
package com.xyz.myproject.model;

/**
 * Cette classe rend le pourcentage à appliquer à la base salariale pour calculer le MRVR en fonction des
 * année, via la méthode statique pourcentageMRVR(int). Cette méthode est utilisée dans le calcul du MRVR
 * et permet de mettre à jour facilement les pourcentages à appliquer dans le cas de nouveaux changements de
 * taux
 * @author Raoul
 *
 */
public class PourcentageMRVR {

	
	public static double pourcentageMRVR(int year){
		if(year<2013){
			return 0.65;
		}
		else{
			if(year==2013){
				return 0.60;
			}
			else{
				return 0.55;
			}
		}
	}
}
