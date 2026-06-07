package in.soft.service;

import java.util.List;

import in.soft.dao.UserDao;
import in.soft.entity.User;
import in.soft.factory.DaoFactory;

public class UserServiceImpl implements UserService
{
	
	UserDao dao=DaoFactory.getUserDao();

	@Override
	public String register(User u)
	{
		String register = dao.register(u);
		
		return register;
	}

	@Override
	public User login(String email, String password) 
	{
		User login = dao.login(email, password);
		return login;
	}

	@Override
	public List<User> viewUser() {
		
		List<User> viewUsers = dao.viewUsers();
		return viewUsers;
	}

	@Override
	public String updateUser(User u) {
		String updateUser = dao.updateUser(u);
		return updateUser;
	}

	@Override
	public String delete(int id) {
		String deleteUser = dao.deleteUser(id);
		return deleteUser;
	}

}
