package com.cabinet.models;

public class Medecin extends Personne {
	private String spécialité;
	private String emailPro;
	
	public Medecin(long id, String nom, String prénom, String téléphone, String spécialité, String emailPro) {
		super(id, nom, prénom, téléphone);
		this.spécialité=spécialité;
		this.emailPro=emailPro;
		// TODO Auto-generated constructor stub
	}

	public String getSpécialité() {
		return spécialité;
	}

	public void setSpécialité(String spécialité) {
		this.spécialité = spécialité;
	}

	public String getEmailPro() {
		return emailPro;
	}

	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	
	

}
