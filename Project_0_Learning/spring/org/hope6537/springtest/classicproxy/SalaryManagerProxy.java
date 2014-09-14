package org.hope6537.springtest.classicproxy;

/** 
 * <pre>
 * 代理对象将几个功能类聚集起来
 * </pre>
 * <p>Describe: 任务的代理类</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午1:07:28</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class SalaryManagerProxy implements SalaryMananger {

	private LoggerService loggerService;
	private Security security;
	private PrivilegeService privilegeService;
	private SalaryMananger mananger;

	/**
	 * <p>Describe: 利用构造函数赋值<p>
	 * @param loggerService
	 * @param security
	 * @param privilegeService
	 * @param mananger
	 */
	public SalaryManagerProxy(LoggerService loggerService, Security security,
			PrivilegeService privilegeService, SalaryMananger mananger) {
		super();
		this.loggerService = loggerService;
		this.security = security;
		this.privilegeService = privilegeService;
		this.mananger = mananger;
	}

	/* (non-Javadoc)
	 * @see org.hope6537.springtest.jdkproxy.SalaryMananger#showSalary()
	 * @Change:Hope6537
	 * 然后在实现的方法中重定义
	 */
	@Override
	public void showSalary() {
		loggerService.getLogger();
		security.validSecurity();
		if (Privileges.ADMIN.toString().equals(privilegeService.getAssess())) {
			mananger.showSalary();
		} else {
			System.out.println("No Role");
		}
	}
}
