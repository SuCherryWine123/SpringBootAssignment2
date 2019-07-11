package com.techFun.Assignment2Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techFun.Assignment2Employee.dao.EmployeeDao;
import com.techFun.Assignment2Employee.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public void create(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.create(employee);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeeDao.delete(id);
	}

	@Override
	public Employee getOne(Integer id) {
		// TODO Auto-generated method stub
		return employeeDao.getOne(id);
	}

	@Override
	public void edit(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.edit(employee);
	}

	@Override
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return employeeDao.findByName(name);
	}
	
}