package com.example.demo.controller;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployees(@RequestBody Employee employee) {
		Employee saveEmployees = this.employeeService.saveEmployees(employee);
		return ResponseEntity.ok(saveEmployees);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> allEmployee = this.employeeService.getAllEmployee();
		return ResponseEntity.ok(allEmployee);
	}
	
	@GetMapping("/byid/{empId}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@RequestBody @PathVariable("empId") Integer empId) {	
		Optional<Employee> employeeById = this.employeeService.getEmployeeById(empId);
	    return ResponseEntity.ok().body(employeeById);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<Employee> updateEmployeeById( @RequestBody  Employee employee, @PathVariable Integer empId) {
		Employee updateEmployeeById = this.employeeService.updateEmployeeById(employee, empId);
		return ResponseEntity.ok(updateEmployeeById);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@RequestBody @PathVariable Integer empId){
    this.employeeService.deleteEmployeeById(empId);
	return ResponseEntity.ok("Record deleted sucessfully");
		
	}
	
	@GetMapping("/byname/{empName}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestBody @PathVariable String empName){
		List<Employee> employeeByName = this.employeeService.getEmployeeByName(empName);
		return ResponseEntity.ok(employeeByName);
	}
	
	@GetMapping("/city/{empCity}")
	public  ResponseEntity<List<Employee>> getEmployeeByCity(@RequestBody @PathVariable String empCity){
		List<Employee> employeeByCity = this.employeeService.getEmployeeByCity(empCity);
		return ResponseEntity.ok(employeeByCity);
	}
}