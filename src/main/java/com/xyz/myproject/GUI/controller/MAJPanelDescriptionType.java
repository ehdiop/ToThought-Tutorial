package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.GUI.presentation.MainFrameDossier;
import com.xyz.myproject.GUI.presentation.projet.PanelDescrTechDev;
import com.xyz.myproject.GUI.presentation.projet.PanelDescrTechRech;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.ButTravaux;
import com.xyz.myproject.model.projet.InfoGeneralesProjet.INFOSPROJET;
import com.xyz.myproject.model.sectionsBC.SectionB;
import com.xyz.myproject.model.sectionsBC.SectionC;
/**
 * Controller mettant à jour l'ihm avec un nouvel onglet description technique lors de l'instanciation 
 * de la description technique des InfoGeneralesProjet.
 * 
 * @author Raoul
 *
 */
public class MAJPanelDescriptionType implements Observer {

	private Model model;
	private MainFrameDossier mainFrameDossier;

	public MAJPanelDescriptionType(Model model,
			MainFrameDossier mainFrameDossier) {
		super();
		this.model = model;
		this.mainFrameDossier = mainFrameDossier;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == INFOSPROJET.DESC_TECH) {
			if (this.model.getProjet().getInformationsGenerales()
					.getButTravaux() == ButTravaux.DEV_EXP) {

				PanelDescrTechDev panelDescrTechDev = new PanelDescrTechDev(this.model);

				// Controller : mapping modèle-panel
				
				SectionB sectionB = (SectionB) this.model.getProjet().getInformationsGenerales().getDescTech();
				panelDescrTechDev.fillWith(sectionB);
				

				// MAJ du panel description
				this.mainFrameDossier.setPanelDescription(panelDescrTechDev);
			} else {
				PanelDescrTechRech panelDescTechRech = new PanelDescrTechRech(this.model);

				// Controller : mapping modèle-panel

				SectionC sectionC = (SectionC) this.model.getProjet().getInformationsGenerales().getDescTech();
				panelDescTechRech.fillWith(sectionC);

				// MAJ du panel description
				this.mainFrameDossier.setPanelDescription(panelDescTechRech);

			}
		}

	}

}
