package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1701 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				double p = s.nextDouble();
				double q = s.nextDouble();
				int a = 0;
				int b = 0;
				int i;
				for (i = 1;; i++) {
					a = (int) ((i * p) / 100);
					b = (int) ((i * q) / 100);
					if (b - a == 1 && a < (p + i)) {
						break;
					}

				}
				System.out.println(i);
			}
		}
	}
}
