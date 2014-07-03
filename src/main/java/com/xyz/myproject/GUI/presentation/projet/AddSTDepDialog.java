package com.xyz.myproject.GUI.presentation.projet;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.xyz.myproject.GUI.controller.AddEController;
import com.xyz.myproject.GUI.controller.MAJTabDepST;
import com.xyz.myproject.GUI.presentation.tabmodels.DepenseSTModel;
import com.xyz.myproject.model.Model;
import com.xyz.myproject.model.projet.DepenseAbstract;
import com.xyz.myproject.model.projet.DepenseSousTraitance;
import com.xyz.myproject.model.projet.DepensesSousTraitance;
/**
 * La JDialog qui s'ouvre lorsque l'on double clique sur une dépense de type sous-traitance R&D ou
 * sous-traitance soutien dans l'onglet dépense de l'onglet projet. Etend AddDepenseDialog<DepenseAbstract>, 
 * qui généralise le code des JDialog à ouvrir pour l'ajout d'une dépense. 
 * 
 * @author Raoul
 *
 * @param <E> : DepenseST_RD ou DepenseST_SOutien selon que l'on ouvre un JDialog pour une dépense de
 * R&D ou de soutien.
 */
@SuppressWarnings("serial")
public abstract class AddSTDepDialog<E extends DepenseSousTraitance, F extends AddEController<?>> extends AddDepenseDialog<DepenseAbstract>{
	protected Window owner;
	private JPanel panelCentral;
	protected Model model;
	
	public AddSTDepDialog(String titre, DepenseAbstract depense,Window proprio, Model model) {
		super(titre,depense);
		this.model = model;
		this.owner = proprio;
		this.panelCentral = new JPanel();
		this.add(panelCentral);
		this.panelCentral.setLayout(new BoxLayout(panelCentral,BoxLayout.Y_AXIS));
		this.buildPanel();
	}
	
	protected abstract DepensesSousTraitance<E> getInstance();
	
	private DepenseSTModel<E> getAbstractModel(){
		return new DepenseSTModel<E>(this.getInstance());
	}

	private void buildPanel() {
		JPanel panelRd = new JPanel(new BorderLayout());
		this.panelCentral.add(panelRd);
		DepensesSousTraitance<E> depensesST = this.getInstance();
		JTable table = new JTable(getAbstractModel());
		JScrollPane scroll = new JScrollPane(table);
		panelRd.add(scroll);
		JButton ajouter = new JButton("ajouter");
		JPanel wrapper = new JPanel(new FlowLayout());
		wrapper.add(ajouter);
		panelRd.add(wrapper,BorderLayout.SOUTH);
		ajouter.addMouseListener(getController());
		
		//Controller : 
		MAJTabDepST controller = new MAJTabDepST(table);
		depensesST.addObserver(controller);
	}
	
	protected abstract F getController();

	


}
