package org.hope6537.springtest.di.scan;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//定义组件 可以在里面添加bean的名称 改名也可以 
@Component("untiyPerson")
public class Person {

	@SuppressWarnings("unused")
	private Long pid;// 包装类型
	@SuppressWarnings("unused")
	private String pname;// String类型
	// 定义属性注入
	@Resource(name = "student")
	private Student student;

	public void say() {
		System.out.println("Student is null? " + student == null);
		student.test();
	}

	// init-method注解
	@PostConstruct
	public void init() {
		System.out.println("init");
	}

	// destory-method注解
	@PreDestroy
	public void destory() {
		System.err.println("destory");
	}
}
