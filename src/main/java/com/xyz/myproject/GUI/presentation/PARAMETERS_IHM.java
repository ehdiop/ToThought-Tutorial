package com.xyz.myproject.GUI.presentation;

import java.awt.Dimension;
import java.awt.Font;

/**
 * Les quelques mesures communes utilisées par l'IHM.
 * @author Raoul
 *
 */
public class PARAMETERS_IHM {

	public static final Dimension dimensionTextField = new Dimension(200, 20);
	public static final Dimension dimensionSmallTextField = new Dimension(100,
			20);

	public static final String dateFormat = "dd/MM/yyyy";

	public static final Font font = new Font("Arial", Font.BOLD, 14);

	public static final String formatException = "Les champs remplis doivent être des chiffres," +
			" éventuellement décimaux (Dans ce dernier cas, utilisation du point et non de la virgule).";
	public static final int mesure = 10;
}
