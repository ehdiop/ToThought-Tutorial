package com.xyz.myproject.model.controllers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.CalendarLib;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.Annee.CHANGE_DATE;

/**
 * The update method of this controller is called when the dates of an Annee instance is changed. It ensures
 * the coherence of the dates (beginning of the year<end of the year), and if not adjusts as follows :
 * if the beginning date is adjusted and that begindate >= endingdate then begindate = endingdate - 1 day
 * if the ending date is adjusted and that begindate >= endingdate then endingdate = begindate + 1 day
 * 
 * @author Raoul
 *
 */
public class AnneeController implements Observer {

	@Override
	public void update(Observable ob, Object o) {
		Annee annee = (Annee) ob;
		if (!annee.timeSequenceOk(annee.getAnnee_date_debut(),
				annee.getAnnee_date_fin())) {
			this.updateDates(o, annee);
		}
	}

	private void updateDates(Object o, Annee a) {
		Calendar updated = null;
		if (o == CHANGE_DATE.CHANGE_BEGINNING || o == CHANGE_DATE.CHANGE_END) {
			if (o == CHANGE_DATE.CHANGE_BEGINNING) {
				updated = a.getAnnee_date_fin();

			} else {
				if (o == CHANGE_DATE.CHANGE_END) {
					updated = a.getAnnee_date_debut();

				}

			}
			CalendarLib.display(updated);
			this.addRightAmount(updated, o, a);
		}

	}

	private void addRightAmount(Calendar updated, Object o, Annee annee) {
		Calendar toUpdate;
		toUpdate = new GregorianCalendar(updated.get(Calendar.YEAR),
				updated.get(Calendar.MONTH), updated.get(Calendar.DAY_OF_MONTH));
		toUpdate.add(Calendar.DAY_OF_MONTH,
				(o == CHANGE_DATE.CHANGE_END) ? 1 : -1);

		if (o == CHANGE_DATE.CHANGE_BEGINNING) {
			annee.setAnnee_date_debut(toUpdate);
		} else {
			if (o == CHANGE_DATE.CHANGE_END) {
				annee.setAnnee_date_fin(toUpdate);
			}
		}
	}

}
