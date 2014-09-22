package org.hope6537.springtest.jdbc.transaction.annotation;

import java.lang.reflect.Method;

import org.junit.Test;

/** 
 * <p>Describe: 基本的对象类，没啥好说的</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午3:00:25</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Person {

	private long pid;
	private String pname;

	public Person() {
	}
	
	public Person(long pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + "]";
	}

}
