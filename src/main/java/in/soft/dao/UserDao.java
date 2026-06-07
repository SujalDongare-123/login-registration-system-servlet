package in.soft.dao;

import java.util.List;

import in.soft.entity.User;

public interface UserDao
{
	String register(User u);
	User login(String email,String password);
	List<User> viewUsers();
	String updateUser(User u);
	String deleteUser(int id);

}
