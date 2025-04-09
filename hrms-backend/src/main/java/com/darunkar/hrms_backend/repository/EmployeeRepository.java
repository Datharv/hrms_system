package com.darunkar.hrms_backend.repository;

import com.darunkar.hrms_backend.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	Optional<EmployeeEntity> findByEmployeeCode(String employeeCode);
}

