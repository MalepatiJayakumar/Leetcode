package com.practice.Utilities;

public class Response<T> {
	private Boolean success = Boolean.FALSE;
	private String message;
	private T output;
	
	public Response(Boolean success , String message , T output){
		this.success = success;
		this.message = message;
		this.output = output;
	}
	
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getOutput() {
		return output;
	}

	public void setOutput(T output) {
		this.output = output;
	}

}