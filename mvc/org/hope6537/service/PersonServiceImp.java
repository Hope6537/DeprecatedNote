package org.hope6537.service;

import org.hope6537.dao.PersonDao;
import org.hope6537.model.Person;

public class PersonServiceImp implements PersonService {

	/**
	 * <p>Describe: 等待Spring注入</p>
	 */
	PersonDao dao;

	@Override
	public int savePerson(Person person) {
		return dao.save(person);
	}

	public PersonDao getDao() {
		return dao;
	}

	public void setDao(PersonDao dao) {
		this.dao = dao;
	}

}