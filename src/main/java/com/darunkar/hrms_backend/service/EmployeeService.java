package com.darunkar.hrms_backend.service;

import com.darunkar.hrms_backend.dto.EmployeeRequest;
import com.darunkar.hrms_backend.dto.EmployeeResponse;
import com.darunkar.hrms_backend.entity.EmployeeEntity;
import com.darunkar.hrms_backend.exception.ResourceNotFoundException;
import com.darunkar.hrms_backend.mapper.EmployeeMapper;
import com.darunkar.hrms_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeResponse createEmployee(EmployeeRequest request) {
		EmployeeEntity employee = employeeMapper.toEntity(request);
		EmployeeEntity saved = employeeRepository.save(employee);
		return employeeMapper.toResponseDto(saved);
	}

	public List<EmployeeResponse> getAllEmployees() {
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		return employeeMapper.toResponseDto(employeeEntities);
	}

	public EmployeeResponse getEmployeeById(Long id) {
		EmployeeEntity employee =  employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
		return employeeMapper.toResponseDto(employee);

	}
}

