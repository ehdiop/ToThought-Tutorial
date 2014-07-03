package com.xyz.myproject.model.general;

import com.xyz.myproject.model.Model;
/**
 * Modélisation de la partie 7 du T661
 * @author Raoul
 *
 */
public class T661Partie7 {

	private int scientifiques, techniques, gestionnaires, autresEmployes;

	private double financemtInt, steMeresCan, subventions, contratsFed,
			financemtProv, contratsAutresEntCan, autresFinancemtCan;
	
	private double steMeresEtr, contratsAutresEntdEtr,	autresFinancemtdEtr;
	private Model model;

	public T661Partie7(int scientifiques, int techniques, int gestionnaires,
			int autresEmployes, double financemtInt, double steMeresCan,
			double subventions, double contratsFed, double financemtProv,
			double contratsAutresEntCan, double autresFinancemtCan,
			double steMeresEtr, double contratsAutresEntdEtr,
			double autresFinancemtdEtr) {
		super();
		this.scientifiques = scientifiques;
		this.techniques = techniques;
		this.gestionnaires = gestionnaires;
		this.autresEmployes = autresEmployes;
		this.financemtInt = financemtInt;
		this.steMeresCan = steMeresCan;
		this.subventions = subventions;
		this.contratsFed = contratsFed;
		this.financemtProv = financemtProv;
		this.contratsAutresEntCan = contratsAutresEntCan;
		this.autresFinancemtCan = autresFinancemtCan;
		this.steMeresEtr = steMeresEtr;
		this.contratsAutresEntdEtr = contratsAutresEntdEtr;
		this.autresFinancemtdEtr = autresFinancemtdEtr;
	}
	
	public T661Partie7() {
	}

	public int getScientifiques() {
		return scientifiques;
	}

	public void setScientifiques(int scientifiques) {
		this.scientifiques = scientifiques;
	}

	public int getTechniques() {
		return techniques;
	}

	public void setTechniques(int techniques) {
		this.techniques = techniques;
	}

	public int getGestionnaires() {
		return gestionnaires;
	}

	public void setGestionnaires(int gestionnaires) {
		this.gestionnaires = gestionnaires;
	}

	public int getAutresEmployes() {
		return autresEmployes;
	}

	public void setAutresEmployes(int autresEmployes) {
		this.autresEmployes = autresEmployes;
	}

	public double getFinancemtInt() {
		return financemtInt;
	}

	public void setFinancemtInt(double financemtInt) {
		this.financemtInt = financemtInt;
	}

	public double getSteMeresCan() {
		return steMeresCan;
	}

	public void setSteMeresCan(double steMeresCan) {
		this.steMeresCan = steMeresCan;
	}

	public double getSubventions() {
		return subventions;
	}

	public void setSubventions(double subventions) {
		this.subventions = subventions;
	}

	public double getContratsFed() {
		return contratsFed;
	}

	public void setContratsFed(double contratsFed) {
		this.contratsFed = contratsFed;
	}

	public double getFinancemtProv() {
		return financemtProv;
	}

	public void setFinancemtProv(double financemtProv) {
		this.financemtProv = financemtProv;
	}

	public double getContratsAutresEntCan() {
		return contratsAutresEntCan;
	}

	public void setContratsAutresEntCan(double contratsAutresEntCan) {
		this.contratsAutresEntCan = contratsAutresEntCan;
	}

	public double getAutresFinancemtCan() {
		return autresFinancemtCan;
	}

	public void setAutresFinancemtCan(double autresFinancemtCan) {
		this.autresFinancemtCan = autresFinancemtCan;
	}

	public double getSteMeresEtr() {
		return steMeresEtr;
	}

	public void setSteMeresEtr(double steMeresEtr) {
		this.steMeresEtr = steMeresEtr;
	}

	public double getContratsAutresEntdEtr() {
		return contratsAutresEntdEtr;
	}

	public void setContratsAutresEntdEtr(double contratsAutresEntdEtr) {
		this.contratsAutresEntdEtr = contratsAutresEntdEtr;
	}

	public double getAutresFinancemtdEtr() {
		return autresFinancemtdEtr;
	}

	public void setAutresFinancemtdEtr(double autresFinancemtdEtr) {
		this.autresFinancemtdEtr = autresFinancemtdEtr;
	}
	
	

}
