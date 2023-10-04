package com.practice.couriers;

import com.practice.service.Courier;

public class BlueDart implements Courier {

	@Override
	public String doShipping(Integer orderId,String[] items) {
		System.out.println("BlueDart.doShipping() >> Order id :: "+orderId);
		return "BlueDart is ready to deliver Order with order id :: "+orderId;
	}
}