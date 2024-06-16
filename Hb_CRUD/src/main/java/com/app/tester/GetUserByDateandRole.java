package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;
import static java.time.LocalDate.parse;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;
import com.app.entities.Role;

public class GetUserByDateandRole {

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in); SessionFactory sf=getFactory())
		{
			UserDao dao=new UserDaoImpl();
			System.out.println("Enter start date , end date and role");
			dao.getUserByDobAndRole(parse(sc.next()), parse(sc.next()),
					Role.valueOf(sc.next().toUpperCase())).forEach(user->System.out.println(user));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

	}

}//1990-01-01 2000-12-31 Blogger
