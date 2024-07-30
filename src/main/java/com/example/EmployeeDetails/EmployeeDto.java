package com.example.EmployeeDetails;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private Long employeeId;
	
	@Column(nullable = false)
	private String firstName;
	
	private String employeeCode;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private Long phoneNumber;
	
	@Column(nullable = false)
	private String dateOfjoining;
	
	@Column(nullable = false)
	private Long salary;

}
