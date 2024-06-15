package com.app.proxy;

import com.app.component.EcartService;
import com.app.component.EcartServiceImpl;

public class EcartServiceProxy implements EcartService{

	private EcartService ecartproxy;
	float discount;
	
	
	public EcartServiceProxy(float discount) {
		ecartproxy=new EcartServiceImpl();
		this.discount=discount;
	}



	@Override
	public float buyNow(String[] items, float[] price) {
		float bill=0;
		float billAfterDiscount=0;
		for(float f:price)
		{
			bill+=f;
		}
		
		billAfterDiscount=(bill)-(bill*(discount/100));
		return billAfterDiscount;
	}

}
