package org.hope6537.springtest.di.scan;

import org.hope6537.utils.SpringHelper;
import org.junit.*;

public class Clinet extends SpringHelper {

	public Clinet() {
		super("org/hope6537/springtest/di/scan/applicationContext.xml");
	}

	@Test
	public void test() {
		// 获取bean的名称要和组件名称相同
		Person person = (Person) context.getBean("untiyPerson");
		person.toString();
		person.say();
	}
}
