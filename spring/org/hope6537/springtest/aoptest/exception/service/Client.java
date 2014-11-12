package org.hope6537.springtest.aoptest.exception.service;

import org.junit.Test;

public class Client {

	@Test
	public void test() {
		try {
			ServiceMapping mapping = new ServiceMapping();
			mapping.setServiceClass("org.hope6537.springtest.aoptest.exception.service.StudentServiceImpl");
			mapping.setMethod("savePerson");
			ServiceInvocation.execution(mapping);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
