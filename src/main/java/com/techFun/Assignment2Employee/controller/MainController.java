package com.techFun.Assignment2Employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techFun.Assignment2Employee.model.Employee;
import com.techFun.Assignment2Employee.service.EmployeeService;

@Controller
public class MainController{
	@Autowired
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private static List<Employee> employees = new ArrayList<Employee>();
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		List<Employee> employees = employeeService.findAll();
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("employees", employees);
		return "index";
	}
	
	@RequestMapping(value = { "/employee" }, method = RequestMethod.GET)
	public String employee(Model model) {
		//List<Employee> employees = employeeService.findAll();
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		//model.addAttribute("employees", employees);
		return "employee";
	}
	
	@RequestMapping(value = { "/employee" }, method = RequestMethod.POST)
	public String saveEmployee(Model model,//
			@ModelAttribute("employee") Employee employee){
		String name = employee.getName();
		Integer age = employee.getAge();
		String city = employee.getCity();
		if(name != null && name.length() > 0 //
		   && age != null //
		   && city != null && city.length() > 0) {
			Employee newEmployee = new Employee(name,age,city);
			employees.add(newEmployee);
			employeeService.create(newEmployee);
			return "redirect:/index";
		}
		return "employee";
	}
	
	@RequestMapping(value = "/employeeEdit/{id}", method = RequestMethod.GET)
	public String editEmployee(@ModelAttribute("id") Integer id, Model model) {
		Employee data = employeeService.getOne(id);
		Employee employee = new Employee();
		employee.setName(data.getName());
		employee.setAge(data.getAge());
		employee.setCity(data.getCity());
		employee.setId(data.getId());
		model.addAttribute("employee", employee);
		return "employeeEdit";
	}
	
	@RequestMapping(value = "/employeeEdit", method = RequestMethod.POST)
	public String editEmployee(Model model, //
			@ModelAttribute("employee") Employee employee) {
		String name = employee.getName();
		Integer age = employee.getAge();
		String city = employee.getCity();
		if(name != null && name.length() > 0 //
		   && age != null //
		   && city != null && city.length() > 0) {
			Employee newEmployee = new Employee(name,age,city,employee.getId());
			employees.add(newEmployee);
			employeeService.edit(newEmployee);
			return "redirect:/index";
		}
		return "employee";
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}")
	public String delete(@ModelAttribute("id") Integer id) {
		employeeService.delete(id);
		return "redirect:/index";
	}
	
	@RequestMapping(value = ("/employeeSearch"), method = RequestMethod.GET)
	public String searchName(Model model, @ModelAttribute("employee") Employee employee) {
		String name = employee.getName();
		List<Employee> employees = employeeService.findByName(name);
		model.addAttribute("employees", employees);
		return "index";
	}
	
}