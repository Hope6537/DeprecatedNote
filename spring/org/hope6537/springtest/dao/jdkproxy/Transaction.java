package org.hope6537.springtest.dao.jdkproxy;

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

	public void beginTransaction() {
		System.out.println("The Transaction has began");
	}

	public void commit() {
		System.out.println("Commit Now");
	}

}
