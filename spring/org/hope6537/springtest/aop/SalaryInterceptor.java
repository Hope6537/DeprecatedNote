package org.hope6537.springtest.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/** 
 * <p>Describe: 拦截器工作类</p>
 * <p>Using: 使用Java的反射机制进行重用</p>
 * <p>DevelopedTime: 2014年9月14日下午1:42:59</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class SalaryInterceptor implements InvocationHandler {

	private LoggerService loggerService;
	private PrivilegeService privilegeService;
	private Security security;
	private Object target;

	private List<Interceptor> interceptorList;

	public SalaryInterceptor(LoggerService loggerService,
			PrivilegeService privilegeService, Security security,
			Object target, List<Interceptor> interceptorList) {
		super();
		this.loggerService = loggerService;
		this.privilegeService = privilegeService;
		this.security = security;
		this.target = target;
		this.interceptorList = interceptorList;
	}

	/*
	 * 1、 启动日志2、安全性检查3、权限检查 (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 * 
	 * @Change:Hope6537
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// 目标方法可以有很多个切面
		for (Interceptor interceptor : interceptorList) {
			interceptor.interceptor();
		}
		method.invoke(target, args);
		return null;

	}

}
