package com.darunkar.hrms_backend.controller;

import com.darunkar.hrms_backend.entity.EmployeeEntity;
import com.darunkar.hrms_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee) {
		return ResponseEntity.ok(employeeService.createEmployee(employee));
	}

	@GetMapping
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
}
