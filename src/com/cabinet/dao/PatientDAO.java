package com.cabinet.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cabinet.bd.ConnexionBD;
import com.cabinet.models.Patient;

public class PatientDAO {
	public void addPatient(Patient p) {
		String sql = "INSERT INTO Patient (nom, prenom, telephone, cin, dateNaissance) VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conn =ConnexionBD.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql) ){
				
			pstmt.setString(1, p.getNom());
			pstmt.setString(2, p.getPrénom());
			pstmt.setString(3, p.getTéléphone());
			pstmt.setString(4, p.getCIN());
			pstmt.setDate(5, p.getDateNaissance());
			
			pstmt.executeUpdate();
			System.out.println("Le patient a été ajouté avec succès à la base de données");
			} catch (SQLException e) {
				System.out.println("Problème lors de l'ajout du patient: " +e.getMessage());
			}
	}
	public List<Patient> getAllPatients(){
		List<Patient> patients = new ArrayList<>();
		String sql ="SELECT * FROM Patient";
		try(Connection conn = ConnexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs= pstmt.executeQuery();
				){
			while(rs.next()) {
				Patient p=new Patient(
						rs.getLong("id"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("telephone"),
						rs.getString("cin"),
						rs.getDate("dateNaissance")
						);
				patients.add(p);
			}
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'admission des patients: " + e.getMessage());
		}
		return patients;
	}
	public void deletePatient(long id) {
	    String sql = "DELETE FROM Patient WHERE id = ?";
	    
	    try (Connection conn = ConnexionBD.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        pstmt.setLong(1, id);
	        pstmt.executeUpdate();
	        System.out.println("Patient numéro " + id + "est supprimé");
	        
	    } catch (SQLException e) {
	        System.out.println("Erreur de suppression " + e.getMessage());
	    }
	}

}
