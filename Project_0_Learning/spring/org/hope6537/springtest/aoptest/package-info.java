/** 
 *<pre>
 *Spring的AOP实现方式、
 *1、配置xml
 *2、关于切入点的判断形式
 *execution（modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern (param-pattern) throws-pattern?）
 *以空格作为分割 访问权限 返回类型 包-类位置 方法名称 参数名称 抛出异常 
 *其中为?标识的为可选项
 *例子如下
 *execution(* org.hope6537.controller..*.*(String,*) )
 *表示的是 在任意的 在org.hope6537.controller包(及其子包)下的所有的类，有一个String参数和任意一个其他类型参数的所有的方法
 *<hr>
 *原理
 *1、加载配置文件，启动Spring容器
 *2、Spring容器为bean创建对象
 *3、解析aop配置,同时解析切入点表达式
 *4、看纳入Spring管理的那个类和切入点表达式匹配，如果匹配就会为该类创建实例对象
 *5、代理对象方法体的形成就是目标方法和通知
 *6、客户端在getBean时，如果该bean有代理对象，则返回该代理对象，如果没有代理对象就返回原来的对象
 *<hr>
 *说明：
 *如果目标类实现了接口 Spring容器将采用JDK代理方式
 *如果目标类没有实现接口 Spring容器将采用cglib代理方式
 *</pre>
 */
package org.hope6537.springtest.aoptest;