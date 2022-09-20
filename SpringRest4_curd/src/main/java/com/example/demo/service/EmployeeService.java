package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {

	public Employee saveEmployees(Employee employee);

	public List<Employee> getAllEmployee();

	public Optional<Employee> getEmployeeById(Integer empId);

	public Employee updateEmployeeById(Employee employee, Integer empId);

	public void deleteEmployeeById(Integer empId);
	
	
	public List<Employee> getEmployeeByName(String empName);
	
	public List<Employee> getEmployeeByCity(String empCity);

}
