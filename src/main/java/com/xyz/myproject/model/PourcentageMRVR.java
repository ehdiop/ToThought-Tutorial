
package com.xyz.myproject.model;

/**
 * Cette classe rend le pourcentage � appliquer � la base salariale pour calculer le MRVR en fonction des
 * ann�e, via la m�thode statique pourcentageMRVR(int). Cette m�thode est utilis�e dans le calcul du MRVR
 * et permet de mettre � jour facilement les pourcentages � appliquer dans le cas de nouveaux changements de
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
