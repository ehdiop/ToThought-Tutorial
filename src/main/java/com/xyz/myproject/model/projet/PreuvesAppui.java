package com.xyz.myproject.model.projet;

import java.util.Observable;


/**
 * Le type de preuves à l'appui, une info demandées dans les infos du projet.
 */
public class PreuvesAppui extends Observable implements java.io.Serializable {
	
	public enum PREUVES{MODIF};
	/**
	 * @generated
	 */
	private boolean doc_planif;
	
	/**
	 * @generated
	 */
	private boolean registres_attrib;
	/**
	 * @generated
	 */
	private boolean concep_essais;
	/**
	 * @generated
	 */
	private boolean registre_carnet;
	/**
	 * @generated
	 */
	private boolean conception;
	/**
	 * @generated
	 */
	private boolean registre_essais;
	/**
	 * @generated
	 */
	private boolean rapports_progres;
	/**
	 * @generated
	 */
	private boolean protoc_essais;
	/**
	 * @generated
	 */
	private boolean photo_video;
	/**
	 * @generated
	 */
	private boolean echant_proto;
	/**
	 * @generated
	 */
	private boolean contrats;
	/**
	 * @generated
	 */
	private boolean autresBoolean;
	
	private String autresString;
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -859850979L;
	/**
	 * @generated
	 */
	private Long id;

	/**
	 * @generated
	 */
	public PreuvesAppui() {
	}

	
	public boolean isaDoc_planif() {
		return doc_planif;
	}


	public void setADoc_planif(boolean doc_planif) {
		this.doc_planif = doc_planif;
	}


	public boolean isBRegistres_attrib() {
		return registres_attrib;
	}


	public void setBRegistres_attrib(boolean registres_attrib) {
		this.registres_attrib = registres_attrib;
	}


	public boolean isCConcep_essais() {
		return concep_essais;
	}


	public void setCConcep_essais(boolean concep_essais) {
		this.concep_essais = concep_essais;
	}


	public boolean isDRegistre_carnet() {
		return registre_carnet;
	}


	public void setDRegistre_carnet(boolean registre_carnet) {
		this.registre_carnet = registre_carnet;
	}


	public boolean isEConception() {
		return conception;
	}


	public void setEConception(boolean conception) {
		this.conception = conception;
	}


	public boolean isFRegistre_essais() {
		return registre_essais;
	}


	public void setFRegistre_essais(boolean registre_essais) {
		this.registre_essais = registre_essais;
	}


	public boolean isGRapports_progres() {
		return rapports_progres;
	}


	public void setGRapports_progres(boolean rapports_progres) {
		this.rapports_progres = rapports_progres;
	}


	public boolean isHProtoc_essais() {
		return protoc_essais;
	}


	public void setHProtoc_essais(boolean protoc_essais) {
		this.protoc_essais = protoc_essais;
	}


	public boolean isIPhoto_video() {
		return photo_video;
	}


	public void setIPhoto_video(boolean photo_video) {
		this.photo_video = photo_video;
	}


	public boolean isJEchant_proto() {
		return echant_proto;
	}


	public void setJEchant_proto(boolean echant_proto) {
		this.echant_proto = echant_proto;
	}


	public boolean isKContrats() {
		return contrats;
	}


	public void setKContrats(boolean contrats) {
		this.contrats = contrats;
	}





	public boolean isAutresBoolean() {
		return autresBoolean;
	}


	public void setAutresBoolean(boolean autresBoolean) {
		this.autresBoolean = autresBoolean;
		this.setChanged();
		this.notifyObservers(PREUVES.MODIF);
	}


	public String getAutresString() {
		return autresString;
	}


	public void setAutresString(String autresString) {
		this.autresString = autresString;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @generated
	 */
	public String toString() {
		return "PreuvesAppui" + " doc_planif=" + doc_planif
				+ " registres_attrib=" + registres_attrib + " concep_essais="
				+ concep_essais + " registre_carnet=" + registre_carnet
				+ " conception=" + conception + " registre_essais="
				+ registre_essais + " rapports_progres=" + rapports_progres
				+ " protoc_essais=" + protoc_essais + " photo_video="
				+ photo_video + " echant_proto=" + echant_proto + " contrats="
				+ contrats + " autres=" + autresString + " id=" + id;
	}
}