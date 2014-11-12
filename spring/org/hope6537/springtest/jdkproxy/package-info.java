/** 
 *<pre>
 *使用动态代理的方法进行代码重用(做一个拦截器)
 *{@link org.hope6537.springtest.jdkproxy.LoggerService} -- 这是日志信息类
 *{@link org.hope6537.springtest.jdkproxy.Security} -- 安全信息类
 *{@link org.hope6537.springtest.jdkproxy.PrivilegeService} -- 权限信息类
 *{@link org.hope6537.springtest.jdkproxy.Privileges} -- 权限枚举
 *{@link org.hope6537.springtest.jdkproxy.SalaryMananger} -- 业务逻辑处理接口
 *{@link org.hope6537.springtest.jdkproxy.SalaryManagerImpl} -- 业务逻辑实现类
 *{@link org.hope6537.springtest.jdkproxy.SalaryInterceptor} -- 动态代理类(拦截器)
 *{@link org.hope6537.springtest.jdkproxy.Client} -- 客户端
 *<hr>
 *以上都是类的作用，具体进入细节看代码
 *<hr>
 *下面问题
 *1、拦截器的作用是什么:
 	*	1)、给目标类及其他的类赋值
 	*	2)、拦截器中的invoke方法的内容，就是代理对象方法体的内容
 	*	即说明，看似我们在执行proxy.showSalary()方法的内容，但实际上我们在操作拦截器的invoke方法里的内容
 *2、代理对象的方法体究竟是什么:
 	*	1)、 就是拦截器中invoke方法的内容
 *3、在拦截器中有一个invoke方法，第二个参数method究竟是什么时候传入的
 	*	1)、当代理对象调用方法的时候，method就被传入invoke方法体中
 *4、动态代理模式究竟解决了什么问题
 *</pre>
 */
package org.hope6537.springtest.jdkproxy;