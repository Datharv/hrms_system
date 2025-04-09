package com.darunkar.hrms_backend.controller;

import com.darunkar.hrms_backend.entity.LeaveRequestEntity;
import com.darunkar.hrms_backend.entity.User;
import com.darunkar.hrms_backend.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService leaveRequestService;

	@PostMapping("/apply/{employeeId}")
	public ResponseEntity<LeaveRequestEntity> applyLeave(@PathVariable Long employeeId,
			@RequestBody LeaveRequestEntity leaveRequest) {
		return ResponseEntity.ok(leaveRequestService.applyLeave(employeeId, leaveRequest));
	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<List<LeaveRequestEntity>> getEmployeeLeaves(@PathVariable Long employeeId) {
		return ResponseEntity.ok(leaveRequestService.getLeavesByEmployee(employeeId));
	}

	@GetMapping
	public ResponseEntity<List<LeaveRequestEntity>> getAllLeaves() {
		return ResponseEntity.ok(leaveRequestService.getAllLeaveRequests());
	}

	@PutMapping("/update-status/{leaveId}")
	public ResponseEntity<LeaveRequestEntity> updateLeaveStatus(@PathVariable Long leaveId,
			@RequestParam User.LeaveStatus status) {
		return ResponseEntity.ok(leaveRequestService.updateLeaveStatus(leaveId, status));
	}
}
