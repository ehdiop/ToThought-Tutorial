package com.xyz.myproject.model.general;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.general.MRVR.LigneTableau.LIGNEMRVR;
import com.xyz.myproject.model.projet.Employee;

/**
 * MapLigneMRVR implements Observer to detect its components updates, and be able to throw an event when
 * this happens.
 * @author Raoul
 *
 */
public class MapLigneMRVR extends MapE<Employee, MRVR.LigneTableau> implements Observer{
	
	public enum MAPMRVR{AJOUT, DEL, UPDATE};
	
	public void put(Employee e, MRVR.LigneTableau ligne){
		ligne.addObserver(this);
		super.put(e,ligne, MAPMRVR.AJOUT);
	}
	
	public void remove(Employee e){
		super.remove(e, MAPMRVR.DEL);
	}

	/**
	 * The instance watches for its components'updates and warns its controllers.
	 */
	@Override
	public void update(Observable arg0, Object message) {
		if(message instanceof LIGNEMRVR && (LIGNEMRVR)message == LIGNEMRVR.MODIF){
			this.setChanged();
			this.notifyObservers(MAPMRVR.UPDATE);
		}
	}
}
