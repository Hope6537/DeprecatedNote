package org.hope6537.springtest.jdkproxy;

/** 
 * <p>Describe: 我们假定这是用户权限类</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午12:34:00</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class PrivilegeService {

	/**
	 * <p>Describe: 具体权限</p>
	 * <p>Using: </p>
	 */
	private Privileges assess;

	/**
	 * <p>Describe: 获取具体权限</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年9月14日下午12:35:40 </p>
	 * <p>Author:Hope6537</p>
	 * @return
	 * @see
	 */
	public String getAssess() {
		return assess.toString();
	}

	public void setAssess(Privileges assess) {
		this.assess = assess;
	}

	/**
	 * <p>Describe: 默认构造方法使用默认权限<p>
	 */
	public PrivilegeService() {
		this.assess = Privileges.GUEST;
	}

	public PrivilegeService(Privileges assess) {
		this.assess = assess;
	}
	
}
