package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;
import com.app.entities.Role;
import com.app.entities.User;
public class RegisterUser {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in))
		{
			UserDao dao=new UserDaoImpl();
			System.out.println("Enter user details -  firstName,  lastName,\" + \"  \"\r\n"
					+ "+ \"email,  password,  dob,  phoneNo, role reg amount");
			User newuser=new User(sc.next(),sc.next(),sc.next(),sc.next(),
					LocalDate.parse(sc.next()),sc.next(),Role.valueOf(sc.next())
					,sc.nextDouble());
			System.out.println(dao.RegisterUser(newuser));
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
		

	}

}
