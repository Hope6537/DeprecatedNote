package org.hope6537.springtest.jdbc.transaction.annotation;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class PersonServiceImpl implements PersonService {

	private PersonDao dao;

	public void setDao(PersonDao dao) {
		this.dao = dao;
	}

	@Override
	public void savePerson() {
		this.dao.savePerson();
	}
}
