package com.darunkar.hrms_backend.controller;

import com.darunkar.hrms_backend.entity.AttendanceEntity;
import com.darunkar.hrms_backend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@PostMapping("/check-in/{employeeId}")
	public ResponseEntity<AttendanceEntity> checkIn(@PathVariable Long employeeId) {
		return ResponseEntity.ok(attendanceService.checkIn(employeeId));
	}

	@PostMapping("/check-out/{employeeId}")
	public ResponseEntity<AttendanceEntity> checkOut(@PathVariable Long employeeId) {
		return ResponseEntity.ok(attendanceService.checkOut(employeeId));
	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<List<AttendanceEntity>> getByEmployee(@PathVariable Long employeeId) {
		return ResponseEntity.ok(attendanceService.getAttendanceByEmployee(employeeId));
	}

	@GetMapping
	public ResponseEntity<List<AttendanceEntity>> getAll() {
		return ResponseEntity.ok(attendanceService.getAllAttendance());
	}
}
