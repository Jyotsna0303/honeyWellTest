package com.honeywell.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.honeywell.demo.entity.Employee;
import com.honeywell.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("employee")
	public ResponseEntity<Void> addArticle(@RequestBody Employee employee, UriComponentsBuilder builder) {
        boolean flag = employeeService.addEmployee(employee);
        if (flag == true) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}
	
	@GetMapping("employees")
	public ResponseEntity<List<Employee>> getEmployee(@RequestParam Map<String, String> employeesQuery){
		
		List<Employee> list = employeeService.getEmployees(employeesQuery);
		if (list.isEmpty())
		{
			return new ResponseEntity<List<Employee>>(list, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		
		
	}
}