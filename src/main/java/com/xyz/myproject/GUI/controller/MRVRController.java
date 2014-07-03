package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.GUI.presentation.general.PanelMRVR;
import com.xyz.myproject.model.general.MRVR;
import com.xyz.myproject.model.general.MRVR.MRVREVENT;

/**
 * Met à jour les valeurs affichées du MRVR avec celles du modele lorsque les valeurs calculées sont
 * mises à jour
 * 
 * @author Raoul
 *
 */
public class MRVRController implements Observer {
	
	private MRVR mrvr;
	private PanelMRVR panelMRVR;
	

	public MRVRController(MRVR mrvr, PanelMRVR panelMRVR) {
		super();
		this.mrvr = mrvr;
		this.panelMRVR=panelMRVR;
	}



	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof MRVREVENT && (MRVREVENT)arg == MRVREVENT.RECALCULE){
			this.panelMRVR.getBsLabel().setText(""+this.mrvr.getBsCalculee());
			this.panelMRVR.getMrvrLabel().setText(""+this.mrvr.getMrvrCalcule());
		}

	}

}
