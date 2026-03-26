package com.cabinet.models;
import java.util.Date;

public class RendezVous {
	private long idRdv;
	private Date dateRdv;
	private String heureRDV;
	private String statut;
	private Patient patient;
	private Consultation consultation;
	public RendezVous(long idRdv, Date dateRdv, String heureRDV, String statut, Patient patient) {
		super();
		this.idRdv = idRdv;
		this.dateRdv = dateRdv;
		this.heureRDV = heureRDV;
		this.statut = statut;
		this.patient = patient;
	}
	public RendezVous() {
		// TODO Auto-generated constructor stub
	}
	public Date getDateRdv() {
		return dateRdv;
	}
	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}
	public long getIdRdv() {
		return idRdv;
	}
	public void setIdRdv(long idRdv) {
		this.idRdv = idRdv;
	}
	public String getHeureRDV() {
		return heureRDV;
	}
	public void setHeureRDV(String heureRDV) {
		this.heureRDV = heureRDV;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Consultation getConsultation() {
		return consultation;
	}
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
	

}
