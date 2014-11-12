package org.hope6537.springtest.dao.jdkproxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class Client {

	@Test
	public void test() {
		@SuppressWarnings("unused")
		Person person = new Person(2, "Tom");
		Transaction transaction = new Transaction();
		PersonDao target = new PersonDaoImpl();
		PersonDaoInterceptor interceptor = new PersonDaoInterceptor(
				transaction, target);
		PersonDao proxy = (PersonDao) Proxy.newProxyInstance(target.getClass()
				.getClassLoader(), target.getClass().getInterfaces(),
				interceptor);
		proxy.queryPerson("");
	}

}
