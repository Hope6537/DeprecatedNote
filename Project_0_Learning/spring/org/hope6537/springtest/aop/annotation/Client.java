package org.hope6537.springtest.aop.annotation;

import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class Client extends SpringHelper {

	@Test
	public void test() {
		
		PersonDao personDao = (PersonDao) context.getBean("personDao");
		personDao.savePerson(new Person());
	}
}
