package org.hope6537.springtest.aoptest.salary;

import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class Client extends SpringHelper {

	@Test
	public void test() {
		SalaryMananger mananger = (SalaryMananger) context
				.getBean("salaryMananger");
		mananger.showSalary();
	}
}
