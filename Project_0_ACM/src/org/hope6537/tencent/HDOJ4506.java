package org.hope6537.tencent;

import java.util.Scanner;

/**
 * @Describe 卧草我也不知道怎么做
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-6-6下午4:20:28
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ4506 {

	static int mod = 100000007;
	static int arr[];

	static void change(int n, int k, int t) {
		for (int i = 0; i < t; i++) {
			int temp = arr[0];
			for (int j = 1; j < n; j++) {
				int temp2 = arr[j];
				arr[j] = temp * k % mod;
				temp = temp2;
			}
			arr[0] = temp * k % mod;
		}
	}

	long modExp(long a, long b, long n) {
		long t, y;
		t = 1;
		y = a;
		while (b != 0) {
			if (b % 2 != 0)
				t = t * y % n;
			y = y * y % n;
			b >>= 1;
		}
		return t;
	}
	

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int n = s.nextInt();
				int t = s.nextInt();
				int k = s.nextInt();
				arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = s.nextInt();
				}
				change(n, k, t);
				for (int i = 0; i < n; i++) {
					if (i != 0) {
						System.out.print(" ");
					}
					System.out.print(arr[i]);
				}
			}
		}
	}
}
