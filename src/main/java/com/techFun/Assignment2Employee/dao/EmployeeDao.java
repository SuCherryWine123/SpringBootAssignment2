package com.techFun.Assignment2Employee.dao;

import java.util.List;

import com.techFun.Assignment2Employee.model.Employee;
public interface EmployeeDao{
	void create(Employee employee);
	List<Employee> findAll();
	void delete(int id);
	Employee getOne(Integer id);
	void edit(Employee employee);
	List<Employee> findByName(String name);
}
