package org.hope6537.hdoj_water;

import java.math.BigInteger;
import java.util.Scanner;

public class HDOJ1013 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			BigInteger n = s.nextBigInteger();
			if (n.compareTo(BigInteger.ZERO) == 0) {
				break;
			}
			BigInteger last = BigInteger.ZERO;
			while (n.compareTo(BigInteger.valueOf(10)) >= 0) {
				String num = n + "";
				last = n;
				n = BigInteger.ZERO;
				for (int i = 0; i < num.length(); i++) {
					n = n.add(BigInteger.valueOf(num.charAt(i) - 48));
				}
			}
			if (n.compareTo(BigInteger.ZERO) < 0) {
				n = last;
			}
			System.out.println(n);
		}
	}

}
