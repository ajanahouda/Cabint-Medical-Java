package com.cabinet.dao;

import com.cabinet.bd.ConnexionBD;
import com.cabinet.models.Patient;
import com.cabinet.models.RendezVous;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RendezVousDAO {
	public void addRDV(RendezVous rdv) {
		String sql = "INSERT INTO RendezVous (dateRDV, heureRDV, statut, id_Patient) VALUES (?,?,?,?)";
		try (Connection conn= ConnexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
		pstmt.setDate(1, new java.sql.Date(rdv.getDateRdv().getTime()));
		pstmt.setString(2, rdv.getHeureRDV());
		pstmt.setString(3, rdv.getStatut());
		pstmt.setLong(4, rdv.getPatient().getId());
		
		pstmt.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<RendezVous> getRendezVousParDate(Date date) {
		List<RendezVous> liste = new ArrayList<>();
	    String sql = "SELECT * FROM RendezVous WHERE dateRDV = ?";
	    try (Connection conn = ConnexionBD.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        pstmt.setDate(1, date);
	        ResultSet rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            RendezVous rdv = new RendezVous();
	            rdv.setIdRdv(rs.getLong("idRDV"));
	            rdv.setDateRdv(rs.getDate("dateRDV"));
	            rdv.setHeureRDV(rs.getString("heureRDV"));
	            rdv.setStatut(rs.getString("statut"));
	            
	            Patient p = new Patient();
	            p.setId(rs.getLong("id_patient")); 
	            rdv.setPatient(p);
	            
	            liste.add(rdv);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return liste;
	}
}
