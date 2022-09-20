package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployees(Employee employee) {

		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {

		return this.employeeRepository.findAll();

	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Employee> getEmployeeById(Integer empId) {
		Optional<Employee> findById = this.employeeRepository.findById(empId);
		return findById;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee updateEmployeeById(Employee employee, Integer empId) {
		Employee byId = this.employeeRepository.getById(empId);
		byId.setName(employee.getName());
		byId.setCity(employee.getCity());
		byId.setMobile(employee.getMobile());
		Employee save = this.employeeRepository.save(byId);
		return save;
	}

	@Override
	public void deleteEmployeeById(Integer empId) {
		this.employeeRepository.deleteById(empId);
	}

	@Override
	public List<Employee> getEmployeeByName(String empName) {
		return this.employeeRepository.getEmployeeByName(empName);
	}

	@Override
	public List<Employee> getEmployeeByCity(String empCity) {
		return this.employeeRepository.getEmployeeByCity(empCity);
	}

	

}