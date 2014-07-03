package com.xyz.myproject.model.general;

import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.xyz.myproject.model.exceptions.NEException;

/**
 * Un sous-traitant.
 */
@Table(name = "sous_traitant")
public class SousTraitant implements java.io.Serializable {

	private String adresse;

	private String ville;

	private Province province;

	private CodePostal cp;

	private TypeST type;
	
	private TypeEntite typeEntite;

	private boolean dep;

	private String nom;

	private String description;

	private static final long serialVersionUID = -1076067179L;


	private Long id;
	
	private UUID uuid;

	private NumeroEntreprise ne;

	private NumeroIdProv numProv;

	private NEQ neq;

	public SousTraitant() {
	}

	public SousTraitant(String nom, String description, String adresse,
			String ville, Province province, CodePostal cp,
			TypeST type, TypeEntite typeEntite, boolean dep, NumeroEntreprise ne,
			NumeroIdProv numProv, NEQ neq) {
		super();
		this.uuid=UUID.randomUUID();
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.ville = ville;
		this.province = province;
		this.cp = cp;
		this.type = type;
		if(type == TypeST.ENTITE){
			this.typeEntite=typeEntite;
		}
		this.dep = dep;
		this.ne = ne;
		this.numProv = numProv;
		this.neq = neq;
	}

	public SousTraitant(String nom, String description, String adresse,
			String ville, Province province, String cp, TypeST type, TypeEntite typeEntite,
			boolean dep, String ne, String numProv, String neq)
			throws NEException {
		this(nom, description, adresse, ville, province, new CodePostal(cp),
				type, typeEntite, dep, new NumeroEntreprise(ne), new NumeroIdProv(numProv),
				new NEQ(neq));

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "sous_traitant_adresse")
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * @generated
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "sous_traitant_ville")
	public String getVille() {
		return this.ville;
	}

	/**
	 * @generated
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column(name = "sous_traitant_province")
	@Type(type = "com.xyz.myproject.bdd.enums.ProvinceUserType")
	public Province getProvince() {
		return this.province;
	}

	/**
	 * @generated
	 */
	public void setProvince(Province province) {
		this.province = province;
	}

	@Embedded
	@AttributeOverride(name = "cp_value", column = @Column(name = "sous_traitant_cp"))
	public CodePostal getCp() {
		return this.cp;
	}

	/**
	 * @generated
	 */
	public void setCp(CodePostal cp) {
		this.cp = cp;
	}

	@Type(type = "com.xyz.myproject.bdd.enums.TypeSoutUserType")
	@Column(name = "sous_traitant_type")
	public TypeST getType() {
		return this.type;
	}

	/**
	 * @generated
	 */
	public void setType(TypeST type) {
		this.type = type;
	}

	@Column(name = "sous_traitant_dep")
	public boolean isDep() {
		return this.dep;
	}

	/**
	 * @generated
	 */
	public void setDep(boolean dep) {
		this.dep = dep;
	}

	/**
	 * @generated
	 */
	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	public Long getId() {
		return this.id;
	}

	/**
	 * @generated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @generated
	 */
	public String toString() {
		return this.nom;
	}

	@Embedded
	@AttributeOverride(name = "ne", column = @Column(name = "sous_traitant_NE"))
	public NumeroEntreprise getNe() {
		return this.ne;
	}

	/**
	 * @generated
	 */
	public void setNe(NumeroEntreprise ne) {
		this.ne = ne;
	}

	@Embedded
	@AttributeOverride(name = "numProv", column = @Column(name = "sous_traitant_prov"))
	public NumeroIdProv getNumProv() {
		return this.numProv;
	}

	/**
	 * @generated
	 */
	public void setNumProv(NumeroIdProv numProv) {
		this.numProv = numProv;
	}

	@Embedded
	@AttributeOverride(name = "neq", column = @Column(name = "sous_traitant_queb"))
	public NEQ getNeq() {
		return this.neq;
	}

	/**
	 * @generated
	 */
	public void setNeq(NEQ neq) {
		this.neq = neq;
	}
	
	

	public UUID getUuid() {
		return uuid;
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof SousTraitant)
				&& ((SousTraitant) o).getUuid() == this.getUuid();
	}

	@Override
	public int hashCode() {
		//Long.valueOf(this.id).hashCode();
		return uuid.hashCode();
	}
}