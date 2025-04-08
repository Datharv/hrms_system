package com.darunkar.hrms_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private EmployeeEntity employee;

	public enum Role {
		ADMIN, HR, EMPLOYEE
	}

	public enum LeaveType {
		SICK, CASUAL, EARNED
	}

	public enum LeaveStatus {
		PENDING, APPROVED, REJECTED
	}

}

