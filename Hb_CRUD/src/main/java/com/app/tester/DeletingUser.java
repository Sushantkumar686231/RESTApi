package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;

public class DeletingUser {
		
	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in))
		{
			UserDao dao=new UserDaoImpl();
			System.out.println("Enter the usrID");
			String res=dao.deleteUserDetails(sc.nextInt());
			System.out.println(res);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	}
