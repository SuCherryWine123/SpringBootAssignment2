package com.techFun.Assignment2Employee.model;

public class Employee {
	private Integer id;
	private String name;
	private Integer age;
	private String city;
	
	public Employee() {
	
	}
	
	public Employee(String name,Integer age,String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}
	
	public Employee(String name,Integer age,String city,Integer id) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}