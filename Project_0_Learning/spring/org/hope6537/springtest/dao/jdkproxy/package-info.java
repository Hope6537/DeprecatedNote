/** 
 *<pre>
 *动态代理Dao层 模拟事务提交和操作的AOP编程
 *{@link org.hope6537.springtest.dao.jdkproxy.Person} -- 基本的对象类，等待存储
 *{@link org.hope6537.springtest.dao.jdkproxy.PersonDao} -- 持久层接口
 *{@link org.hope6537.springtest.dao.jdkproxy.PersonDaoImpl} -- 持久层接口实现类
 *{@link org.hope6537.springtest.dao.jdkproxy.PersonDaoInterceptor} -- 拦截器类
 *{@link org.hope6537.springtest.dao.jdkproxy.Transaction} -- 事务类，在这个业务中作为切面出现
 *{@link org.hope6537.springtest.dao.jdkproxy.Client} -- 客户端测试类
 *<hr>
 *通过动态代理，我们实现了代码块的重用
 *事务只需要关注事务
 *而持久层只关注持久层
 *最后通过拦截器进行整合
 *<hr>
 *代理对象的方法：
 *	1、就是拦截器中invoke方法体中的内容
 *	2、代理对象的方法把目标方法和切面整合到一起
 *	3、代理对象是由jdk的类库生成的
 *</pre>
 */
package org.hope6537.springtest.dao.jdkproxy;