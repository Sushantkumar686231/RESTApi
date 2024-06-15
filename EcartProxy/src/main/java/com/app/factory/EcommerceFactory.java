package com.app.factory;

import com.app.component.EcartService;
import com.app.component.EcartServiceImpl;
import com.app.proxy.EcartServiceProxy;

public class EcommerceFactory {

	public static EcartService getInstance(String coupon)
	{
		if(coupon.equals("") || coupon.trim().length()==0)
		{
			return new EcartServiceImpl();
		}
		else 
		{
			if(coupon.equalsIgnoreCase("SUSH50"))
			{
				return new EcartServiceProxy(50);
			}
			else if(coupon.equalsIgnoreCase("SUSH10")) 
			{
				return new EcartServiceProxy(10);
			}
			else {
				return new EcartServiceImpl();
			}
		}
	}
}
