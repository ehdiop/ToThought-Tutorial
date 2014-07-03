package com.xyz.myproject.GUI.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.GUI.presentation.projet.AddDepenseST;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.projet.DepenseSousTraitance;
import com.xyz.myproject.model.projet.DepensesSousTraitance;

/**
 * Controller abstrait et g�n�rique du bouton valider lors de l'ajout d'une
 * d�pense de sous-traitance. Si une d�pense a d�j� �t� ajout�e pour ce
 * sous-traitant, un message est affich� pour proposer d'�craser la d�pense
 * pr�c�dente.
 * 
 * @author Raoul
 * 
 * @param <E>
 *            : �tend DepenseSousTraitance. DepenseST_RD ou DepenseST_Soutien
 */
public abstract class AddDepenseSTController<E extends DepenseSousTraitance>
		implements ActionListener {

	protected Model model;
	protected AddDepenseST dialog;

	public AddDepenseSTController(Model model, AddDepenseST dialog) {
		super();
		this.model = model;
		this.dialog = dialog;
	}

	public abstract DepensesSousTraitance<E> getDepensesST();
	
	public abstract void setDepense(E dep);

	public abstract E getInstance(double montant, SousTraitant st);

	protected boolean alreadyExists() {
		int choix = JOptionPane.showConfirmDialog(dialog,
				"Une d�pense de sous traitance a d�j� �t� ajout�e pour ce sous traitant."
						+ (char) 10 + "Ecraser la d�pense pr�c�dente ?",
				"Avertissement", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		return choix == JOptionPane.YES_OPTION;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		boolean alreadyExist = false;
		SousTraitant st = (SousTraitant) dialog.getStCombo().getSelectedItem();
		try {
			double montant = Double.parseDouble(dialog.getMontantField()
					.getText());
			alreadyExist = this.getDepensesST().get(st) != null;
			boolean dispose = true;
			
			if (alreadyExist) {
				dispose = this.alreadyExists();
			}

			if (dispose) {
				this.setDepense(this.getInstance(montant, st));
				dialog.dispose();
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(dialog,
					PARAMETERS_IHM.formatException, "probl�me de format",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
