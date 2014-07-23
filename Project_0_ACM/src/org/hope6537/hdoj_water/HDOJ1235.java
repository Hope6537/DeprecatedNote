package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1235 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			int tar = s.nextInt();
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (tar == arr[i]) {
					count++;
				}
			}
			System.out.println(count);

		}
	}
}
