package org.hope6537.tencent;

import java.util.Scanner;

public class HDOJ4506_2 {

	static int mod = 1000000007;
	static long arr[];

	/**
	 * @Descirbe 快速取余幂
	 * @Author Hope6537(赵鹏)
	 * @param a
	 * @param b
	 * @return
	 * @SignDate 2014-6-6下午5:29:21
	 * @Version 0.9
	 */
	static long quickMod(long a, long b) {
		long ans = 1;
		while (b != 0) {
			if ((b & 1) != 0) {
				ans = (ans * a) % mod;
				b--;
			}
			b >>= 1;
			a = a * a % mod;
		}
		return ans % mod;
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int T = s.nextInt();
		while (T-- != 0) {
			int n = s.nextInt();
			int t = s.nextInt();
			long k = s.nextLong();
			arr = new long[n];
			long mul = quickMod(k, t);

			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			for (int i = 0; i < n; i++) {
				int loc = (i - t) % n;
				if (loc < 0) {
					loc = n + loc;
				}
				long res = arr[loc] % mod * mul % mod;
				if (i != 0) {
					System.out.print(" ");
				}
				System.out.print(res);
			}
			System.out.println();
		}
	}

}
