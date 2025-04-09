package com.darunkar.hrms_backend.repository;

import com.darunkar.hrms_backend.entity.LeaveRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequestEntity,Long> {
	List<LeaveRequestEntity> findByEmployeeId(Long EmployeeId);
}
