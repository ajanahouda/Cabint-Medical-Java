package com.cabinet.models;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Patient extends Personne {
	private Date dateNaissance;
	private String CIN;
	private String dossierMedical;
	
	private List <RendezVous> listeRDV= new ArrayList<>();

	public Patient(long id, String nom, String prénom, String téléphone, String CIN, Date dateNaissance) {
		super(id, nom, prénom, téléphone);
		this.CIN=CIN;
		this.dateNaissance=dateNaissance;
		// TODO Auto-generated constructor stub
	}
	public Patient(String nom, String prénom, String téléphone, String cin, Date dateNaissance) {
	   super(nom, prénom, téléphone);
	    this.CIN = cin;
	    this.dateNaissance = dateNaissance;
	}

	public Patient() {
		super(0,"","","");
	}
	public List<RendezVous> getListeRDV() {
		return listeRDV;
	}

	public void addRDV(RendezVous rdv) {
		this.listeRDV.add(rdv);
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getDossierMedical() {
		return dossierMedical;
	}
	public void setDossierMedical(String dossierMedical) {
		this.dossierMedical = dossierMedical;
	}
	
	
	

}
