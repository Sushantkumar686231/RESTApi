package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.ProductDao;
import com.app.dao.ProductDaoImp;
import com.app.entities.Products;
public class AddProductSave {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in))
		{
			ProductDao pdao=new ProductDaoImp();
			
			System.out.println("Enter the product details");
			System.out.println("Pname,Price,Quantity");
			Products product=new Products(sc.next(),sc.nextFloat(),sc.nextFloat());
			
			System.out.println(pdao.addProduct(product));
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
