package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ2602_2 {

	static int MAX = 1001;

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		int T = s.nextInt();
		while (T-- != 0) {
			int N = s.nextInt(); // 骨头的个数
			int V = s.nextInt(); // 背包的容量
			int[] values = new int[MAX];
			int[] volumes = new int[MAX];
			// 对于dp[i]来说，就是当背包内物品为i立方米时的价值
			int[] dp = new int[MAX];
			for (int i = 0; i < N; i++) {
				int value = s.nextInt();
				values[i] = value;
			}
			for (int i = 0; i < N; i++) {
				int volume = s.nextInt();
				volumes[i] = volume;
			}
			for (int i = 0; i < N; i++) {
				for (int j = V; j >= volumes[i]; j--) {
					if (dp[j] < dp[j - volumes[i]] + values[i]) {
						dp[j] = dp[j - volumes[i]] + values[i];
					}
				}
			}
			System.out.println(dp[V]);
		}

	}

}
