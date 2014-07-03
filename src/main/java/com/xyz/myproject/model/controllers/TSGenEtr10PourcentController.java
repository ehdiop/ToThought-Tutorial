package com.xyz.myproject.model.controllers;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.general.TSGeneralCanada;
import com.xyz.myproject.model.general.TSGeneralEtr;

/**
 * The controller to update the value of TSGeneralEtr.mo_non_determinee_proposee. See the description of
 * TSGeneralEtr for more details. 
 * @author Raoul
 *
 */
public class TSGenEtr10PourcentController implements Observer {

	private TSGeneralCanada tsGenCa;

	private TSGeneralEtr tsGenEtr;

	public TSGenEtr10PourcentController(TSGeneralCanada tsGenCa,
			TSGeneralEtr tsGenEtr) {
		super();
		this.tsGenCa = tsGenCa;
		this.tsGenEtr = tsGenEtr;
	}

	@Override
	public void update(Observable arg0, Object message) {
		switch((TSGeneralCanada.EVENT_TSGEN_CA)message){
		case MO_NON_DET : {
			double currentVal = tsGenEtr.getMo_non_determinee();
			double min = Math.min(0.1*tsGenCa.getMo_non_determinee(), currentVal);
			if(min!=currentVal){
				this.tsGenEtr.set_propo_mo_non_determinee(min);
			}
		}
		}
	}

}
