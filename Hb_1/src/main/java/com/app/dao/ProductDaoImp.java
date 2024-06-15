package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.Products;

public class ProductDaoImp implements ProductDao{

	@Override
	public String addProduct(Products prod)
	{
		String msg="Failed insertion";
		Session session=getFactory().getCurrentSession();
		Transaction tx= session.beginTransaction();
		
		try {
			// SAVE method returns Serializable id  
			//Serializable id= session.save(prod);
			
			
			//persist method
			session.persist(prod);
			
			tx.commit();
			
			msg= "succesfully added";
			
		}catch(RuntimeException e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}
}
