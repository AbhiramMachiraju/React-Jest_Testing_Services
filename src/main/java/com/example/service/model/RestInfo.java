package com.example.service.model;

public class RestInfo<T> {
	
	private int operationCode;
	private String message;
	private T data;
	public int getOperationCode() {
		return operationCode;
	}
	public void setOperationCode(int operationCode) {
		this.operationCode = operationCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	  

}
