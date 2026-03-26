package com.cabinet.models;

public abstract class Personne {
	protected long id;
	protected String nom;
	protected String prénom;
	protected String téléphone;
	public Personne(long id, String nom, String prénom, String téléphone) {
		this.id = id;
		this.nom = nom;
		this.prénom = prénom;
		this.téléphone = téléphone;
	}
	
	public Personne(String nom, String prénom, String téléphone) {
		this.nom = nom;
		this.prénom = prénom;
		this.téléphone = téléphone;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrénom() {
		return prénom;
	}
	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}
	public String getTéléphone() {
		return téléphone;
	}
	public void setTéléphone(String téléphone) {
		this.téléphone = téléphone;
	}
	
}
