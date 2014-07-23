package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2095 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int a = 0;
			int res = 0;
			while (n-- != 0) {
				a = s.nextInt();
				res ^= a;
			}
			System.out.println(res);
		}

	}

}
