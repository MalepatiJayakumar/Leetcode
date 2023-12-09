package com.highradius;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderResponse {
    @JsonProperty("order_status")
    private String orderStatus;

    @JsonProperty("order_message")
    private String orderMessage;

}
