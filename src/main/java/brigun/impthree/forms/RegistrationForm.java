package brigun.impthree.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm {
	//holds the validation logic for the registration form
	@Size(min = 2, max = 30, message = "Username should be between 2 and 30 characters.")
	private String username;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String password;

	@NotNull
	@Size(min = 1, max = 50)
	private String verifyPassword;
	
	@NotNull
	@Size(min = 1, max = 60)
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 60)
	private String lastName;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getVerifyPassword(){
		return verifyPassword;
	}
	
	public void setVerifyPassword(String verifyPassword){
		this.verifyPassword = verifyPassword;
		
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	
	}
	
	
	


