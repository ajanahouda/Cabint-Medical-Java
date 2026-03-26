package com.cabinet.models;
import java.util.Date;

public class Consultation {
	private long idConsultation;
	private Date dateConsultation;
	private String motif;
	private String diagnostic;
	private double prix;
	private RendezVous rdv;
	
	public Consultation(long idConsultation, Date dateConsultation,String motif, String diagnostic, double prix,
			RendezVous rdv) {
		super();
		this.idConsultation = idConsultation;
		this.dateConsultation = dateConsultation;
		this.diagnostic = diagnostic;
		this.prix = prix;
		this.rdv = rdv;
	}

	public long getIdConsultation() {
		return idConsultation;
	}

	public void setIdConsultation(long idConsultation) {
		this.idConsultation = idConsultation;
	}

	public Date getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public String getDiagnostic() {
		return diagnostic;
	}
	

	public void setMotif(String motif) {
		this.motif =motif;
	}
	public String Motif() {
		return motif;
	}
	

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public RendezVous getRdv() {
		return rdv;
	}

	public void setRdv(RendezVous rdv) {
		this.rdv = rdv;
	}
	
	
	

}
