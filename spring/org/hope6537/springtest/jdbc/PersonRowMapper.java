package org.hope6537.springtest.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person> {
	@Override
	public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
		Person person = new Person();
		person.setPid(arg0.getInt("id"));
		person.setPname(arg0.getString("name"));
		return person;
	}
}
