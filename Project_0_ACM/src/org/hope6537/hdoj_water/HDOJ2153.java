package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2153 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int map[][] = new int[n][n];
			int num = 1;
			for (int i = 0; i < n; i++, num++) {
				map[0][i] = num;
			}
			for (int i = 1; i < n; i++, num++) {
				map[i][n - 1] = num;
			}
			for (int i = n - 2; i > 0; i--, num++) {
				map[n - 1][i] = num;
			}
			for (int i = n - 1; i > 0; i--, num++) {
				map[i][0] = num;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0)
						System.out.format("%3d", map[i][j]);
					else
						System.out.print("   ");
				}
				System.out.println();
			}
		}
	}
}
