package org.hope6537.springtest.jdbc;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao {

	@Override
	public void savePerson() {
		this.getJdbcTemplate().execute(
				"insert into person (name) values ('Sam2')");
	}

	@Override
	public List<Person> getPersons() {
		return this.getJdbcTemplate().query("select * from person",
				new PersonRowMapper());
	}
}
