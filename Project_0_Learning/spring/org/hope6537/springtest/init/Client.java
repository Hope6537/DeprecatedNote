package org.hope6537.springtest.init;

import org.hope6537.utils.SpringHelper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client extends SpringHelper {

	public Client() {
		super("org/hope6537/springtest/init/applicationContext.xml");
	}

	@Test
	public void test() {
		ClassPathXmlApplicationContext c = (ClassPathXmlApplicationContext) context;
		c.close();
	}
}
