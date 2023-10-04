package com.practice.couriers;

import com.practice.service.Courier;

public class Delhivery implements Courier {

	@Override
	public String doShipping(Integer orderId,String[] items) {
		System.out.println("Delhivery.doShipping() >> Order id :: "+orderId);
		return "Delhivery is ready to deliver Order with order id :: "+orderId;
	}

}
