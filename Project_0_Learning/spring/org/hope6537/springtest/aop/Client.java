package org.hope6537.springtest.aop;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 
 *<pre>
 *使用动态代理进行代码重用
 *变成一个拦截器
 *</pre>
 * <p>Describe: 测试客户端</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午1:53:13</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Client {

	@Test
	public void test() {
		LoggerService loggerService = new LoggerService();
		PrivilegeService privilegeService = new PrivilegeService();
		privilegeService.setAssess(Privileges.ADMIN);
		Security security = new Security();

		// 添加切面List
		List<Interceptor> interceptorList = new ArrayList<Interceptor>();
		interceptorList.add(security);
		interceptorList.add(loggerService);
		interceptorList.add(privilegeService);
		// 然后导入到拦截器
		SalaryMananger mananger = new SalaryManagerImpl();
		SalaryInterceptor interceptor = new SalaryInterceptor(loggerService,
				privilegeService, security, mananger, interceptorList);
		SalaryMananger proxy = (SalaryMananger) Proxy.newProxyInstance(mananger
				.getClass().getClassLoader(), mananger.getClass()
				.getInterfaces(), interceptor);
		proxy.showSalary();
	}
}
