package org.hope6537.design.proxy.pattern;

public class RealSubject implements Subject {

	@Override
	public void request() {
		System.out.println("Request has Commit");
	}

	
	
}
