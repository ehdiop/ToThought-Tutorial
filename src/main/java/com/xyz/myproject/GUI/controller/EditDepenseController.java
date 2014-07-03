package com.xyz.myproject.GUI.controller;

import java.awt.Window;

import javax.swing.JTable;

import com.xyz.myproject.GUI.presentation.projet.AddDepenseDialog;
import com.xyz.myproject.GUI.presentation.projet.AddDepenseDialogMO;
import com.xyz.myproject.GUI.presentation.projet.AddDepenseDialogSimple;
import com.xyz.myproject.GUI.presentation.projet.AddSTDepRDDialog;
import com.xyz.myproject.GUI.presentation.projet.AddSTDepSoutienDialog;
import com.xyz.myproject.GUI.presentation.tabmodels.DepensesModel;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.DepenseAbstract;
import com.xyz.myproject.model.projet.DepenseST_RD;
import com.xyz.myproject.model.projet.DepenseST_Soutien;
import com.xyz.myproject.model.projet.DepensesSousTraitance;
import com.xyz.myproject.model.projet.Equipement50;
import com.xyz.myproject.model.projet.Equipement90;
import com.xyz.myproject.model.projet.Location50;
import com.xyz.myproject.model.projet.Location90;
import com.xyz.myproject.model.projet.MaterielConsomme;
import com.xyz.myproject.model.projet.MaterielTransforme;
import com.xyz.myproject.model.projet.TSProjetCanada;

/**
 * Controller ouvrant la bonne boite de dialogue lors d'un double clic sur la
 * JTable des dépenses dans l'onglet projet
 * 
 * @author Raoul
 * 
 */
public class EditDepenseController extends EditEController<AddDepenseDialog<?>> {

	private Model model;

	public EditDepenseController(Window owner, JTable table, Model model) {
		super(owner, table);
		this.model = model;
	}

	@Override
	protected AddDepenseDialog<?> getInstance() {
		int row = table.getSelectedRow();
		Class<?> classe = ((DepensesModel) (this.table.getModel()))
				.getRowClass(row);
		DepenseAbstract depense = ((DepensesModel) (table.getModel()))
				.getDepense(row);
		String nomDepense = ((DepensesModel) this.table.getModel())
				.getNomDepense(row);
		if (classe == TSProjetCanada.class) {
			AddDepenseDialogMO addDepenseDialogMO = new AddDepenseDialogMO(
					nomDepense, (TSProjetCanada) depense, this.model);
			addDepenseDialogMO.fillWith();
			return addDepenseDialogMO;
		} else {
			if (classe == MaterielConsomme.class) {
				return null;
			} else {
				if (classe == MaterielTransforme.class) {
					return null;
				} else {
					if (classe == DepenseST_RD.class) {
						return new AddSTDepRDDialog(nomDepense,
								(DepensesSousTraitance<DepenseST_RD>) depense,
								this.owner, model);
					} else {
						if (classe == DepenseST_Soutien.class) {
							return new AddSTDepSoutienDialog(
									nomDepense,
									(DepensesSousTraitance<DepenseST_Soutien>) depense,
									this.owner, model);
						} else {
							if (classe == Location50.class) {
								return null;
							} else {
								if (classe == Location90.class) {
									return null;
								} else {
									if (classe == Equipement50.class) {
										return null;
									} else {
										if (classe == Equipement90.class) {
											return null;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	protected void fillField(AddDepenseDialog<?> dialog) {
		if (dialog instanceof AddDepenseDialogSimple<?>) {
			((AddDepenseDialogSimple<?>) dialog).setMontantField(dialog
					.getDepense().getMontant());
		} else {

		}
	}
}
