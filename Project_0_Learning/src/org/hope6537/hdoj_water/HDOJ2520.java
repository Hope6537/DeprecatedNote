package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2520 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int n = s.nextInt();
				int v = 1;
				int s = 0;
				for (int i = 0; i < n; i++) {
					s += v;
					v += 2;
				}
				System.out.println(s%10000);
			}
		}
	}

}
