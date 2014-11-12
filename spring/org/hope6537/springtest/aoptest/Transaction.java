package org.hope6537.springtest.aoptest;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/** 
 * <p>Describe: 模拟的事务层，将作为切面出现</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午2:45:52</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Transaction {

	/**
	 * <pre>
	 * 前置通知方法
	 * 通过JoinPoint获取连接点的信息
	 * 在具体的业务使用中很有意义
	 * </pre>
	 */
	public void beginTransaction(JoinPoint joinPoint) {
		joinPoint.getArgs();// 得到方法的参数
		System.out.println(joinPoint.getSignature().getName());// 获得方法的名字
		System.out.println("The Transaction has began");
	}

	/**
	 *<pre>
	 *后置通知方法体
	 *通过后置通知获取目标方法的返回值
	 *如果目标方法遇到异常，不执行
	 *</pre>
	 */
	public void commit(JoinPoint joinPoint, Object val) {
		List<Person> personList = (List<Person>) val;
		System.out.println(personList.toString());
		System.out.println("Commit Now");
	}

	/**
	 *<pre>
	 *最终通知方法体
	 *区别于后置方法的是
	 *如果目标方法遇到异常，照样执行
	 *</pre>
	 */
	public void finallyMethod() {
		System.out.println("finally methods");
	}

	/**
	 *<pre>
	 *异常通知方法体
	 *很重要
	 *</pre>
	 */
	public void exceptionMethod(Throwable ex) {
		System.out.println(ex.getMessage());
	}

	/**
	 *<pre>
	 *环绕通知方法体
	 *</pre>
	 */
	public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		System.out.println("Start");
		proceedingJoinPoint.proceed();// 调用目标类的目标方法 可以控制目标方法的执行
		// 相当于拦截器的invoke方法，能控制目标方法的执行
		System.out.println("End");
	}
}
