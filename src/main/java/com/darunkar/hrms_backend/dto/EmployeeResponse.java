package com.darunkar.hrms_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
	private Long id;
	private String fullName;
	private String email;
	private String department;
	private String designation;
	private String phone;
	private LocalDate joiningDate;
}

