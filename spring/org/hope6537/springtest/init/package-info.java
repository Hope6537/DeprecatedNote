/** 
 *<pre>
 *Spring的生成和销毁生命周期
 *1、定义init-method 该方法由Spring容器来执行
 *2、定义destory-method 
 *如果该bean为单例，Spring将会在负责Spring关闭的时候销毁
 *如果该bean为多例，Spring将不会负责销毁
 *<hr>
 *观察{@link org.hope6537.springtest.init.Client}类我们可以看到
 *1、先执行构造方法
 *2、执行init方法
 *但是我们观察到我们没有执行destory方法
 *<hr>
 *ClassPathXmlApplicationContext c = (ClassPathXmlApplicationContext) context;
 *c.close();
 *<hr>
 *通过这样我们看到了当Spring关闭的时候是如何销毁容器的
 *<hr>
 *<b>如果我们想让Spring来完全控制对象的生命周期，那么应当设定单例模式</b>
 *</pre>
 */
package org.hope6537.springtest.init;

