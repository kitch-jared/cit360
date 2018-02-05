package hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJDBC {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/world?useSSL=false";
		String user = "hibernateUN";
		String pass = "hibernatePW";
		
		try {
			System.out.println("\n\nConnecting to database: " + jdbcUrl);
			
			Connection myConnection =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("\n\nSuccessful connection\n\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
