package com.xyz.myproject.GUI.presentation.general;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFormattedTextField;

import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
/**
 * Cette classe regroupe des JTextField sp�ciales, �tendant JFormattedTextField. Elles sont utilis�es pour le
 * formulaire T661 et permettent de v�rifier dynamiquement la coh�rence des valeurs rentr�es (pourcentages inf�rieurs
 * ou �gaux � 1, valeurs enti�res pour les montants en dollar), avant validation. Permet une grosse factorisation
 * de code, plut�t que d'identifier un champ faisant d�faut lors de la validation. 
 * @author Raoul
 *
 */
public class SpecialTextFields {

	public static class MyFormattedTextField extends JFormattedTextField {
		public MyFormattedTextField(NumberFormat numberFormat) {
			super(numberFormat);
			this.setPreferredSize(PARAMETERS_IHM.dimensionSmallTextField);


		}
		
		public MyFormattedTextField(){
			this.setPreferredSize(PARAMETERS_IHM.dimensionSmallTextField);
		}
	}

	public static class PercentTextField extends MyFormattedTextField implements
			PropertyChangeListener {
		public PercentTextField() {
			this.addPropertyChangeListener("value", this);

		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			PercentTextField ftf = (PercentTextField) evt.getSource();
			try {
				double input = Double.parseDouble(ftf.getText());
				if (input <= 1) {
					String formatted = ftf.getFormat().format(input);
					ftf.setText("" + formatted);
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				ftf.setText("0");
			}

		}
		
		public NumberFormat getFormat(){
			DecimalFormat format = (DecimalFormat)DecimalFormat.getInstance(Locale.CANADA_FRENCH);
			format.setMaximumFractionDigits(2);
			DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.CANADA_FRENCH);
			symbols.setDecimalSeparator('.');
			format.setDecimalFormatSymbols(symbols);
			return format;
		}

	}

	public static class SizedTextFieldInt extends MyFormattedTextField {
		public SizedTextFieldInt() {
			super(getFormat());
		}
		
		public static DecimalFormat getFormat(){
		
			DecimalFormat toRet = (DecimalFormat)DecimalFormat.getInstance(Locale.CANADA_FRENCH);
			toRet.setMaximumFractionDigits(0);
			DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.CANADA_FRENCH);
			toRet.setDecimalFormatSymbols(symbols);
			return toRet;
		}
		
		public int getIntValue(){
			String value = this.getText();
			value=value.replace(""+getFormat().getDecimalFormatSymbols().getGroupingSeparator(),"");
			return Integer.parseInt(value);
		}
		
		
	}

}
