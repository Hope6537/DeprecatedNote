package org.hope6537.springtest.dao.cglibproxy;

import org.junit.Test;

public class Client {

	@Test
	public void test() {
		@SuppressWarnings("unused")
		Person person = new Person(2, "Tom");
		Transaction transaction = new Transaction();
		PersonDaoImpl target = new PersonDaoImpl();
		PersonDaoInterceptor interceptor = new PersonDaoInterceptor(
				transaction, target);
		PersonDaoImpl proxy = (PersonDaoImpl) interceptor.createProxy();
		proxy.deletePerson(person);
	}

}
