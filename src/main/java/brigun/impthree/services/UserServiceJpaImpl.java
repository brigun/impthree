package brigun.impthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import brigun.impthree.models.User;
import brigun.impthree.repositories.UserRepository;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		
		return (username == password);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User findByUsername(String username)
	{
		return this.userRepo.findByUsername(username);
	}

	
	
}
