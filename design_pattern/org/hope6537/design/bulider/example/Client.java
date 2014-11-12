package org.hope6537.design.bulider.example;

import java.util.ArrayList;

import org.junit.Test;

public class Client {

	@Test
	public void test(){
		ArrayList<String> orderList = new ArrayList<String>();
		orderList.add("start");
		orderList.add("alarm");
		BenzBuilder builder = new BenzBuilder();
		builder.setSequence(orderList);
		BenzModel benzModel = (BenzModel) builder.getCarModel();
		benzModel.run();
	}
	
}
