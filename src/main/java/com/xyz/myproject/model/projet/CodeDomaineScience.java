package com.xyz.myproject.model.projet;

import java.util.Vector;

/**
 * Code du domaine et de la science, demandé dans les informations générales du projet.
 */
public class CodeDomaineScience implements java.io.Serializable {

	private CodeCodeDomaineScience code;
	/**
	 * @generated
	 */
	private String domaineGeneral;
	/**
	 * @generated
	 */
	private String sousDomaine;

	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1745219958L;

	/**
	 * @generated
	 */
	public CodeDomaineScience() {
		this(new CodeCodeDomaineScience(0, 0, 0), "", "");
	}

	public CodeDomaineScience(CodeCodeDomaineScience code,
			String domaineGeneral, String sousDomaine) {
		this.code = new CodeCodeDomaineScience(code.getPremier(),
				code.getSecond(), code.getTroisieme());
		this.domaineGeneral = domaineGeneral;
		this.sousDomaine = sousDomaine;
	}

	public String getDomaineGeneral() {
		return domaineGeneral;
	}

	public void setDomaineGeneral(String domaineGeneral) {
		this.domaineGeneral = domaineGeneral;
	}

	public String getSousDomaine() {
		return sousDomaine;
	}

	public void setSousDomaine(String sousDomaine) {
		this.sousDomaine = sousDomaine;
	}

	public CodeCodeDomaineScience getCode() {
		return code;
	}

	public void setCode(CodeCodeDomaineScience code) {
		this.code = code;
	}

	public static Vector<CodeDomaineScience> values() {
		Vector<CodeDomaineScience> list = new Vector<CodeDomaineScience>();
		CodeCodeDomaineScience code = new CodeCodeDomaineScience(1, 1, 1);
		String mathDomaine = "Mathématiques";
		list.add(new CodeDomaineScience(code, mathDomaine,
				"Mathématiques pures"));
		code.incTroisieme();
		list.add(new CodeDomaineScience(code, mathDomaine,
				"Mathématiques appliquées"));
		code.incTroisieme();
		list.add(new CodeDomaineScience(code, mathDomaine,
				"Statistiques et probabilités"));
		return list;
	}

	@Override
	public String toString() {
		return this.code + " " + this.getSousDomaine();
	}

	public enum ScienceOuTechno {
		SCIENCE("1. Sciences exactes et naturelles"), TECHNO(
				"2. Génie et technologie");

		private String value;

		private ScienceOuTechno(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof CodeDomaineScience)
				&& ((CodeDomaineScience) obj).getCode().equals(this.code);
	}

}