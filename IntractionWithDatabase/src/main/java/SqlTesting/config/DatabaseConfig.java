package SqlTesting.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	public static Connection getConnection() throws SQLException , ClassNotFoundException {
		String dbURL = "jdbc:mysql://localhost:3306/sqltesting?useSSl=false";
		String dbUsername = "root";
		String dbPassword = "admin";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbURL, dbUsername , dbPassword);
		return con;
	}

}
