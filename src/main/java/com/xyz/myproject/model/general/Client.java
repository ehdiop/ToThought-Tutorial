package com.xyz.myproject.model.general;

import java.util.Observable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.xyz.myproject.model.exceptions.ClientException;
import com.xyz.myproject.model.projet.DossierClient;



/**
 * Modélisation d'un client
 */
@javax.persistence.Entity
@Table(name="client")
public class Client extends Observable implements java.io.Serializable {
	
	public enum CLIENT{MODIF};
	
	@Column(name="client_entreprise")
	private String entreprise;


	@Column(name="client_adresse")
	private String adresse;
	
	@Column(name="client_ville")
	private String ville;
	
	@Column(name="client_province")
	private Province province;

	@Embedded
	@AttributeOverride(name="cp_value", column = @Column(name="client_CP"))
	private CodePostal cp;
	
	
	@Embedded
	@AttributeOverride(name="ne", column=@Column(name="client_NE"))
	private NumeroEntreprise NE;


	@Embedded
	@AttributeOverride(name="numProv", column=@Column(name="client_num_ide_prov"))
	private NumeroIdProv numProv;

	
	private static final long serialVersionUID = -1548551L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id")
	private Long id;

	/**
	 * @generated
	 */
	@Transient
	private DossierClient dossierClient;

	/**
	 * @generated
	 */
	public Client() {
	}

	
	
	public Client(String entreprise, String adresse, String ville,
			Province province, CodePostal cp, NumeroEntreprise nE,
			NumeroIdProv numProv, DossierClient dossierClient) throws ClientException{
		super();
		if(entreprise==null||entreprise.replace(" ", "").equals("")) {
			throw new ClientException("entreprise");
		}
		this.entreprise = entreprise;
		this.adresse = adresse;
		this.ville = ville;
		this.province = province;
		this.cp = cp;
		NE = nE;
		this.numProv = numProv;
		this.dossierClient = dossierClient;
	}

	/**
	 * Copie profonde d'un client. Utile pour un édit.
	 * @param client
	 */
	public void set(Client client){
		this.setEntreprise(client.getEntreprise());
		this.setAdresse(client.getAdresse());
		this.setVille(client.getVille());
		this.setProvince(client.getProvince());
		this.setCp(client.getCp());
		this.setNE(client.getNE());
		this.setChanged();
		this.notifyObservers(CLIENT.MODIF);
		
	}

	public String getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	
	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public Province getProvince() {
		return province;
	}


	public void setProvince(Province province) {
		this.province = province;
	}


	public CodePostal getCp() {
		return cp;
	}


	public void setCp(CodePostal cp) {
		this.cp = cp;
	}


	public NumeroEntreprise getNE() {
		return NE;
	}


	public void setNE(NumeroEntreprise nE) {
		NE = nE;
	}


	public NumeroIdProv getNumProv() {
		return numProv;
	}


	public void setNumProv(NumeroIdProv numProv) {
		this.numProv = numProv;
	}


	

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
		return "Client" + " entreprise=" + entreprise + " adresse=" + adresse
				+ " ville=" + ville + " id=" + id;
	}

	@Transient
	public DossierClient getDossierClient() {
		return this.dossierClient;
	}

	/**
	 * @generated
	 */
	public void setDossierClient(DossierClient dossierClient) {
		this.dossierClient = dossierClient;
	}
}