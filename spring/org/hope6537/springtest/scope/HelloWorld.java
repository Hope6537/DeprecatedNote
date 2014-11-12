package org.hope6537.springtest.scope;

import java.util.ArrayList;

public class HelloWorld {

	private ArrayList<String> list = new ArrayList<String>();

	public HelloWorld() {
		System.out.println("Construtor");
	}

	public void hello() {
		System.out.println("Hello World");
	}

	public ArrayList<String> getList() {
		return list;
	}

}
