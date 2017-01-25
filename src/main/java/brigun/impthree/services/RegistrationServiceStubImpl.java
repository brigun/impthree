package brigun.impthree.services;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceStubImpl implements RegistrationService{

	@Override
	public boolean register(String username, String password, String verifyPassword, String firstName,
			String lastName) {
		if(!Objects.equals(username, password))
		{
			return false;
		}
		return Objects.equals(username,  password) && ((firstName + lastName) != "");
	}

}
