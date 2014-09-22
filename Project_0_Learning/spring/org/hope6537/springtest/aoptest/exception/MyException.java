package org.hope6537.springtest.aoptest.exception;

public class MyException {
	public void getExceptionMessage(Throwable ex) {
		System.out.println(ex.getMessage());
	}
}
