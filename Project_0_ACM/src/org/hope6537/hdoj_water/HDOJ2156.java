package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2156 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		double m, j, i;
		while (s.hasNext()) {
			m = s.nextDouble();
			if (m == 0) {
				break;
			}
			j = 0;
			int k = 1;
			for (i = m; i >= 1; i--)
				j = j + 1.00 / i * k++;
			printf("%.2f\r\n", 2 * j - m);
		}

	}

	private static void printf(String string, Object args) {
		System.out.printf(string, args);

	}
}
