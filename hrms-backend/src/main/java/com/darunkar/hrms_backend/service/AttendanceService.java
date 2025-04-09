package com.darunkar.hrms_backend.service;

import com.darunkar.hrms_backend.entity.AttendanceEntity;
import com.darunkar.hrms_backend.repository.AttendanceRepository;
import com.darunkar.hrms_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public AttendanceEntity checkIn(Long employeeId) {
		LocalDate today = LocalDate.now();
		Optional<AttendanceEntity> existing = attendanceRepository.findByEmployeeIdAndDate(employeeId, today).stream().findFirst();

		if (existing.isPresent()) {
			throw new RuntimeException("Already checked in today.");
		}

		AttendanceEntity attendance = new AttendanceEntity();
		attendance.setEmployee(employeeRepository.findById(employeeId).orElseThrow());
		attendance.setDate(today);
		attendance.setCheckIn(LocalDateTime.now());

		return attendanceRepository.save(attendance);
	}

	public AttendanceEntity checkOut(Long employeeId) {
		LocalDate today = LocalDate.now();
		AttendanceEntity attendance = attendanceRepository.findByEmployeeIdAndDate(employeeId, today).stream()
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Check-in not found."));

		attendance.setCheckOut(LocalDateTime.now());
		attendance.setWorkingHours(
				Duration.between(attendance.getCheckIn(), attendance.getCheckOut()).toMinutes() / 60.0
		);

		return attendanceRepository.save(attendance);
	}

	public List<AttendanceEntity> getAttendanceByEmployee(Long employeeId) {
		return attendanceRepository.findByEmployeeIdAndDate(employeeId, LocalDate.now());
	}

	public List<AttendanceEntity> getAllAttendance() {
		return attendanceRepository.findAll();
	}
}
