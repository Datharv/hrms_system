package com.darunkar.hrms_backend.repository;

import com.darunkar.hrms_backend.entity.LeaveRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequestEntity,Long> {
	List<LeaveRequestEntity> findByEmployeeId(Long EmployeeId);
}
