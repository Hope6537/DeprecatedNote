package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1058 {

	static Scanner s = new Scanner(System.in);

	public static long min(long a, long b) {
		return a < b ? a : b;
	}

	public static long min(long a, long b, long c, long d) {
		return min(a, min(b, min(c, d)));
	}

	/*
	 * 如果一个数是Humble Number,那么它的2倍,3倍,5倍,7倍仍然是Humble Number 定义F[i]为第i个Humble
	 * Number F[n]=min(2*f[i],3*f[j],5*f[k],7*f[L]), i,j,k,L在被选择后相互移动
	 */
	public static void main(String[] args) {
		long[] dp = new long[6000];
		dp[1] = 1;
		int f2 = 1, f3 = 1, f5 = 1, f7 = 1;
		for (int i = 2; i <= 5845; i++) {
			dp[i] = min(dp[f2] * 2, dp[f3] * 3, dp[f5] * 5, dp[f7] * 7);
			if (dp[i] == dp[f2] * 2) {
				f2++;
			}
			if (dp[i] == dp[f3] * 3) {
				f3++;
			}
			if (dp[i] == dp[f5] * 5) {
				f5++;
			}
			if (dp[i] == dp[f7] * 7) {
				f7++;
			}

		}

		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			long res = dp[n];
			if (n % 10 == 1 && n % 100 != 11) {
				System.out.print("The " + n + "st humble number is " + res
						+ ".");
			} else if (n % 10 == 2 && n % 100 != 12) {
				System.out.print("The " + n + "nd humble number is " + res
						+ ".");
			} else if (n % 10 == 3 && n % 100 != 13) {
				System.out.print("The " + n + "rd humble number is " + res
						+ ".");
			} else {
				System.out.print("The " + n + "th humble number is " + res
						+ ".");
			}
			System.out.print("\r\n");
		}
	}
}
