/** 
 *<pre>
 *Scan扫描实战
 *1、通过制定base-package来确定区域
 *2、使用Component注解定义类是否为bean
 *3、会在指定的区域中寻找类中是否有容器（@Component）注解
 *4、如果该注解没有写任何的属性，那么扫描的时候会按照类名的名称按照格式进行扫描匹配
 *5、格式为类名首字母小写，其余照旧
 *6、如果注解内部定义了字符串，那么getBean的时候将会使用该字符串来进行获取对象
 *7、
 *</pre>
 */
package org.hope6537.springtest.di.scan;

