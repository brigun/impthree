package brigun.impthree.services;

import java.util.List;

import brigun.impthree.models.User;

public interface UserService 
{
	boolean authenticate(String username, String password);
	
	List<User> findAll();
}
