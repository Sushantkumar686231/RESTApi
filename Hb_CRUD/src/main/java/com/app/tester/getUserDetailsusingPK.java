package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;

public class getUserDetailsusingPK {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); 
				Scanner sc=new Scanner(System.in))
		{
			
			UserDao dao=new UserDaoImpl();
			
			System.out.println("Enter the ID ");
			long id=sc.nextLong();
			System.out.println(dao.getUserDetails(id)); 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
