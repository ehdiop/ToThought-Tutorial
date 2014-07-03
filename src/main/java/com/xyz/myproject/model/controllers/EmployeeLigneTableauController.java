package com.xyz.myproject.model.controllers;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.ListeEmployee;
import com.xyz.myproject.model.general.ListeEmployee.EMPLOYEE;
import com.xyz.myproject.model.general.MRVR;
import com.xyz.myproject.model.general.MapLigneMRVR;
import com.xyz.myproject.model.projet.Employee;

/**
 * Ce controleur met à jour les valeurs de MRVR.LigneTableau avec les nouvelles
 * valeurs des employés lors de l'ajout d'un employé
 * 
 * @author Raoul
 * 
 */
public class EmployeeLigneTableauController implements Observer {

	private MapLigneMRVR tableauMRVRCa,tableauMRVREtr;
	private ListeEmployee listeEmployes;
	private Annee annee;

	public EmployeeLigneTableauController(
			MapLigneMRVR tableauMRVRCa, MapLigneMRVR tableauMRVREtr, ListeEmployee liste, Annee annee) {
		super();
		this.tableauMRVRCa = tableauMRVRCa;
		this.tableauMRVREtr=tableauMRVREtr;
		this.listeEmployes = liste;
		this.annee=annee;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		EMPLOYEE message = (EMPLOYEE) arg1;

		if (message == EMPLOYEE.ADD) {
			this.add();
		} else {
			if (message == EMPLOYEE.DEL) {
				this.delete();
			}
		}
	}
	
	public void delete(){
		for(Employee e:this.tableauMRVRCa.keySet()){
			if(!this.listeEmployes.contains(e)){
				this.tableauMRVRCa.remove(e);
				this.tableauMRVREtr.remove(e);
			}
		}
	}
	
	/**
	 * C'est ici que l'on crée MAJValeurMRVRController, qui met à jour la valeur calculée du mrvr lors
	 * de changement de valeurs des LigneTableau
	 */
	public void add(){
		for(Employee e:this.listeEmployes.getList()){
			if(!this.tableauMRVRCa.keySet().contains(e)){
				MRVR.LigneTableau ligneCa = new MRVR.LigneTableau(e, 0, 0, 365,this.annee);
				
				tableauMRVRCa.put(e, ligneCa);
				MRVR.LigneTableau ligneEtr = new MRVR.LigneTableau(e, 0, 0, 365,this.annee);
			
				tableauMRVREtr.put(e, ligneEtr);
			}
		}
	}

}
