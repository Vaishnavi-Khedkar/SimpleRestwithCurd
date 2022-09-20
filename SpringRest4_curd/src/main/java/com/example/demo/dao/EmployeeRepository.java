package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from emp3 where name=?", nativeQuery = true)
	public List<Employee> getEmployeeByName(String empName);

	@Query(value = "select * from emp3 where city=?", nativeQuery = true)
	public List<Employee> getEmployeeByCity(String empCity);

}
