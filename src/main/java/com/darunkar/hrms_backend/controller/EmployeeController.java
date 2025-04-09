package com.darunkar.hrms_backend.controller;

import com.darunkar.hrms_backend.dto.ApiResponse;
import com.darunkar.hrms_backend.dto.EmployeeRequest;
import com.darunkar.hrms_backend.dto.EmployeeResponse;
import com.darunkar.hrms_backend.entity.EmployeeEntity;
import com.darunkar.hrms_backend.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping()
	public ResponseEntity<ApiResponse<EmployeeResponse>> createEmployee(
			@RequestBody @Valid EmployeeRequest request) {

		EmployeeResponse response = employeeService.createEmployee(request);

		return ResponseEntity.ok(
				new ApiResponse<>(true, "Employee created successfully", response)
		);
	}



	@GetMapping
	public ResponseEntity<ApiResponse<List<EmployeeResponse>>> getAllEmployees() {
		List<EmployeeResponse> employeeResponses = employeeService.getAllEmployees();
		return ResponseEntity.ok(
				new ApiResponse<>(true, "Employee fetched successfully", employeeResponses)
		);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<EmployeeResponse>> getEmployeeById(@PathVariable Long id) {
		EmployeeResponse response = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(
				new ApiResponse<>(true, "Employee fetched successfully", response)
		);
	}
}
