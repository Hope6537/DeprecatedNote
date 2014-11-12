package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @Describe Bone Collecter , 01背包问题
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-18下午01:00:12
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2602 {

	static int MAX = 5000;

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int N = s.nextInt(); // 骨头的个数
				int V = s.nextInt(); // 背包的容量
				int[] values = new int[MAX];
				int[] volumes = new int[MAX];

				int[] values_2 = new int[MAX];
				int[] volumes_2 = new int[MAX];
				int[][] dp1 = new int[1010][1010];
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
				for (int i = 1; i <= N; i++) {
					values_2[i] = values[i - 1];
				}
				for (int i = 1; i <= N; i++) {
					volumes_2[i] = volumes[i - 1];
				}
				// input done
				/*
				 * 01背包的状态方程 dp[i][v] = max{dp[i-1][v],dp[i-1][v-volumes[i]]
				 * +values[i]}; 意义详解：dp[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值
				 * 对于第i件物品 他有两种情况 
				 * 即不放入第i件时的价值和放入第i件时的价值，正是max函数里的前者和后者
				 * 然后取两者之间的最大值，作为最优解 以下是二维数组解法
				 */

				for (int i = 1; i <= N; i++) {
					for (int v = 0; v <= V; v++) {
						// 防止减入体积空间的负值。
						if (volumes_2[i] <= v) {
							int tempValues = values_2[i];
							int tempDp1 = dp1[i - 1][v - volumes_2[i]];
							if (dp1[i - 1][v] < tempDp1 + tempValues) {
								dp1[i][v] = tempDp1 + tempValues;
							} else {
								dp1[i][v] = dp1[i - 1][v];
							}
						} else {
							dp1[i][v] = dp1[i - 1][v];
						}
					}
				}
				/*
				 * 一维数组的解法 不知道咋的 反正i和以前一样 然后j = V---->0 然后求出dp[j] 的最大值 
				 * 即从dp[j] 和 dp[v-volumes[i]] + values[i] 找
				 */
				for (int i = 0; i < N; i++) {
					for (int j = V; j >= volumes[i]; j--) {
						if (dp[j] < dp[j - volumes[i]] + values[i]) {
							dp[j] = dp[j - volumes[i]] + values[i];
						}
					}
				}
				System.out.println(dp1[N][V]);
				//System.out.println(dp[V]);
			}
		}
	}

}
