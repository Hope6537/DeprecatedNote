package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @Describe 完全背包问题
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-18下午03:31:44
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1284 {
	static Scanner s = new Scanner(System.in);
	static int MAX = 32768 + 10;

	public static void main(String[] args) {
		while (s.hasNext()) {
			long V = s.nextInt();
			int[] values = { 1, 2, 3 };
			// 套用公式
			/*
			 * dp[j] = max{f[j],f[j-c[i]]+w[i]} 这里w[i] = 1 , 2 , 3 体积都为1 c[i] =
			 * 1; dp[j]表示j有几种只用 1，2, 3这三个数字的拆分方法，i 就是硬币的价值。
			 * 如果只放价值为1的硬币，从d[1]递推到d[n]；如果再加上价值为2的硬币，那么就从d[2]递推到d[n]
			 * 在加上价值为3的硬币，就从d[3]递推到d[n].递推公式是d[j] = d[j] + d[j-i]
			 */
			long[] dp = new long[MAX];
			dp[0] = 1;
			for (int i = 0; i < 3; i++) {
				for (int k = values[i]; k <= V; k++) {
					dp[k] = dp[k] + dp[k - values[i]];
				}
			}
			System.out.println(dp[(int) V]);
		}
	}
}
