package org.hope6537.springtest.dao.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/** 
 * <p>Describe: 拦截器类cglib版本</p>
 * <p>Using: 通过cglib动态代理的方式进行拦截器业务实现</p>
 * <p>DevelopedTime: 2014年9月14日下午2:59:20</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class PersonDaoInterceptor implements MethodInterceptor {

	private Transaction transaction;
	private Object target;

	public PersonDaoInterceptor(Transaction transaction, Object target) {
		super();
		this.transaction = transaction;
		this.target = target;
	}

	public Object createProxy() {
		Enhancer enhancer = new Enhancer();// 增强的字节码的机制
		enhancer.setSuperclass(this.target.getClass());// 增加目标类为代理类的父类
		enhancer.setCallback(this);
		return enhancer.create();// 产生代理对象
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[],
	 * net.sf.cglib.proxy.MethodProxy)
	 * 
	 * @Change:Hope6537
	 */
	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy arg3) throws Throwable {
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
