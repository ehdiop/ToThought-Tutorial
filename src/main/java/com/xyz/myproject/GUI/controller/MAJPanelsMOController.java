package com.xyz.myproject.GUI.controller;

import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.GUI.presentation.MainFrameDossier;
import com.xyz.myproject.GUI.presentation.general.PanelFraisGeneraux;
import com.xyz.myproject.GUI.presentation.general.PanelMO;
import com.xyz.myproject.GUI.presentation.general.PanelMRVR;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.general.MethodeCalcul;

/**
 * Lorsque dossierAnnee change, ce controller met à jour les onglets avec de nouveaux panels.
 * @author Raoul
 *
 */
public class MAJPanelsMOController implements Observer {

	private Model model;
	private MainFrameDossier window;

	public MAJPanelsMOController(Model model,
			MainFrameDossier window) {
		super();
		this.model = model;
		this.window = window;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == Model.MODEL.DOSSIERANNEE) {
			PanelMO panelMo = new PanelMO(this.window,this.model.getDossierAnnee());
			panelMo.fillWith();
			this.window.setPanelMO(panelMo);
			if(this.model.getAnnee().getMethod()==MethodeCalcul.REMPLACEMENT){
				this.window.setPanelMRVR(new PanelMRVR(this.model));
			}
			else{
				this.window.setPanelFraisGen(new PanelFraisGeneraux(model));
			}
			this.window.repaint();
		
		}

	}

}
