package SqlTesting.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

	
	public void addUser(User newUser) throws ClassNotFoundException, SQLException {
		Connection connect = null;
		PreparedStatement pst = null;
		
		connect = DatabaseConfig.getConnection();
		String username = newUser.getUsername();
		String emailid = newUser.getEmail_id();
		String query = "insert into users (username , email_id) values (?,?)";
		pst = connect.prepareStatement(query);
		pst.setString(1, username);
		pst.setString(2, emailid);
		pst.execute();
		
	}


	public void updateUser(User updatedUser) throws SQLException, ClassNotFoundException {
		Connection connect = null;
		PreparedStatement pst = null;
		
		connect = DatabaseConfig.getConnection();
		int userid = updatedUser.getUser_id();
		String username = updatedUser.getUsername();
		String emailid = updatedUser.getEmail_id();
		String query = "update users set username = ? , email_id = ?  where user_id = ? ";
		pst = connect.prepareStatement(query);
		pst.setString(1, username);
		pst.setString(2,emailid);
		pst.setInt(3, userid);
		pst.execute();
		
	}

	
	public void deleteUser(int user_id) throws ClassNotFoundException, SQLException {
		Connection connect = null;
		PreparedStatement statement = null;
		
		connect = DatabaseConfig.getConnection();
		String query = "delete from users where user_id = ? ";
		statement = connect.prepareStatement(query);
		statement.setInt(1, user_id);
		statement.execute();
		
	}

}
