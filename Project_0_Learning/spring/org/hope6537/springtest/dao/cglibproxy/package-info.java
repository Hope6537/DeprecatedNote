/** 
 *<pre>
 *cglib的動態代理目标类是代理类的父类
 *拦截器必须实现MethodInterceptor接口
 *而这个接口的intercept方法就是代理类的方法体
 *使用字节码增强机制创建代理对象
 *<hr>
 *jdk的动态代理是目标类和代理类实现了共同的接口
 *拦截器必须实现InvocationHandler接口，这个接口中invoke的方法体的内容就是代理对象方法体中的内容
 *当客户端用代理对象调用方法的时候，invoke方法执行
 *</pre>
 *具体查看:
 *{@link org.hope6537.springtest.dao.cglibproxy.PersonDaoImpl} -- 取代了PersonDao的实现
 *{@link org.hope6537.springtest.dao.cglibproxy.PersonDaoInterceptor} -- 使用cglib的动态代理
 */
package org.hope6537.springtest.dao.cglibproxy;