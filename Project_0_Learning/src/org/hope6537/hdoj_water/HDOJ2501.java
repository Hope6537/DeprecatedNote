package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2501 {

	public static int f(int i) {
		if (i == 1) {
			return 1;
		} else if (i == 2) {
			return 3;
		} else {
			return f(i - 1) + 2 * f(i - 2);
		}
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int n = s.nextInt();
				System.out.println(f(n));
			}

		}
	}
}
