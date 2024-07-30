package com.example.EmployeeDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String  saveEmployee(EmployeeDto employeeDto) {
		Employee employee=new Employee();
		employee.setFirstName(employeeDto.getFirstName());
		employee.setEmployeeCode(employeeDto.getEmployeeCode());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setPhoneNumber(employeeDto.getPhoneNumber());
		employee.setDateOfJoining(employeeDto.getDateOfjoining());
		employee.setSalary(employeeDto.getSalary());
		employeeRepository.save(employee);
		
		return "Employee Added Successfully";
	}
	
	
	 
}
