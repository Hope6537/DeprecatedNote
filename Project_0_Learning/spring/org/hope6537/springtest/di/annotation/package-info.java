/** 
 *<pre><font face = "Microsoft-Yahei" size = 2>
 *Spring的注解实战
 *注意：只能用于引用数据类型
 *0、导入命名空间
 *1、导入注解解析器
 *2、导入对象到Spring容器里
 *3、启动Spring容器，加载配置文件
 *4、加载并创建beans对象
 *5、开启依赖注入的注解解析
 *<b>6、会在纳入Spring管理的bean的范围内，看那些bean的属性上有resource注解</b>
 *7、如果resource注解的name属性值为空,则会把注解所在的属性的名称作为识别Spring中bean的id进行匹配
 *8、如果匹配成功，则把id匹配对应的对象赋值给属性
 *9、如果匹配不成功，那么将会按照<b>类型</b>进行匹配
 *10、如果再不成功，那么报错
 *11、如果name属性不为空，那么将会和id匹配，成功赋值，不成功直接报错(不找类型了)
 *<hr>
 *注入bean注解:
 *经典的第一种方法
 *@Resource(name = "student")
 *按照类型进行匹配
 *@Autowired
 *按照名字进行匹配
 *@Qualifier("student")
 *<hr>
 *init-destory注解
 *<code>
 *init-method注解
 *@PostConstruct
 *public void init() {
 *System.out.println("init");
 *}
 *destory-method注解
 *@PreDestroy
 *public void destory() {
 *	System.err.println("destory");
 *}
 *</code>
 *
 *</font></pre>
 */
package org.hope6537.springtest.di.annotation;

