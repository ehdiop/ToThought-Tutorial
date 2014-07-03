package com.xyz.myproject.model.sectionsBC;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
@Table(name = "section_B")
public class SectionB extends DescriptionTechnique {

	
	public enum SECTIONB{MAJ_QU};
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "creation_materiaux", column = @Column(name = "secB_crea_mater")),
			@AttributeOverride(name = "creation_procedes", column = @Column(name = "secB_crea_proc")),
			@AttributeOverride(name = "amelioration_procedes", column = @Column(name = "secB_am_proc")),
			@AttributeOverride(name = "amelioration_materiaux", column = @Column(name = "secB_am_mater"))

	})
	private TableauSecB tableau;

	@Embedded
	@AttributeOverride(name = "texte", column = @Column(name = "secB_pt_realises"))
	private Question progresTech;
	private static int maxProgresTech = 350;

	@Embedded
	@AttributeOverride(name = "texte", column = @Column(name = "secB_obstacles"))
	private Question obstaclesTech;
	private static int maxObstacleTech = 350;

	@Embedded
	@AttributeOverride(name = "texte", column = @Column(name = "secB_surmont"))
	private Question travaux;
	private static int maxTravaux = 700;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "secB_id")
	private long id;

	public SectionB() {
		this.progresTech = new Question(maxProgresTech);
		this.obstaclesTech = new Question(maxObstacleTech);
		this.travaux = new Question(maxTravaux);
		this.tableau = new TableauSecB();
	}

	public SectionB(String progresTech, String obstaclesTech, String travaux)
			{
		this();
		this.setProgresTech(progresTech);
		this.setObstaclesTech(obstaclesTech);
		this.setTravaux(travaux);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Question getProgresTech() {
		return progresTech;
	}

	public Question getObstaclesTech() {
		return obstaclesTech;
	}

	public Question getTravaux() {
		return travaux;
	}

	public boolean setTravaux(String travaux) {
		boolean toRet = this.travaux.setTexte(travaux);
		this.setChanged();
		this.notifyObservers(SECTIONB.MAJ_QU);
		return toRet;
		
	}

	public boolean setObstaclesTech(String obstacles)
			 {
		boolean toRet = this.obstaclesTech.setTexte(obstacles);
		this.setChanged();
		this.notifyObservers(SECTIONB.MAJ_QU);
		return toRet;
	}

	public boolean setProgresTech(String progres) {
		boolean toRet = this.progresTech.setTexte(progres);
		this.setChanged();
		this.notifyObservers(SECTIONB.MAJ_QU);
		return toRet;
	}

	public String toString() {
		return "SectionB" + " progresTech=" + progresTech + " obstaclesTech="
				+ obstaclesTech + " travaux=" + travaux;
	}
	
	
}