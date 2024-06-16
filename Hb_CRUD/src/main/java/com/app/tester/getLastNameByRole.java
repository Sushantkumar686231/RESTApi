package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;
import com.app.entities.Role;
public class getLastNameByRole {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getFactory()){
			UserDao dao=new UserDaoImpl();
			
			System.out.println("Enter the role");
			dao.getLastNameByRole(Role.valueOf
					(sc.next().toUpperCase()))
			.forEach(user->System.out.println(user));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
