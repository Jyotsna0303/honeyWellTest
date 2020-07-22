package com.honeywell.demo.entity;

public class Employee {

	private Long id;
	private String Name;
	private int age;
	private String gender;
	
	
	public Employee() {
		super();
	}
	
	public Employee(Long id, String name, int age, String gender) {
		super();
		this.id = id;
		Name = name;
		this.age = age;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}