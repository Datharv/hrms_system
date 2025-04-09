package com.darunkar.hrms_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leave_requests")
public class LeaveRequestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employee;

	@Enumerated(EnumType.STRING)
	private User.LeaveType leaveType;

	private LocalDate fromDate;
	private LocalDate toDate;
	private String reason;

	@Enumerated(EnumType.STRING)
	private User.LeaveStatus status;

	private LocalDate appliedOn;
	private LocalDate actionDate;
}
