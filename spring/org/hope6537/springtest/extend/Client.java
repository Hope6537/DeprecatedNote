package org.hope6537.springtest.extend;

import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class Client extends SpringHelper {

	public Client() {
		super("org/hope6537/springtest/extend/applicationContext.xml");
	}

	@Test
	public void test(){
		Student student = (Student) context.getBean("student");
		student.say();
	}
}
