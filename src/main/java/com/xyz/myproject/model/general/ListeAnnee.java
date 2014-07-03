package com.xyz.myproject.model.general;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.Vector;

/**
 * Une mod�lisation de la liste d'ann�e utilis�e pour mettre en param�tre de la
 * JComboBox, qui prend un Vector, et surtout trier la liste des ann�es.
 * 
 * @author Raoul
 * 
 */
@SuppressWarnings("serial")
public class ListeAnnee extends Vector<Annee> {

	private static final Comparator<Annee> comparator = new Comparator<Annee>() {
		@Override
		public int compare(Annee o1, Annee o2) {
			int first = o1.getFinChiffre();
			int sec = o2.getFinChiffre();

			return sec - first;
		}
	};

	public ListeAnnee(Set<Annee> keySet) {
		super(keySet);
		Collections.sort(this, comparator);

	}

}
