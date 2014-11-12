package org.hope6537.springtest.aop.annotation;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/** 
 * <p>Describe: 模拟的事务层，将作为切面出现</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午2:45:52</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Component("transaction")
@Aspect
// 说明他是切类
public class Transaction {

	/**
	 * <p>Describe: 方法签名 相当于aop config</p>
	 * <p>Using: 1、返回值为void 2、修饰符最好为private</p>
	 * <p>How To Work: id为方法名 即"signal()"</p>
	 * <p>DevelopedTime: 2014年9月17日下午1:58:38 </p>
	 * <p>Author:Hope6537</p>
	 * @see
	 */
	@Pointcut("execution (* org.hope6537.springtest.aop.annotation.PersonDaoImpl.*(..))")
	private void signal() {
	}

	@Before("signal()")
	public void beginTransaction() {
		System.out.println("begin transaction");
	}

	@AfterReturning(returning = "val", pointcut = "signal()")
	public void commit(Object val) {
		System.out.println("commit");
	}

	@Around(argNames = "", value = "")
	public void around() {

	}
}
