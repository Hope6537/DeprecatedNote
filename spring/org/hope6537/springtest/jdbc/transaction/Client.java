package org.hope6537.springtest.jdbc.transaction;

import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class Client extends SpringHelper {

	@Test
	public void test() {
		PersonService personService = (PersonService) context
				.getBean("personService");
		personService.savePerson();
	}

}
