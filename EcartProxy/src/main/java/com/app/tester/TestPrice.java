package com.app.tester;

import com.app.component.EcartService;
import com.app.factory.EcommerceFactory;

public class TestPrice {

	public static void main(String[] args) {
		String couponcode="Sush10";
		
		EcartService service=null;
		
		service=EcommerceFactory.getInstance(couponcode);
		float bill=service.buyNow(new String[]{"tshirt", "shoes"},new float[] {1200,1000});
		System.out.println(bill);
		
	}
}
