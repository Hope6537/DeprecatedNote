package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2521 {

	// 预处理下吧
	static int[] arr = new int[5005];

	static void init() {
		arr[1] = 1;
		for (int i = 2; i < 5000; i++) {
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					arr[i]++;
				}
			}
		}
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		init();
		while (s.hasNext()) {
			int n = s.nextInt();
			while (n-- != 0) {
				int a = s.nextInt();
				int b = s.nextInt();
				int max = 0;
				int maxindex = 0;
				for (int i = a; i <= b; i++) {
					if (arr[i] > max) {
						max = arr[i];
						maxindex = i;
					}
				}
				System.out.println(maxindex);
			}
		}
	}
}
