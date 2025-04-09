package com.darunkar.hrms_backend.service;

import com.darunkar.hrms_backend.entity.EmployeeEntity;
import com.darunkar.hrms_backend.entity.LeaveRequestEntity;
import com.darunkar.hrms_backend.entity.User;
import com.darunkar.hrms_backend.repository.EmployeeRepository;
import com.darunkar.hrms_backend.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveRequestService {

	@Autowired
	private LeaveRequestRepository leaveRequestRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public LeaveRequestEntity applyLeave(Long employeeId, LeaveRequestEntity leaveRequest) {
		EmployeeEntity employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Employee not found"));

		leaveRequest.setEmployee(employee);
		leaveRequest.setStatus(User.LeaveStatus.PENDING);
		leaveRequest.setAppliedOn(LocalDate.now());

		return leaveRequestRepository.save(leaveRequest);
	}

	public List<LeaveRequestEntity> getLeavesByEmployee(Long employeeId) {
		return leaveRequestRepository.findByEmployeeId(employeeId);
	}

	public List<LeaveRequestEntity> getAllLeaveRequests() {
		return leaveRequestRepository.findAll();
	}

	public LeaveRequestEntity updateLeaveStatus(Long leaveId, User.LeaveStatus status) {
		LeaveRequestEntity leaveRequest = leaveRequestRepository.findById(leaveId)
				.orElseThrow(() -> new RuntimeException("Leave Request not found"));

		leaveRequest.setStatus(status);
		leaveRequest.setActionDate(LocalDate.now());

		return leaveRequestRepository.save(leaveRequest);
	}
}
