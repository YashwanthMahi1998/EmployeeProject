package com.example.EmployeeDetails;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	
	private String firstName;
	
	private String employeeCode;
	
	private String lastName;
	
	
	private String email;
	
	
	private Long phoneNumber;
	
	 
	private String dateOfJoining;
	
	
	private Long salary;

}
