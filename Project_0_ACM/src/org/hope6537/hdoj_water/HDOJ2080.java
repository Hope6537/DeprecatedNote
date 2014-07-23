package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2080 {

	static Scanner s = new Scanner(System.in);

	static double abs(double a) {
		return a < 0 ? -a : a;
	}
	static int abs(int a) {
		return a < 0 ? -a : a;
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			while (n-- != 0) {
				int x1 = s.nextInt();
				int y1 = s.nextInt();
				int x2 = s.nextInt();
				int y2 = s.nextInt();
				double k1 = (y1*1.0)/(x1);
				double k2 = (y2*1.0)/(x2);
				double ang = abs(k2-k1/(1+(k1*k2)));
				System.out.println(ang);

			}
		}
	}
}
