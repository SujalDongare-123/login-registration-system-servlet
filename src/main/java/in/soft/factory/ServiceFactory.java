package in.soft.factory;

import in.soft.service.UserService;
import in.soft.service.UserServiceImpl;

public class ServiceFactory 
{
	
	private static UserService service=null;

	static
	{
		service =new UserServiceImpl();
	}
	
	public static UserService getUserService()
	{
		return service;
	}
}
