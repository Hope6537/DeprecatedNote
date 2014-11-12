package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1176 {

	static Scanner s = new Scanner(System.in);
	static int MAXTIME = 10;

	public static int max_index(int a, int b, int c) {

		if (b >= a && b >= c) {
			return 0;
		}
		if (a >= b && a >= c) {
			return -1;
		}

		if (c >= a && c >= b) {
			return 1;
		}
		return 0;
	}

	public static int max_num(int a, int b, int c) {

		if (b >= a && b >= c) {
			return b;
		}
		if (a >= b && a >= c) {
			return a;
		}

		if (c >= a && c >= b) {
			return c;
		}
		return 0;
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			// long[t][i];
			// i = 0 ----> 10 11项
			// t = 0 ----> 100000
			int lastTime = 0;
			int max = 0;
			// value[t][i] = 代表的是在t时刻 i点落下的馅饼数
			int[][] values = new int[MAXTIME][11];
			for (int i = 0; i < n; i++) {
				int index = s.nextInt();
				int time = s.nextInt();
				if (time > lastTime) {
					lastTime = time;
				}
				values[time][index] += 1;
			}
			// dp[t][i]代表的是在t秒时 i位置所能接到的最大的馅饼数
			// 根据动态规划的数塔尿性，应该从塔底到塔顶这样遍历
			// dp[t][i] = max{dp[t+1][i-1],dp[t+1][i],dp[t+1][i+1]} +
			// value[t][i];
			int dp[][] = new int[MAXTIME][11];
			for (int i = 0; i < 11; i++) {
				dp[lastTime][i] = values[lastTime][i];
			}
			for (int t = lastTime; t >= 0; t--) {
				for (int i = 0; i <= 10; i++) {
					if (i == 0) {
						int stop = dp[t + 1][i];
						int right = dp[t + 1][i + 1];
						dp[t][i] = Math.max(stop, right) + values[t][i];
					} else if (i == 10) {
						int left = dp[t + 1][i - 1];
						int stop = dp[t + 1][i];
						dp[t][i] = Math.max(left, stop) + values[t][i];
					} else {
						int left = dp[t + 1][i - 1];
						int stop = dp[t + 1][i];
						int right = dp[t + 1][i + 1];
						dp[t][i] = max_num(left, stop, right) + values[t][i];
					}
				}
			}
			/*
			 * for (int i = 0; i < 11; i++) { System.out.print("dp[" + 0
			 * + "][" + i + "]=" + dp[0][i] + " "); }
			 */
			System.out.println(dp[0][5]);
		}
	}
}
