package com.darunkar.hrms_backend.dto;

import lombok.Data;

@Data
public class AuthRequest {
	private String email;
	private String password;
}