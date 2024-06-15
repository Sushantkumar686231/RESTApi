package com.app.component;

public class EcartServiceImpl implements EcartService{

	@Override
	public float buyNow(String[] items, float[] price) {
		float bill=0;
		
		for(float f:price)
		{
			bill+=f;
		}
		return bill;
	}

}
