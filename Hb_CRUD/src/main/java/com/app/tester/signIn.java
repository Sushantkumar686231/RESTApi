package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;

public class signIn {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in); 
				SessionFactory sf=getFactory())
		{
			UserDao dao=new UserDaoImpl();
			System.out.println("Enter the email and password");
			System.out.println(dao.sigIn(sc.next(), sc.next()));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}//a1@gmail.com  a1234

}
