package bankmanagementsystem;

import java.sql.DriverManager;
import java.sql.*;


public class BankManagementSystem {	
		
	    Connection connection ;
		Statement statement;
		
		public BankManagementSystem() {
			String url = "jdbc:mysql:///bankmanagementsystem";
			String username = "root";
			String password = "NanduMySql@1998";
			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, username, password); 
				statement = connection.createStatement();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
}
