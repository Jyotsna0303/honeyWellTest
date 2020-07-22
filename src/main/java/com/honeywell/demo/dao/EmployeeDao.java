package com.honeywell.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.honeywell.demo.entity.Employee;
import com.honeywell.demo.entity.EmployeeRowMapper;

@Transactional
@Repository
public class EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addEmployee(Employee employee) {
		// Add article
		String sql = "INSERT INTO Employee (ID, Name, Age, Gender) values (?, ?, ?,?)";
		jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getAge(), employee.getGender());

		// Fetch article id
		sql = "SELECT ID FROM Employee WHERE Name = ? and Gender=?";
		Long employeeId = jdbcTemplate.queryForObject(sql, Long.class, employee.getName(), employee.getGender());

		// Set article id
		employee.setId(employeeId);
	}

	public boolean isEmployeeExists(String name, String gender, int age) {
		String sql = "SELECT count(*) FROM Employee WHERE Name = ? and Gender=? and Age=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, name, gender, age);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	public List<Employee> getEmployees(String Gender, int minAge, int maxAge) {
		String sql = "SELECT * FROM Employee WHERE Gender = ? and Age >= ? and Age <= ? ";

		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
}
