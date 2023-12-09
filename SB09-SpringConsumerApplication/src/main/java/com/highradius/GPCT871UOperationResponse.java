package com.highradius;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@XmlRootElement(name = "GPCT871UOperationResponse")
@Data
public class GPCT871UOperationResponse {

	@JsonProperty("order_response")
	private OrderResponse orderResponse;

	// Example of usage
	public static void main(String[] args) throws Exception {
		String json = "{\r\n"
				+ "    \"GPCT871UOperationResponse\": {\r\n"
				+ "        \"order_response\": {\r\n"
				+ "            \"order_status\": \"01\",\r\n"
				+ "            \"order_message\": \"ORDER SAVE SUCCESSFUL                                                           \"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
		ObjectMapper objectMapper = new ObjectMapper();
		Response response = objectMapper.readValue(json, Response.class);

		// Now you can access the parsed data
		System.out.println("Order Status: " + response.getGPCT871UOperationResponse().getOrderResponse().getOrderStatus());
		System.out.println("Order Message: " + response.getGPCT871UOperationResponse().getOrderResponse().getOrderMessage());
		if (!("01").equalsIgnoreCase(response.getGPCT871UOperationResponse().getOrderResponse().getOrderStatus())) {
			
		} else {
			
		}
	}
}
