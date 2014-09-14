package org.hope6537.springtest.aop;

/** 
 * <p>Describe: 我们假定这是安全访问控制类</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午12:33:28</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Security implements Interceptor {
	public void validSecurity() {
		System.out.println("=====Testing=====");
	}

	@Override
	public void interceptor() {
		System.out.println("Security");
	}

}
