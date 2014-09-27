package org.hope6537.hdoj_water;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class HDOJ1229 {

	static Scanner s = new Scanner(new BufferedInputStream(System.in));

	public static void main(String[] args) {
		while (s.hasNext()) {
			int a = s.nextInt();
			int b = s.nextInt();
			int k = s.nextInt();
			if (a == 0 && b == 0) {
				break;
			}
			double pow = Math.pow(10, k);
			if (a % pow == b % pow) {
				System.out.println(-1);
			} else {
				System.out.println(a + b);
			}
		}
	}
}
