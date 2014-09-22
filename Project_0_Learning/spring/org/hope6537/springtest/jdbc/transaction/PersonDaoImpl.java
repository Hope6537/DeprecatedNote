package org.hope6537.springtest.jdbc.transaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao {

	@Override
	public void savePerson() {
		this.getJdbcTemplate().execute(
				"insert into person (name) values ('before')");
		this.getJdbcTemplate().execute(
				"insert into person (name) values ('after')");
	}

}
