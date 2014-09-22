package org.hope6537.springtest.jdbc;

import java.util.List;

import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class Client extends SpringHelper {

	@Test
	public void testDataSource() throws ClassNotFoundException {
		PersonDao personDao = (PersonDao) context.getBean("personDao");
		List<Person> list = personDao.getPersons();
		System.out.println(list.toString());
	}
}
