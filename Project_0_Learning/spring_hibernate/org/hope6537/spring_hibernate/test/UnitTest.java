package org.hope6537.spring_hibernate.test;

import org.hope6537.spring_hibernate.model.Person;
import org.hope6537.spring_hibernate.service.PersonService;
import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class UnitTest extends SpringHelper {

	public UnitTest() {
		super("classpath:applicationContext.xml");
	}

	@Test
	public void test() {
		PersonService personService = (PersonService) context
				.getBean("personService");
		Person person = new Person();
		person.setPname("wwww");
		person.setPsex("s");
		personService.savePerson(person);
	}
}
