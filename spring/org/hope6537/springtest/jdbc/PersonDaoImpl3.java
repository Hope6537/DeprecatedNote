/*package org.hope6537.springtest.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDaoImpl3 extends JdbcTemplate implements PersonDao {

	private PersonDaoImpl3(DataSource datasource) {
		super(datasource);
	}

	@Override
	public void savePerson() {
		this.execute("insert into person (name) values ('Sam2')");
	}

}
*/