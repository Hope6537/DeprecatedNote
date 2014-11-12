package org.hope6537.tencent;

import java.util.Scanner;

public class HDOJ4503 {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
			int T = s.nextInt();
			while (T-- != 0) {
				int n = s.nextInt();
				int num = 0;
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					int a = (int) s.nextInt();
					arr[i] = a;
				}
				for (int i = 0; i < n; i++) {
					num += arr[i] * (n - 1 - arr[i]);
				}
				int sum = (n * (n - 1) * (n - 2)) / 6;
				num = num / 2;
				num = sum - num;
				System.out.printf("%.3f\r\n", num * 1.0 / sum);
			}
		}
	}
