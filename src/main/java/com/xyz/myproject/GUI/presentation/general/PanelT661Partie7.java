package com.xyz.myproject.GUI.presentation.general;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xyz.myproject.GUI.presentation.PARAMETERS_IHM;
import com.xyz.myproject.GUI.presentation.general.DialogT661.PanelOnglet;
import com.xyz.myproject.GUI.presentation.general.SpecialTextFields.PercentTextField;
import com.xyz.myproject.GUI.presentation.general.SpecialTextFields.SizedTextFieldInt;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.T661Partie7;

/**
 * Onglet partie 7 de la fenêtre de dialogue du formulaire T661
 * 
 * @author Raoul
 * 
 */
@SuppressWarnings("serial")
public class PanelT661Partie7 extends PanelOnglet {

	private PercentTextField financemtIntField, steMeresFieldCan,
			subventionsField, contratsFedField, financemtProvField,
			contratsAutresEntFieldCan, autresFinancemtFieldCan;
	private PercentTextField steMeresFieldEtr, contratsAutresEntFieldEtr,
			autresFinancemtFieldEtr;
	private SizedTextFieldInt scientField, techField, gestionField,
			autresEmployesField;
	private JLabel sourcesCan, sourcesEtr, l605;
	private GridBagConstraints cons;

	private JPanel panel;
	private Model model;

	public PanelT661Partie7(Model model) {
		this.model = model;

		this.buildTableau();
		this.fillWith();

	}

	private void buildTableau() {
		panel = new JPanel(new GridBagLayout());
		panelCentral.add(panel);

		sourcesCan = new JLabel("<html>Sources<br> canadiennes (%)<html>");
		sourcesEtr = new JLabel("<html>Sources<br> étrangères (%)<html>");
		l605 = new JLabel("rien pour l'instant");

		JLabel titreLab = new JLabel(
				"Dépenses pour la RS&DE que vous avez faites au Canada");
		JLabel legendeLab = new JLabel(
				"<html>En fonction du total inscrit à la ligne 605, estimez en pourcentage la<br> provenance du financement de la RS&DE effectuée dans votre<br> organisation.<html>");
		JLabel financemtIntLab = new JLabel("Financement interne");
		JLabel steMeresLab = new JLabel(
				"Société mères, filiales et sociétés affiliées");
		JLabel subventionsLab = new JLabel(
				"<html>Subventions fédérales (n'incluez pas les fonds ou les crédits d'impôt<br> obtenus comme encouragements fiscaux à la RS&DE)<html>");
		JLabel contratsFedLab = new JLabel("Contrats fédéraux");
		JLabel financemtProvLab = new JLabel("Financement provincial");
		JLabel contratsAutresEntLab = new JLabel(
				"Contrats de RS&DE effectuée pour le compte d'autres entreprises");
		JLabel autresFinancemtLab = new JLabel(
				"Autre financement (p. ex. universités, gouvernements étrangers)");
		JLabel nbEmployes = new JLabel(
				"Inscrivez le nombre d'employés de RS&DE:");
		JLabel scientLab = new JLabel("Scientifiques et ingénieurs");
		JLabel technLab = new JLabel("Technologues et techniciens");
		JLabel gestionLab = new JLabel("Gestionnaires et administrateurs");
		JLabel autresEmployes = new JLabel(
				"Autres employés de soutien technique");
		ArrayList<JLabel> listeLabel = new ArrayList<JLabel>();
		listeLabel.add(titreLab);
		listeLabel.add(legendeLab);
		listeLabel.add(financemtIntLab);
		listeLabel.add(steMeresLab);
		listeLabel.add(subventionsLab);
		listeLabel.add(contratsFedLab);
		listeLabel.add(financemtProvLab);
		listeLabel.add(contratsAutresEntLab);
		listeLabel.add(autresFinancemtLab);
		listeLabel.add(nbEmployes);
		listeLabel.add(scientLab);
		listeLabel.add(technLab);
		listeLabel.add(gestionLab);
		listeLabel.add(autresEmployes);

		financemtIntField = new PercentTextField();
		steMeresFieldCan = new PercentTextField();
		subventionsField = new PercentTextField();
		contratsFedField = new PercentTextField();
		financemtProvField = new PercentTextField();
		contratsAutresEntFieldCan = new PercentTextField();
		autresFinancemtFieldCan = new PercentTextField();
		ArrayList<JTextField> listeFieldCan = new ArrayList<JTextField>();
		listeFieldCan.add(financemtIntField);
		listeFieldCan.add(steMeresFieldCan);
		listeFieldCan.add(subventionsField);
		listeFieldCan.add(contratsFedField);
		listeFieldCan.add(financemtProvField);
		listeFieldCan.add(contratsAutresEntFieldCan);
		listeFieldCan.add(autresFinancemtFieldCan);

		steMeresFieldEtr = new PercentTextField();
		contratsAutresEntFieldEtr = new PercentTextField();
		autresFinancemtFieldEtr = new PercentTextField();
		scientField = new SizedTextFieldInt();
		techField = new SizedTextFieldInt();
		gestionField = new SizedTextFieldInt();
		autresEmployesField = new SizedTextFieldInt();

		this.buildColGauche(listeLabel);
		this.buildColMilieu(listeFieldCan);
		this.buildColDroite();

	}

