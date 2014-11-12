package org.hope6537.springtest.createObject;

public class HelloWorldFactory1 {

	public HelloWorld getInstance() {
		return new HelloWorld();
	}

	public HelloWorldFactory1() {
		System.out.println("Factory Started");
	}

}
