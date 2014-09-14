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
 *</pre>
 */
package org.hope6537.springtest.aoptest;