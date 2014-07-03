package com.xyz.myproject.GUI.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.xyz.myproject.GUI.presentation.exceptions.EmptyField;
import com.xyz.myproject.GUI.presentation.general.AddEmployeeDialog;
import com.xyz.myproject.GUI.presentation.tabmodels.EmployeModelGeneral;
import com.xyz.myproject.model.exceptions.EmailException;
import com.xyz.myproject.model.general.FonctionEnum;
import com.xyz.myproject.model.general.ListeEmployee.EMPLOYEE;
import com.xyz.myproject.model.projet.DossierClient;
import com.xyz.myproject.model.projet.Email;
import com.xyz.myproject.model.projet.Employee;

/**
 * Controller gérant l'ajout d'un employé (appui sur le bouton valider)
 * @author Raoul
 *
 */
public class AddEmployeeValiderController extends MouseAdapter implements
		Observer {

	private JDialog ajoutEmployeDialog;
	private DossierClient dossierClient;
	private boolean edit;
	private JTable table;

	public AddEmployeeValiderController(JDialog ajoutEmployeDialog,
			DossierClient dossierClient, boolean edit, JTable table) {
		super();
		this.table = table;
		this.ajoutEmployeDialog = ajoutEmployeDialog;
		this.dossierClient = dossierClient;
		this.edit = edit;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if ((EMPLOYEE) arg1 == EMPLOYEE.MODIF) {
			((EmployeModelGeneral) table.getModel()).fireTableDataChanged();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		try {
			String nom = ((AddEmployeeDialog) ajoutEmployeDialog).getNomField()
					.getText();
			if (nom == null || nom.replace(" ", "").equals(""))
				throw new EmptyField("nom");
			String prenom = ((AddEmployeeDialog) ajoutEmployeDialog)
					.getPrenomField().getText();
			if (prenom == null || prenom.replace(" ", "").equals(""))
				throw new EmptyField("prénom");
			String qualif = ((AddEmployeeDialog) ajoutEmployeDialog)
					.getQualifArea().getText();
			String courriel = ((AddEmployeeDialog) ajoutEmployeDialog)
					.getCourrielField().getText();
			FonctionEnum fonction = (FonctionEnum) ((AddEmployeeDialog) ajoutEmployeDialog)
					.getFonctionBox().getSelectedItem();
			boolean determine = ((AddEmployeeDialog) ajoutEmployeDialog)
					.getDetermineButton().isSelected();
			Email email = new Email();
			boolean rightEmail = true;
			try {

				email = new Email(courriel);
			} catch (EmailException ex2) {
				int choix = JOptionPane.showConfirmDialog(ajoutEmployeDialog,
						ex2.toString() + "\n Garder ce courriel ?",
						"courriel incorrect", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				rightEmail = (choix == JOptionPane.YES_OPTION);
			} finally {
				if (rightEmail) {
					email.setEmail(courriel);
					Employee employee = new Employee(nom, prenom, fonction,
							qualif, determine, email);
					if (!this.edit) {
						this.dossierClient.getEmployes().add(employee);

					} else {
						this.dossierClient.getEmployes()
								.get(this.table.rowAtPoint(e.getPoint()))
								.setEmployee(employee);
					}
					this.ajoutEmployeDialog.dispose();
				}
			}

		} catch (EmptyField ex) {
			JOptionPane.showMessageDialog(ajoutEmployeDialog, ex.toString(),
					ex.title(), JOptionPane.WARNING_MESSAGE);
		}

	}

}
