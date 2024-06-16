package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;
import com.app.entities.Role;
public class getNameAndDobByRole {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getFactory())
		{
			UserDao dao=new UserDaoImpl();
			
			System.out.println("Enter the role");
			dao.getNamesAndDobByRole
			(Role.valueOf(sc.next().toUpperCase()))
			.forEach(users->System.out.println(users.getFirstName()
					+" "+users.getLastName()+" "+users.getDob()));
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
