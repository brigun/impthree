package brigun.impthree.models;

public class User
{
	private Long userId;
	private String firstName;
	private String lastName;
	private String username;
	private String passwordHash;
	
	public Long getId() {
		return userId;
	}
	public void setId(Long id) {
		this.userId = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public User (){}
	
	public User(String firstName, String lastName, String username, String passwordHash) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.passwordHash = passwordHash;
	}
	
	@Override
	public String toString() {
		return "User [id=" + userId + ", Name=" + firstName + " " + lastName + ", username=" + username
				+ "]";
	}
	
	
	
	
	
}
