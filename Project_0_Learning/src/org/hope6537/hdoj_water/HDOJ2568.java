package org.hope6537.hdoj_water;

import java.math.BigInteger;
import java.util.Scanner;

public class HDOJ2568 {

	/*
	 * 剑招A，一招能杀死一半的蝙蝠。 但是如果当前的蝙蝠数为奇数，那么就必须先出一招剑招B杀死其中任意一个，使蝙蝠数为偶数，再出剑招A。
	 */

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			while (n-- != 0) {
				int b = 0;
				BigInteger bigInteger = s.nextBigInteger();
				while (bigInteger.compareTo(bigInteger.ZERO) != 0) {
					if (bigInteger.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO)==0) {
						bigInteger = bigInteger.divide(BigInteger.valueOf(2));
					} else {
						bigInteger = bigInteger.subtract(bigInteger.valueOf(1));
						b++;
					}
				}
				System.out.println(b);

			}
		}
	}

}
