package com.highradius;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestApp {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String json = "{ \"GPCT871UOperationResponse\": { \"order_response\": { \"order_status\": \"01\", \"order_message\": \"ORDER SAVE SUCCESSFUL                                                           \" } } }";

        ObjectMapper objectMapper = new ObjectMapper();
        GPCT871UOperationResponse response = objectMapper.readValue(json, GPCT871UOperationResponse.class);

        // Now you can access the parsed data
        System.out.println("Order Status: " + response.getOrderResponse().getOrderStatus());
	}
}