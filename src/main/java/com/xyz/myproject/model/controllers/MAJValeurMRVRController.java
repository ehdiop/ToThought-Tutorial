package com.xyz.myproject.model.controllers;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.general.MRVR;
import com.xyz.myproject.model.general.MapLigneMRVR.MAPMRVR;
import com.xyz.myproject.model.general.TSGeneral.TSGEN;
import com.xyz.myproject.model.general.TSGeneralCanada.EVENT_TSGEN_CA;
import com.xyz.myproject.model.general.TSGeneralEtr.TSGEN_ETR;

/**
 * COntroller observant la mise à jour des LigneTableau, et mettant à jour les variables d'instance de MRVR 
 * @author Raoul
 *
 */
public class MAJValeurMRVRController implements Observer {
	
	private MRVR mrvr;
	
	public MAJValeurMRVRController(MRVR mrvr){
		this.mrvr=mrvr;
	}

	@Override
	public void update(Observable arg0, Object message) {
		boolean right = (message instanceof MAPMRVR && (MAPMRVR)message==MAPMRVR.UPDATE)
				|| ((message instanceof EVENT_TSGEN_CA) &&(EVENT_TSGEN_CA)message ==EVENT_TSGEN_CA.MO_NON_DET)
				|| ((message instanceof TSGEN) && (TSGEN)message == TSGEN.BONI)
				|| ((message instanceof TSGEN_ETR)&& (TSGEN_ETR)message == TSGEN_ETR.MO_NON_DET);
		if(right){
			this.maj();
		}
	}
	
	public void maj(){
		double mrvrCalule = this.mrvr.calculMRVR();
		double bsCalculee = this.mrvr.montantBaseSalariale();

		this.mrvr.setMrvrCalcule(mrvrCalule);
		this.mrvr.setBsCalculee(bsCalculee);

		
		
	}

}
