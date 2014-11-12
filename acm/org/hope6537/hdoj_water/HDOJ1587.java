package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1587 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int m = s.nextInt();
			int t = 0;
			int[] price = new int[n];
			for (int i = 0; i < n; i++) {
				price[i] = s.nextInt();
			}
			t = price[0];
			for (int i = 0; i < n; i++) {
				t = price[i] < t ? price[i] : t;
			}
			System.out.println(m/t);

		}
	}

}
