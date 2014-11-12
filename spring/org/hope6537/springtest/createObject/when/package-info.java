/** 
 *<pre>
 *我们在这个包中讨论关于Spring创建对象的时机
 *通过配置文件中的
 *(bean id="helloWorld" class="org.hope6537.springtest.createObject.when.HelloWorld")设置
 *以及{@link org.hope6537.springtest.createObject.when.Client}类中的测试结果
 *我们可以看到Spring在加载的时候，它所持有的对象将将会同时生成
 *<hr>
 *但是在对于某些特定的持有对象，它的创建开销过大，所以我们需要进行延迟加载
 *bean中的lazy-init属性值可以实现这个功能
 *设定值如下
 *default 在启动时创建 == false;
 *true getBean时创建; 
 *false 启动容器的时候创建;
 *即可解决问题
 *<hr>
 *对于延迟加载优点:
 *1、可以防止数据过早的停留在内存中
 *2、了解何时创建对象
 *缺点：
 *1、如果Spring配置文件中，该bean的配置有错误，那么在Tomcat服务器启动时，我们是发现不了的
 *对于正常加载来说，优缺点和延迟加载互补
 *<hr>
 *</pre>
 */
package org.hope6537.springtest.createObject.when;