package org.hope6537.hdoj_water;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class HDOJ2085 {

	static Scanner s = new Scanner(new BufferedInputStream(System.in));

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == -1) {
				break;
			}
			if (n == 0) {
				System.out.println(1 + ", " + 0);
			} else {
				BigInteger high = BigInteger.valueOf(1);
				BigInteger low = BigInteger.valueOf(0);
				while (n-- != 0) {
					BigInteger temph = high.multiply(BigInteger.valueOf(3))
							.add(low.multiply(BigInteger.valueOf(2)));
					BigInteger templ = high.multiply(BigInteger.valueOf(1))
							.add(low.multiply(BigInteger.valueOf(1)));
					high = temph;
					low = templ;
				}
				System.out.println(high + ", " + low);
			}

		}
	}
}
