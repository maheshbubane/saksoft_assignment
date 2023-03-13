package Saksoft.crudoperations.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Saksoft.crudoperations.entity.Employee;
import Saksoft.crudoperations.exception.EmployeeNotFoundException;
import Saksoft.crudoperations.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> fetchEmployeeList() {
		return employeeRepository.findAll();
	}
	@Override
	public Employee fetchEmployeeById(Integer employeeId) {
		Optional<Employee> employee=
		 employeeRepository.findById(employeeId);
		
		if(!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee Not Found ");
		}
		return employee.get();
	}
	@Override
	public void deleteEmployeeById(Integer employeeId) {
		 employeeRepository.deleteById(employeeId);
	}
	
	@Override
	public Employee updateEmployee(Integer employeeId, Employee employee) {
		
		Employee empDb=employeeRepository.findById(employeeId).get();
		
		if(Objects.nonNull(employee.getFirstName())&&!"".equalsIgnoreCase(employee.getFirstName())) {
			empDb.setFirstName(employee.getFirstName());
		}
		
		if(Objects.nonNull(employee.getLastName())&&!"".equalsIgnoreCase(employee.getLastName())) {
			empDb.setLastName(employee.getLastName());
		}
		
		if(Objects.nonNull(employee.getEmailId())&&!"".equalsIgnoreCase(employee.getEmailId())) {
			empDb.setEmailId(employee.getEmailId());
		}
		
		if(Objects.nonNull(employee.getAge())) {
			empDb.setAge(employee.getAge());
		}
		
		return employeeRepository.save(empDb);
	}

}
