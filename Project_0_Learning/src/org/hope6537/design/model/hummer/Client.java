package org.hope6537.design.model.hummer;

import org.junit.Test;

public class Client {
	
	@Test
	public void test(){
		AbstractHummerModel model = new HummerH1Model();
		model.run();
	}
	

}
