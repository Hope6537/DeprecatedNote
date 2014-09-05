package org.hope6537.design.factory.example;

public class Client {

	public static void main(String[] args) {
		AbstractFactory factory = new ConcreteCreator();
		Product product = factory.createProduct(CurrentProduct1.class);
	}
}
