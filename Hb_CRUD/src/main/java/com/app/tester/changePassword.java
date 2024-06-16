package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;

public class changePassword {
	
public static void main(String[] args) {
	try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in))
	{
		UserDao dao=new UserDaoImpl();
		
		System.out.println("Enter Email oldpassword newpassword");
		System.out.println(dao.changePassword
				(sc.next(), sc.next(), sc.next()));
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
	
}//a1@gmail.com a1234 sushant
