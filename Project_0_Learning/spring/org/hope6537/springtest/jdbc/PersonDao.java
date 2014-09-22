package org.hope6537.springtest.jdbc;

import java.util.List;

public interface PersonDao {

	public void savePerson();

	public List<Person> getPersons();

}
