package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.Role;
import com.app.entities.User;
public class UserDaoImpl implements UserDao {

	//Registration---use of save method 
	@Override
	public String RegisterUser(User user) {
		String msg="Registration fails!!!!";
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			session.save(user);
			tx.commit();
			msg="Successfully registered";
			
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
		
	}
	
	
	//getting user details
	@Override
	public User getUserDetails(Long userId) {
		User user=null;
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			//**imp whenever watch to run select query with pk
			user=session.get(User.class, userId); //select query with PK
			
			tx.commit();
			
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return user;
	}


	//getting all users
	@Override
	public List<User> getAllUsers() {
		List<User> li=null;
		
		String jpql="select u from User u";
		
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			//select * from user=> but this create query will return query we need list so getResultList is imp.
			li=session.createQuery(jpql,User.class).getResultList();
			tx.commit();
			
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return li;
		
	}


	//select * from User where dob is between _ and _ and role=_
	@Override
	public List<User> getUserByDobAndRole
	(LocalDate start1, LocalDate end1, Role role1) {
		
		List<User> users=null;
		String jpql="select u from User u where u.dob "
				+ "between :start and :end and u.role=:role";
		
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			users=session.createQuery(jpql,User.class)
					.setParameter("start", start1)
					.setParameter("end", end1)
					.setParameter("role", role1)
					.getResultList();
			tx.commit();
			
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return users;
		
	}


	//select * from usr where email=emailand password=pass;
	@Override
	public User sigIn(String email1, String password1) {
		String jpql="select u from User u "
				+ "where u.email=:email and u.password=:password";
		
		User user=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			user=session.createQuery(jpql,User.class)
			.setParameter("email", email1)
			.setParameter("password", password1)
			.getSingleResult();
			tx.commit();
			
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return user;
	}


	//select lname from User where role =:role--->>**check return type and createQuery->class 
	@Override
	public List<String> getLastNameByRole(Role role) {
		String jpql="select u.lastName from User u where "
				+ "u.role=:role";
		List<String> names=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			names=session.createQuery(jpql,String.class)
			.setParameter("role",role)
			.getResultList();
			tx.commit();
			
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return names;
	}


	//select fname and lname  from user where role=:role;
	//**here check query for multiple values use 
	//NEW+Fully qualified class anme
	@Override
	public List<User> getNamesAndDobByRole(Role role) {
		List<User> users=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select new com.app.entities.User"
					+ "(firstName,lastName,dob)"
					+ "from User u where u.role=:role";
			users=session.createQuery(jpql,User.class)
			.setParameter("role", role)
			.getResultList();
			tx.commit();
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	
	

	//update table user u where email=:email
	//n pass=:oldpass set pass=:newpas
	@Override
	public String changePassword
	(String email, String oldpass, String newpass) {
		User user=null;
		String msg="updatepassword failed!!!!";
		String jpql="select u from User u "
				+ "where u.email=:email and u.password=:password";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			user=session.createQuery(jpql,User.class)
				.setParameter("email", email)
				.setParameter("password", oldpass)
				.getSingleResult();
			
			user.setPassword(newpass);
			tx.commit();
			msg="Successfully password updated!!!";
					
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}


	//**
	@Override
	public String applyDiscount(LocalDate date, double discount) {
		String msg="discount failed";
		String jpql="update User u set u.regAmount=:u.regAmount-:amt "
				+ "where u.dob<:dt";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int rowCount=session.createQuery(jpql)
					.setParameter("amt", discount)
					.setParameter("dt", date)
					.executeUpdate();
			
			tx.commit();
			msg="discount success recs"+rowCount;
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}

		return msg;
	}


	//delete from User where uid=:uid
	@Override
	public String deleteUserDetails(long uId) {
		String msg="deletion failed!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		User user=null;
		try {
			
			user=session.get(User.class, uId);
			if(user!=null)
			{
				session.delete(user);
				msg="Succesfully deleted";
				
			}
			tx.commit();
		
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}
		return msg;
		
	}


	@Override
	public String storeImage(String filename, Long uId) throws IOException {
		String msg="Image store Failed !!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User user=session.get(User.class, uId);
			if(user!=null)
			{
				File file=new File(filename);
				if(file.isFile() && file.canRead())
				{
					user.setImage(FileUtils.readFileToByteArray(file));
					msg="succesfully stored";
				}
			}
			
		tx.commit();// DML - update
		} catch (RuntimeException e) {
		if (tx != null)
			tx.rollback();
		// re throw the exc to the caller
		throw e;
	}
	return msg;
	}


	@Override
	public String restoreImage(String newFilename, Long uId) throws IOException {
		String mesg = "restoring image failed";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3 get user
			User user = session.get(User.class, uId);
			if (user != null) {
				// user :exists , persistent
				//4. get image of user
				byte[] img=user.getImage();
				if(img != null)
				{
					//img exists 
					FileUtils.writeByteArrayToFile(new File(newFilename), img);
					mesg="img restored";
				}
			}
			tx.commit();// DML - update
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

	
}
