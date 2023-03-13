package Saksoft.crudoperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Saksoft.crudoperations.entity.Employee;
import Saksoft.crudoperations.exception.EmployeeNotFoundException;
import Saksoft.crudoperations.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee saveEmployee( @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
		
	}
	
	@GetMapping("/employee")
	public List<Employee> fetchEmployeeList(){
		return employeeService.fetchEmployeeList();
	}
	
	@GetMapping("/employee/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") Integer employeeId) throws EmployeeNotFoundException{
		return employeeService.fetchEmployeeById(employeeId);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable("id") Integer employeeId) {
		employeeService.deleteEmployeeById(employeeId);
		return "Employee deleted successfully...";
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id")Integer employeeId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(employeeId,employee);
	}
	

}
