package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;

public class GetAllDetails {
	
public static void main(String[] args) {
	try(SessionFactory sf=getFactory())
	{
		UserDao dao=new UserDaoImpl();
		
		//bcuz we are printing list
		dao.getAllUsers().forEach(user->System.out.println(user));
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
	
}
