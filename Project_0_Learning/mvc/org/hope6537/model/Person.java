package org.hope6537.model;

import java.io.Serializable;

/** 
 * <p>Describe: 示例数据容器</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月12日下午8:20:31</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Person implements Serializable {

	/**
	 * <p>Describe: ID</p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = 3917491415570298944L;

	/**
	 * <p>Describe: 主键id</p>
	 * <p>Using: 用于识别唯一标示</p>
	 */
	private Integer pid;

	/**
	 * <p>Describe: 数据对象名称</p>
	 * <p>Using: </p>
	 */
	private String pname;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
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
