package brigun.impthree.services;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import brigun.impthree.models.User;

@Service
public class UserServiceStubImpl implements UserService {

	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return Objects.equals(username, password);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
