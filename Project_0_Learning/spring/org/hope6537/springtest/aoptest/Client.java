package org.hope6537.springtest.aoptest;

import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class Client extends SpringHelper {

	@Test
	public void test() {
		
		PersonDao personDao = (PersonDao) context.getBean("personDao");
		personDao.deletePerson(new Person());
	}
}
