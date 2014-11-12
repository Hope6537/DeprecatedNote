package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1877 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			long a = s.nextLong();
			long b = s.nextLong();

			long c = 0;
			c = a + b;
			String str = Long.toString(c, n);
			System.out.println(str);
		}
	}
}
