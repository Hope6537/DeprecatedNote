package org.hope6537.tencent;

import java.util.Scanner;

public class HDOJ4508 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int[] values = new int[n + 2];
			int[] volume = new int[n + 2];
			for (int i = 0; i < n; i++) {
				values[i] = s.nextInt();
				volume[i] = s.nextInt();
			}
			int m = s.nextInt();
			// 完全背包状态方程
			// dp[j] = max{dp[j],dp[j-volume[i]]+values[i]}
			int[] dp = new int[m + 2];

			for (int i = 0; i < n; i++) {
				for (int j = volume[i]; j <= m; j++) {
					int dp1 = dp[j];
					int dp2 = dp[j - volume[i]] + values[i];
					if (dp2 > dp1) {
						dp[j] = dp2;
					} else {
						dp[j] = dp1;
					}
				}
			}
			System.out.println(dp[m]);
		}
	}

}
