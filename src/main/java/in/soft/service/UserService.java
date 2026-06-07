package in.soft.service;

import java.util.List;

import in.soft.entity.User;

public interface UserService 
{

	String register(User u);
	User login(String email, String password);
	List<User> viewUser();
	String updateUser(User u);
	String delete(int id);
	
}
