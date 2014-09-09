package org.hope6537.design.factory.simple;

import org.hope6537.design.factory.human.Human;
import org.hope6537.design.factory.human.WhiteHuman;

public class NvWa {

	public static void main(String[] args) {
		System.out.println("First");
		Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
		whiteHuman.getColor();
		whiteHuman.talk();
	}

}
