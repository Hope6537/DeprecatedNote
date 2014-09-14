package org.hope6537.springtest.scope;

import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class ScopeTest extends SpringHelper {

	public ScopeTest() {
		super("org/hope6537/springtest/scope/applicationContext.xml");
	}

	@Test
	public void test() {
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		helloWorld.getList().add("String");
		System.out.println(helloWorld);
		HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld");
		helloWorld2.getList().add("String2");
		System.out.println(helloWorld2);

		System.out.println(helloWorld.getList().size());

	}
}
