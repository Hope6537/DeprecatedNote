package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1170 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				char c = s.next().trim().charAt(0);
				int a = s.nextInt();
				int b = s.nextInt();
				if (c == '+') {
					System.out.println(a + b);
				}
				if (c == '-') {
					System.out.println(a - b);
				}
				if (c == '*') {
					System.out.println(a * b);
				}
				if (c == '/') {
					if (a % b == 0) {
						System.out.printf("%d\r\n",a / b);
					} else {
						System.out.printf("%.2f\r\n", a * 1.0 / b);
					}
				}
			}
		}
	}

}
