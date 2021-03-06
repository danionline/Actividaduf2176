package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	
	private final static String URL = "jdbc:mysql://localhost/uf2176_daniel_renedo";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "Daniel*2020";
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Connection con = null;
		
		// comprobar que tengamos el .jar de MySQL
		Class.forName("com.mysql.jdbc.Driver");
		
		//establecer conexion
		con = DriverManager.getConnection(URL, USUARIO, PASS);
		
		return con;
	};
	

}
