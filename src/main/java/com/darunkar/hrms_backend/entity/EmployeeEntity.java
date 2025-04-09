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
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String employeeCode;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String gender;
	private String department;
	private String designation;

	private LocalDate joiningDate;
	private LocalDate dob;

	private String address;
	private String city;
	private String state;
	private String country;
	private String zip;

	private double salary;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
}
