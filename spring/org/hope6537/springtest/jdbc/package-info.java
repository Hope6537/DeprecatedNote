/** 
 *<pre>
 * Spring的JDBC用法 -- 我们大家都用框架~！
 * {@link org.hope6537.springtest.jdbc.Person} --用户模型类
 * {@link org.hope6537.springtest.jdbc.PersonDao} -- 持久层接口
 * {@link org.hope6537.springtest.jdbc.PersonDaoImpl} -- 持久层实现1
 * {@link org.hope6537.springtest.jdbc.PersonRowMapper} -- Person对象封装类
 * <hr>
 * Spring提供了3种实现JDBC功能的方法
 * 1、对于PersonDaoImpl类来说
 * 继承了JdbcDaoSupport这个类 
 * 使用 this.getJdbcTemplate().execute("insert into person (name) values ('Sam2')");
 * 格式进行增删改操作
 * 关于查询操作需要用到映射器
 * return this.getJdbcTemplate().query("select * from person",new PersonRowMapper());
 * 关于在xml里的配置如下
 * bean id="personDao" class="org.hope6537.springtest.jdbc.PersonDaoImpl">
 *		property name="dataSource">
 *			ref bean="dataSource" />
 *		/property>
 *	/bean>
 * 2、对于第二种方法是申请Spring注入
 * bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
 *		property name="dataSource">
 *			ref bean="dataSource" />
 *		/property>
 *	/bean>
 *声明了该bean之后
 *private JdbcTemplate jdbcTemplate;
 *注入了之后直接按照第一种方法使用即可
 *3、对于第三种方法是直接继承JdbcTemplate
 *然后在super(datasource)中注入进去，按照第一种方法使用
 *</pre>
 */
package org.hope6537.springtest.jdbc;

