package com.honeywell.demo.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;





public class EmployeeRowMapper  implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(row.getLong("ID"));
		employee.setName(row.getString("Name"));
		employee.setAge(row.getInt("Age"));
		employee.setGender(row.getString("Gender"));
		return employee;
	}

}
