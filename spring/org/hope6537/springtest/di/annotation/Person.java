package org.hope6537.springtest.di.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Person {

	private Long pid;// 包装类型

	private String pname;// String类型
	// 经典的第一种方法
	@Resource(name = "student")
	// 按照类型进行匹配
	// @Autowired
	// 按照名字进行匹配
	// @Qualifier("student")
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
