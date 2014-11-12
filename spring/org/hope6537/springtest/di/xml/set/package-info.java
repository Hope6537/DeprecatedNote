/** 
 *<pre>
 *关于Spring的依赖注入的set方法
 *如{@link org.hope6537.springtest.di.xml.set.Person}类所示
 *定义了一堆属性和set get方法
 *然后欠登的去xml里配置
 *<hr>
 *property name="pid" value="5089895637945"
 *property name="pname" value="王二麻子"
 *property name="student">
 *	ref bean="student" /> <--这个student也是个实例bean
 *property>
 *<hr>
 *基本数据类型使用value
 *引用数据类型使用ref来指示使用哪个bean
 *而关于一些例如list set map properties的配置请参阅
 *{@link org.hope6537.springtest.di.xml.set.applicationContext.xml}
 *</pre>
 */
package org.hope6537.springtest.di.xml.set;