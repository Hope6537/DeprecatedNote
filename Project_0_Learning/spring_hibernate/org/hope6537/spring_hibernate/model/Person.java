package org.hope6537.spring_hibernate.model;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = -3313437040509278568L;
	private Long pid;
	private String pname;
	private String psex;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(Long pid, String pname, String psex) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.psex = psex;
	}

	public String getPsex() {
		return psex;
	}

	public void setPsex(String psex) {
		this.psex = psex;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}
