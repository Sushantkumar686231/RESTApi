package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;

public class restoreImage {

	public static void main(String[] args) {
			try (SessionFactory sf = getFactory(); 
						Scanner sc = new Scanner(System.in)) {
					
					System.out.println("Enter filename");
					String filename=sc.nextLine();
					System.out.println("Enter userId");
					Long uId=sc.nextLong();
					UserDao dao=new UserDaoImpl();
					System.out.println(dao.restoreImage(filename, uId));
				}catch(Exception e)
				{
					e.printStackTrace();
				}

			}


	}

