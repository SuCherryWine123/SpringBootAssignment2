package com.techFun.Assignment2Employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techFun.Assignment2Employee.mapper.EmployeeMapper;
import com.techFun.Assignment2Employee.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void create(Employee employee) {
		// TODO Auto-generated method stub
		String insertemployee = "insert into employee(name,age,city) values (?,?,?)";
		jdbcTemplate.update(insertemployee,employee.getName(),employee.getAge(),employee.getCity());
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM employee";
		List<Employee> result = jdbcTemplate.query(sql, new EmployeeMapper());
		return result;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM employee WHERE id=?";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public Employee getOne(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM employee WHERE id= ?";
		Employee result = jdbcTemplate.queryForObject(sql, new Object[] {id},new EmployeeMapper());
		return result;
	}

	@Override
	public void edit(Employee employee) {
		// TODO Auto-generated method stub
		String sql = "update employee SET name=?,age=?,city=? WHERE id=?";
		jdbcTemplate.update(sql,employee.getName(),employee.getAge(),employee.getCity(),employee.getId());
	}

	@Override
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "SELECT DISTINCT * FROM  employee WHERE "
				+ "UPPER(name) LIKE UPPER(\'%" + name + "%\')";
		List<Employee> result = jdbcTemplate.query(sql, new EmployeeMapper());
		return result;
	}
	
}