package org.hope6537.spring_hibernate.dao;

import org.hibernate.SessionFactory;
import org.hope6537.spring_hibernate.model.Person;

public class PersonDaoImpl implements PersonDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void savePerson(Person person) {
		this.sessionFactory.getCurrentSession().persist(person);
	}

}
