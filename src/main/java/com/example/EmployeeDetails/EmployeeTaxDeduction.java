package com.example.EmployeeDetails;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTaxDeduction {
	
	private String employeeCode;
	
	private String firstName;
	
	private String lastName;
	
	private double yearlySalary;
	
	private double taxAmount;
	
	private double cessAmount;
}
