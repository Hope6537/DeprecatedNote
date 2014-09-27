package org.hope6537.hdoj_water;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ2088 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int flag = 0;
		while (s.hasNext()) {

			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			if (flag == 1) {
				System.out.println();
			}
			flag = 1;
			int sum = 0;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
				sum += arr[i];
			}
			int count = 0;
			int avg = sum / n;
			Arrays.sort(arr);
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i] > avg) {
					count += arr[i] - avg;
				}
			}
			System.out.println(count);
		}
	}

}
