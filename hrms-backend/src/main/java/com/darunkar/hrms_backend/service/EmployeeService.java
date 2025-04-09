package com.darunkar.hrms_backend.service;

import com.darunkar.hrms_backend.entity.EmployeeEntity;
import com.darunkar.hrms_backend.exception.ResourceNotFoundException;
import com.darunkar.hrms_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeEntity createEmployee(EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}

	public List<EmployeeEntity> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public EmployeeEntity getEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
	}
}

