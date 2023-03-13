package Saksoft.crudoperations.service;

import java.util.List;

import Saksoft.crudoperations.entity.Employee;
import Saksoft.crudoperations.exception.EmployeeNotFoundException;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> fetchEmployeeList();

	public Employee fetchEmployeeById(Integer employeeId) throws EmployeeNotFoundException ;

	public void deleteEmployeeById(Integer employeeId);

	public Employee updateEmployee(Integer employeeId, Employee employee);
	

}
