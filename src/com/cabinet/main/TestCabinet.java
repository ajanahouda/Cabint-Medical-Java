package com.cabinet.main;
import java.sql.Connection;
import java.sql.Date;
import com.cabinet.models.*;
import com.cabinet.bd.ConnexionBD;
import com.cabinet.dao.PatientDAO;

public class TestCabinet {
	public static void main(String[] args) {
	 Date maDate=Date.valueOf("2004-09-05");
	 Patient p1= new Patient("Alami", "Hiba", "0600997631","A659512", maDate);
	 PatientDAO dao = new PatientDAO();
	 dao.addPatient(p1);
	 
	}
}