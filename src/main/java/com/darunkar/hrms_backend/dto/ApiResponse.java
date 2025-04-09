package com.darunkar.hrms_backend.dto;

public class ApiResponse<T> {
	private boolean success;
	private String message;
	private T data;

	public ApiResponse(boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}
}
