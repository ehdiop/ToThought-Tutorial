package com.xyz.myproject.model.general;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * This class represents the expenditures of subcontracting for a year. It links
 * a subcontractor with the amount of money it was given in a year. This
 * information is required for Rd-222.
 * 
 * @author Raoul
 * 
 */

@javax.persistence.Entity
@Table(name = "sous_traitant_ac")
public class SousTraitanceRD extends SousTraitanceGenerale implements
		java.io.Serializable {
	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1144696571L;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sous_traitance_ac_id")
	private Long id;

	/**
	 * @generated
	 */
	public String toString() {
		return "SousTraitanceRD" + " id=" + id;
	}

	/**
	 * @generated
	 */

	public Long getId() {
		return this.id;
	}

	/**
	 * @generated
	 */
	public void setId(Long id) {
		this.id = id;
	}

}