	private void buildColGauche(List<JLabel> list) {
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = -1;
		cons.weightx = 0;
		cons.insets = new Insets(0, 0, PARAMETERS_IHM.mesure,
				PARAMETERS_IHM.mesure);
		cons.anchor = GridBagConstraints.LINE_START;

		for (JLabel label : list) {
			cons.gridy++;
			panel.add(label, cons);
		}
	}

	private void buildColMilieu(ArrayList<JTextField> liste) {
		cons.gridx = 1;
		cons.gridy = 0;
		panel.add(Box.createGlue(), cons);
		cons.gridy++;
		panel.add(sourcesCan, cons);
		for (JTextField textField : liste) {
			cons.gridy++;
			panel.add(textField, cons);
		}
	}

	private void buildColDroite() {
		cons.gridx = 2;
		cons.gridy = 0;
		cons.weightx = 1;
		panel.add(l605, cons);
		cons.gridy++;
		panel.add(sourcesEtr, cons);
		cons.gridy++;
		panel.add(Box.createGlue(), cons);
		cons.gridy++;
		panel.add(steMeresFieldEtr, cons);
		for (int i = 0; i < 3; i++) {
			cons.gridy++;
			panel.add(Box.createGlue(), cons);
		}
		cons.gridy++;
		panel.add(contratsAutresEntFieldEtr, cons);
		cons.gridy++;
		panel.add(autresFinancemtFieldEtr, cons);
		cons.gridy++;
		panel.add(Box.createGlue(), cons);
		cons.gridy++;
		panel.add(scientField, cons);
		cons.gridy++;
		panel.add(gestionField, cons);
		cons.gridy++;
		panel.add(techField, cons);
		cons.gridy++;
		panel.add(autresEmployesField, cons);

	}

	public void fillWith() {
		T661Partie7 tsis = model.getDossierAnnee().getT661().getPartie7();
		financemtIntField.setText("" + tsis.getFinancemtInt());
		steMeresFieldCan.setText("" + tsis.getSteMeresCan());
		subventionsField.setText("" + tsis.getSubventions());
		contratsFedField.setText("" + tsis.getContratsFed());
		financemtProvField.setText("" + tsis.getFinancemtProv());
		contratsAutresEntFieldCan.setText("" + tsis.getContratsAutresEntCan());
		autresFinancemtFieldCan.setText("" + tsis.getAutresFinancemtCan());

		steMeresFieldEtr.setText("" + tsis.getSteMeresEtr());
		contratsAutresEntFieldEtr.setText("" + tsis.getContratsAutresEntdEtr());
		autresFinancemtFieldEtr.setText("" + tsis.getAutresFinancemtdEtr());
		scientField.setText("" + tsis.getScientifiques());
		techField.setText("" + tsis.getTechniques());
		gestionField.setText("" + tsis.getGestionnaires());
		autresEmployesField.setText("" + tsis.getAutresEmployes());
	}

	public void onClick() {
		T661Partie7 tsis = model.getDossierAnnee().getT661().getPartie7();
		tsis.setFinancemtInt(Double.parseDouble(financemtIntField.getText()));
		tsis.setSteMeresCan(Double.parseDouble(steMeresFieldCan.getText()));
		tsis.setSubventions(Double.parseDouble(subventionsField.getText()));
		tsis.setContratsFed(Double.parseDouble(contratsFedField.getText()));
		tsis.setFinancemtProv(Double.parseDouble(financemtProvField.getText()));
		tsis.setContratsAutresEntCan(Double
				.parseDouble(contratsAutresEntFieldCan.getText()));
		tsis.setAutresFinancemtCan(Double.parseDouble(autresFinancemtFieldCan
				.getText()));

		tsis.setSteMeresEtr(Double.parseDouble(steMeresFieldEtr.getText()));
		tsis.setContratsAutresEntdEtr(Double
				.parseDouble(contratsAutresEntFieldEtr.getText()));
		tsis.setAutresFinancemtdEtr(Double.parseDouble(autresFinancemtFieldEtr
				.getText()));
		tsis.setScientifiques(scientField.getIntValue());
		tsis.setTechniques(techField.getIntValue());
		tsis.setGestionnaires(gestionField.getIntValue());
		tsis.setAutresEmployes(autresEmployesField.getIntValue());

	}

}
