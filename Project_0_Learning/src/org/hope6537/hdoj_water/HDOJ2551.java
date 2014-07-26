package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2551 {

	static Scanner s = new Scanner(System.in);

	static long[] arr = new long[1005];

	static void init() {
		for (int i = 1; i <= 1000; i++) {
			arr[i] = arr[i - 1] + i * i * i;
		}
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			init();
			int T = s.nextInt();
			while (T-- != 0) {
				long X = s.nextInt();
				for (int i = 1; i <= 1000; i++) {
					if (X <= arr[i] && X > arr[i - 1]) {
						System.out.println(i);
						break;
					}
				}
			}
		}
	}

}
