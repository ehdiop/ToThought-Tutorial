package com.xyz.myproject.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Format d'affichage des calendriers (JDateChooser)
 * @author Raoul
 *
 */
public class CalendarLib {

	public static String display(Calendar calendar){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(calendar.getTime());
	}
	
	
}
