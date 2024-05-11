package SqlTesting.entity;

public class User {
	private int user_id;
	private String username;
	private String email_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public User(int user_id, String username, String email_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email_id = email_id;
	}
	public User( String username, String email_id) {
		super();
		this.username = username;
		this.email_id = email_id;
	}
}
