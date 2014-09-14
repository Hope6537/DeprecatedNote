package org.hope6537.springtest.dao.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
 * <p>Describe: 拦截器类</p>
 * <p>Using: 通过动态代理的方式进行拦截器业务实现</p>
 * <p>DevelopedTime: 2014年9月14日下午2:59:20</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class PersonDaoInterceptor implements InvocationHandler {

	private Transaction transaction;
	private Object target;

	public PersonDaoInterceptor(Transaction transaction, Object target) {
		super();
		this.transaction = transaction;
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 * 
	 * @Change:Hope6537
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object obj;// 如果意外出现了返回类型
		boolean isCUD = method.getName().equals("savePerson")
				|| method.getName().equals("updatePerson")
				|| method.getName().equals("deletePerson");
		if (isCUD) {
			// 符合条件，切面插入
			transaction.beginTransaction();
			obj = method.invoke(target, args);
			transaction.commit();
		} else {
			obj = method.invoke(target, args);
		}
		return obj;
	}
}
