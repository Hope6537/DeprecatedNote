package org.hope6537.springtest.di.annotation;

import org.hope6537.utils.SpringHelper;
import org.junit.*;

public class Clinet extends SpringHelper {

	public Clinet() {
		super("org/hope6537/springtest/di/annotation/applicationContext.xml");
	}

	@Test
	public void test() {
		Person person = (Person) context.getBean("person");
		person.toString();
		person.say();
	}
}
