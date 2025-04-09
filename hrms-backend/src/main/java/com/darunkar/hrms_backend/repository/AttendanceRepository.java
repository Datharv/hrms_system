package com.darunkar.hrms_backend.repository;

import com.darunkar.hrms_backend.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {

	List<AttendanceEntity> findByEmployeeIdAndDate(Long employeeId, LocalDate date);

}
