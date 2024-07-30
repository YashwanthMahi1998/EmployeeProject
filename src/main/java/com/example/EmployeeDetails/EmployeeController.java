package com.example.EmployeeDetails;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/save")
	public ResponseEntity<String>saveEmployee(@RequestBody EmployeeDto employeeDto ){
		
		String savedEmployee=employeeService.saveEmployee(employeeDto);
		
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	@GetMapping("/tax-deductions")
	  public List<EmployeeTaxDeduction> getEmployeeTaxDeductions(@RequestParam(required = false) String employeeCode) {
	    List<Employee> employees = employeeRepository.findAll();
	    if (employeeCode != null) {
	      employees = employees.stream()
	          .filter(e -> e.getEmployeeCode().equals(employeeCode))
	          .collect(Collectors.toList());
	    }
	    return employees.stream()
	        .map(this::calculateTaxDeduction)
	        .collect(Collectors.toList());
	  }
	 private EmployeeTaxDeduction calculateTaxDeduction(Employee employee) {
		    double totalSalary = calculateTotalSalary(employee);
		    double taxAmount = calculateTaxAmount(totalSalary);
		    double cessAmount = calculateCessAmount(totalSalary);
		    return new EmployeeTaxDeduction(
		        employee.getEmployeeCode(),
		        employee.getFirstName(),
		        employee.getLastName(),
		        totalSalary,
		        taxAmount,
		        cessAmount
		    );
		  }
	 private double calculateTotalSalary(Employee employee) {
		    // Calculate total salary based on DOJ and loss of pay
		    // ...
		 	double salary=employee.getSalary()*12;
		 	return salary;
		  }
		  
		  private double calculateTaxAmount(double totalSalary) {
		    // Apply tax slabs
		    if (totalSalary <= 250000) {
		      return 0;
		    } else if (totalSalary <= 500000) {
		      return (totalSalary - 250000) * 0.05;
		    } else if (totalSalary <= 1000000) {
		      return 12500 + (totalSalary - 500000) * 0.10;
		    } else {
		      return 37500 + (totalSalary - 1000000) * 0.20;
		    }
		  }
		  
		  private double calculateCessAmount(double totalSalary) {
		    // Collect 2% cess for amount more than 2500000
		    if (totalSalary > 2500000) {
		      return (totalSalary - 2500000) * 0.02;
		    } else {
		      return 0;
		    }
		  }

}
