package org.hope6537.spring_hibernate.service;

import org.hope6537.spring_hibernate.dao.PersonDao;
import org.hope6537.spring_hibernate.model.Person;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void savePerson(Person person) {
		this.personDao.savePerson(person);
	}

}
