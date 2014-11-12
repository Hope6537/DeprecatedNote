/** 
 *<pre>
 *Spring的事务处理
 *1、啰嗦了一大堆，就是配置切面而已
 *{@link org.hope6537.springtest.jdbc.transaction.Person} 模型类
 *{@link org.hope6537.springtest.jdbc.transaction.PersonDao} 持久层接口
 *{@link org.hope6537.springtest.jdbc.transaction.PersonService} 服务接口
 *{@link org.hope6537.springtest.jdbc.transaction.PersonDaoImpl} 持久层接口实现
 *{@link org.hope6537.springtest.jdbc.transaction.PersonServiceImpl} 服务接口实现 
 *就是按照往常那样写就可以了没啥不同的，关键是配置xml
 *1、想以前一样配置依赖
 *<!-- 切面定义 -->
	<aop:config>
		<aop:pointcut
			expression="execution (* org.hope6537.springtest.jdbc.transaction.PersonServiceImpl.*(..))"
			id="daoService" />
		<aop:advisor advice-ref="tx" pointcut-ref="daoService"/> --这里的tx对应下面的事务切面的id
	</aop:config>
	<!-- 配置dbcp的数据库连接池 javax.sql.DataSource 使用这个类 -->
	<bean id="personDao" class="org.hope6537.springtest.jdbc.transaction.PersonDaoImpl">
		<property name="dataSource" ref="dataSource"></property>
	</bean>
	<bean id="personService"
		class="org.hope6537.springtest.jdbc.transaction.PersonServiceImpl">
		<property name="dao" ref="personDao"></property>
	</bean>
	<!-- 引入属性文件 -->
	<context:property-placeholder location="classpath:config.properties" />
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="${driverClassName}"></property>
		<property name="url" value="${jdbc_url}"></property>
		<property name="username" value="${jdbc_username}"></property>
		<property name="password" value="${jdbc_password}"></property>
	</bean>
 *2、然后就出幺蛾子了
 * 1)配置事务管理器
 * 	<!-- 事务管理器 -->
	<bean id="transactionManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource">
			<ref bean="dataSource" />
		</property>
	</bean>
 * 2)事务咨询（切面）的配置
	<!-- 事务命名空间 并声明事务通知 id是事务标识 -->
	<tx:advice id="tx" transaction-manager="transactionManager">
		<tx:attributes>
			<!-- name限定方法名称 隔离机制=default 传播机制=判断参数？ -->
			<tx:method name="save*" isolation="DEFAULT" propagation="REQUIRED"
				read-only="false" />
		</tx:attributes>
	</tx:advice>
 *3、然后我们测试一下就可以了~
 *在实现类中
 *
 *this.getJdbcTemplate().execute("insert into person (name) values ('before')");
 //如果添加一个异常如下
 *int a = 1 / 0;
 //我们可以看到如果事务管理起作用了 那么before将不会出现在数据库中
 //反之则说明事务管理没有起作用 没有达到持久层原子性这个必须的要求
 *this.getJdbcTemplate().execute("insert into person (name) values ('after')");
 *</pre>
 */
package org.hope6537.springtest.jdbc.transaction;