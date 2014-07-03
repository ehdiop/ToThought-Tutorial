package com.xyz.myproject.model.sectionsBC;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Section B : partie de rédaction libre du T661.
 */
@Entity
@Table(name="section_C")
public class SectionC extends DescriptionTechnique {

	public enum SECTIONC{MAJ_QU};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="secC_id")
	private long id;

	@Embedded
	@AttributeOverride(name="texte", column=@Column(name="secC_avencmt"))
	private Question question1;

	private static int maxQuestion1 = 350;

	@Embedded
	@AttributeOverride(name="texte", column=@Column(name="secC_travaux"))
	private Question question2;

	private static int maxQuestion2 = 700;

	public SectionC() {
		this.question1 = new Question(maxQuestion1);
		this.question2 = new Question(maxQuestion2);
	}
	
	public SectionC(String avancement, String travaux){
		this();
		this.setQuestion1(avancement);
		this.setQuestion2(travaux);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Question getQuestion1() {
		return question1;
	}

	public Question getQuestion2() {
		return question2;
	}

	public boolean setQuestion1(String question) {
		boolean toret=this.question1.setTexte(question);
		this.setChanged();
		this.notifyObservers(SECTIONC.MAJ_QU);
		return toret;
	}

	public boolean setQuestion2(String question) {
		boolean toret =this.question2.setTexte(question);
		this.setChanged();
		this.notifyObservers(SECTIONC.MAJ_QU);
		return toret;
	}

	/**
	 * @generated
	 */
	public String toString() {
		return "SectionC" + " question1=" + question1 + " question2="
				+ question2;
	}
}