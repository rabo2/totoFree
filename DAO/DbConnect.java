package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbConnect {
	private static Connection dbConn;
	private static PreparedStatement prepareStatement;
	public static PreparedStatement getConnection(StringBuilder sql) {
		if (dbConn == null) {
			try {
				String url = "jdbc:oracle:thin:@192.168.45.50:1521:XE";
				String user = "toto";
				String password = "toto";
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection dbConn = DriverManager.getConnection(url, user, password);
				prepareStatement = dbConn.prepareStatement(sql.toString());
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return prepareStatement;
	}
	
	
	
	public static void close() {
		if (dbConn != null) {
			try {
				if (!dbConn.isClosed()) {
					dbConn.close();
					prepareStatement.close();
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		dbConn = null;
	}
}
