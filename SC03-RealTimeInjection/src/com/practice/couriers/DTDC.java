package com.practice.couriers;

import com.practice.service.Courier;

public class DTDC implements Courier {

	@Override
	public String doShipping(Integer orderId,String[] items) {
		System.out.println("DTDC.doShipping() >> Order id :: "+orderId);
		return "DTDC is ready to deliver Order with order id :: "+orderId;
	}

}
