package org.hope6537.springtest.jdkproxy;

import java.lang.reflect.Proxy;

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
		SalaryMananger mananger = new SalaryManagerImpl();
		// 动态代理模式
		SalaryInterceptor interceptor = new SalaryInterceptor(loggerService,
				privilegeService, security, mananger);
		// 1、目标类的类加载器
		// 2、目标类的所有接口
		// 3、拦截器
		SalaryMananger proxy = (SalaryMananger) Proxy.newProxyInstance(mananger
				.getClass().getClassLoader(), mananger.getClass()
				.getInterfaces(), interceptor);
		proxy.showSalary();// 代理对象的代理方法
	}
}
