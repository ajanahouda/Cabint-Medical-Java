package com.cabinet.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	private static final String URL ="jdbc:mysql://localhost:3306/cabinet_medical";
	private static final String USER= "root";
	private static final String PASSWORD="";
	
	public static Connection getConnection() {
		Connection connection =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL ,USER, PASSWORD );
			System.out.println("Connecxion réussie ");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erreur de connexion : " +e.getMessage());
		}
		return connection;
	}
}
