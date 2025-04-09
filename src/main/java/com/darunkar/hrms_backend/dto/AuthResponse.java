package com.darunkar.hrms_backend.dto;

import com.darunkar.hrms_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
	private String token;
	private String email;
	private User.Role role;
}