package SqlTesting.model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import SqlTesting.config.DatabaseConfig;
import SqlTesting.entity.User;

public class UserModel {
	public List<User> listuser() throws ClassNotFoundException, SQLException {
		List<User> listusers = new ArrayList<User>();
		Connection connect = DatabaseConfig.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "Select * from users";
		
		stmt = connect.createStatement();
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			listusers.add(new User(rs.getInt("user_id"),rs.getString("username") , rs.getString("email_id")));
		}
		
		
		
		
		return listusers;
		
	}

}
