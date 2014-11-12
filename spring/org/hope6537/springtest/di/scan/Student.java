package org.hope6537.springtest.di.scan;

import org.springframework.stereotype.Component;

@Component
public class Student {

	public Student() {
		System.out.println("Student");
	}

	public void test() {
		System.out.println("test");
	}

}
