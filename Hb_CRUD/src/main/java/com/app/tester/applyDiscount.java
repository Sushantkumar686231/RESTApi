package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;
import static java.time.LocalDate.parse;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;

public class applyDiscount {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			UserDao dao=new UserDaoImpl();
			System.out.println("enter the date and discount");
			dao.applyDiscount(parse(sc.next()), sc.nextDouble());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
