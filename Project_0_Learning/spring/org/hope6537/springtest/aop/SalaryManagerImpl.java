package org.hope6537.springtest.aop;

/** 
 * <p>Describe: 业务逻辑实现类</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午1:16:50</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class SalaryManagerImpl implements SalaryMananger {

	@Override
	public void showSalary() {
		System.out.println("Showing the Manager Cost");
		System.out.println("");
	}
}
