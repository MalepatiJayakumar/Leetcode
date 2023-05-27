package com.practice.Collections;

public class Response<T> {
	
	private T data;
	private String message;
	private Boolean success= Boolean.FALSE;
	
	Response(Boolean success, String message, T data){
		this.success= success;
		this.message= message;
		this.data= data;
	}

	public T getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public Boolean getSuccess() {
		return success;
	}
	
}
