package in.soft.factory;

import in.soft.dao.UserDao;
import in.soft.dao.UserDaoImpl;

public class DaoFactory 
{
	
	private static UserDao dao=null;

	static
	{
		dao=new UserDaoImpl();
	}
	
	public static UserDao getUserDao()
	{
		return dao;
	}
}
