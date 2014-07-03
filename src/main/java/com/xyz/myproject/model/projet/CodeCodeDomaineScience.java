package com.xyz.myproject.model.projet;

/**
 * Représente le code chiffré de l'objet CodeDomaineScience, qui représente les
 * informations liées à un code de domaine de la science ou de la technologie
 * 
 * @author Raoul
 * 
 */
public class CodeCodeDomaineScience {
	/**
	 * Les chiffres du code
	 */
	private int premier;
	private int second;
	private int troisieme;

	public CodeCodeDomaineScience(int premier, int second, int troisieme) {
		super();
		this.premier = premier;
		this.second = second;
		this.troisieme = troisieme;
	}

	public void incPremier() {
		this.premier++;
	}

	public void incSecond() {
		this.second++;
	}

	public void incTroisieme() {
		this.troisieme++;
	}

	public int getPremier() {
		return premier;
	}

	public void setPremier(int premier) {
		this.premier = premier;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getTroisieme() {
		return troisieme;
	}

	public void setTroisieme(int troisieme) {
		this.troisieme = troisieme;
	}

	@Override
	public String toString() {
		String toRet = "";
		if (this.premier != 0) {
			toRet = premier + "." + ((second > 9) ? 0 : "") + second + "."
					+ ((troisieme > 9) ? 0 : "") + troisieme;
		}
		return toRet;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof CodeCodeDomaineScience)
				&& ((CodeCodeDomaineScience) obj).getPremier() == this
						.getPremier()
				&& ((CodeCodeDomaineScience) obj).getSecond() == this
						.getSecond()
				&& ((CodeCodeDomaineScience) obj).getTroisieme() == this
						.getTroisieme();
	}

}
