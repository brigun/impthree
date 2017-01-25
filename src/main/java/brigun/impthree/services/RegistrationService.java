package brigun.impthree.services;

public interface RegistrationService {
	
	boolean register(String username, String password, String verifyPassword, String firstName, String lastName);

}
