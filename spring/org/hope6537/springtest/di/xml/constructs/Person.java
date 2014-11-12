package org.hope6537.springtest.di.xml.constructs;

public class Person {

	private Long pid;// 包装类型
	private String pname;// String类型
	private Student student;

	public Person(Long pid, String pname, Student student) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.student = student;
	}

	public Person() {

	}

	public Person(String pname, Student student) {
		super();
		this.pname = pname;
		this.student = student;
	}

	public Long getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public Student getStudent() {
		return student;
	}

}
