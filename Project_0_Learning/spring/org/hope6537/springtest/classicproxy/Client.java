package org.hope6537.springtest.classicproxy;

import org.junit.Test;

public class Client {

	@Test
	public void test() {
		LoggerService loggerService = new LoggerService();
		PrivilegeService privilegeService = new PrivilegeService();
		privilegeService.setAssess(Privileges.DEFAULT);
		Security security = new Security();
		SalaryMananger mananger = new SalaryManagerImpl();
		// 代理模式
		SalaryManagerProxy proxy = new SalaryManagerProxy(loggerService,
				security, privilegeService, mananger);
		proxy.showSalary();
	}

}
