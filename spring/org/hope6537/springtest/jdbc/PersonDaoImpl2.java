/*package org.hope6537.springtest.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImpl2 implements PersonDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void savePerson() {
		this.getJdbcTemplate().execute(
				"insert into person (name) values ('Sam2')");
	}

}
*/