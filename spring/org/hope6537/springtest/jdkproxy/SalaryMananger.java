package org.hope6537.springtest.jdkproxy;

/** 
 * <p>Describe: 具体的业务逻辑组合接口</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午1:04:55</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public interface SalaryMananger {

	public void showSalary();
	/*
	 * 
	 * private LoggerService loggerService; private PrivilegeService
	 * privilegeService; private Security security;
	 * 
	 * public SalaryMananger(LoggerService loggerService, PrivilegeService
	 * privilegeService, Security security) { super(); this.loggerService =
	 * loggerService; this.privilegeService = privilegeService; this.security =
	 * security; }
	 * 
	 * public void run() { loggerService.getLogger(); security.validSecurity();
	 * if (Privileges.ADMIN .toString().equals(privilegeService .getAssess())) {
	 * System.out.println( "================================="); System.out
	 * .println("=======This is the Info==========" ); System.out.println(
	 * "=======Zhang:$50000=============="); } else { System.out.println(
	 * "Sorry,You don't have the Permisson"); } }
	 */
}
