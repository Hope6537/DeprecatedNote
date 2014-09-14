/** 
 *<pre>
 *Spring在默认情况下创建bean是单例模式
 *单例模式我们要注意安全问题
 *例子如下:
 *{@link org.hope6537.springtest.scope.HelloWorld}
 *首先我们修改了HelloWorld类，添加了一个List用来装载数据
 *然后我们在测试类中添加如下代码
 *<hr>
 *HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
 *helloWorld.getList().add("String");<--在这里添加一个对象
 *System.out.println(helloWorld);
 *HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld");
 *helloWorld2.getList().add("String2");<--同样添加
 *System.out.println(helloWorld2);
 *System.out.println(helloWorld.getList().size());
 *<hr>
 *最后size的输出为2
 *也就是说可以在任何地方对这个list进行获取操作
 *处于单例模式下的这个list对于全体调用过该bean的对象来说，是共享的
 *如果该属性有数据，会引发线程安全问题
 *<hr>
 *在bean里面有一个配置scope="",用于设置模式
 *属性值:
 *prototype 原型模式-多例模式
 *request
 *session
 *singleton 单例模式(默认) 它的属性是共享的
 *一般情况下，把数据存放在方法中的变量里，方法完成后清除数据，存入持久层
 *<hr>
 *<b>在多例模式下，所有的bean都为延迟加载 当需要生成时，Spring才会生成</b>
 *
 *</pre>
 */
package org.hope6537.springtest.scope;