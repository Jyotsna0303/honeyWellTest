package com.honeywell.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.demo.dao.EmployeeDao;
import com.honeywell.demo.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public synchronized boolean addEmployee(Employee employee) {
		if (employeeDao.isEmployeeExists(employee.getName(), employee.getGender(), employee.getAge())) {
	    	   return false;
	       } else {
	    	   employeeDao.addEmployee(employee);
	    	   return true;
	       }
	}
	
	public List<Employee> getEmployees(Map<String,String> employeesQuery){
		if  ((employeesQuery.get("gender").equalsIgnoreCase("F")|| employeesQuery.get("gender").equalsIgnoreCase("M") || employeesQuery.get("gender").equalsIgnoreCase("OTHER"))
				&& Integer.parseInt(employeesQuery.get("minage"))>0
				&&Integer.parseInt(employeesQuery.get("maxage"))>0) {
				return employeeDao.getEmployees(employeesQuery.get("gender"),Integer.parseInt(employeesQuery.get("minage")),Integer.parseInt(employeesQuery.get("maxage")));
		}
		else
		return new ArrayList<Employee>();
	}

}

