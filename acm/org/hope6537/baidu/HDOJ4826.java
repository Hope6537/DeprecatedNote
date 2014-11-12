package org.hope6537.baidu;

import java.util.Scanner;

public class HDOJ4826 {

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			int INF = 0x3f3f3f3f;
			while (T-- != 0) {
				int m = s.nextInt();
				int n = s.nextInt();// y x
				int[][] map = new int[105][105];
				int[][][] dp = new int[105][105][2];
				 for (int i = 1; i <= m; i++)
				        for (int j = 1; j <= n; j++)
				        	map[i][j] = s.nextInt();
				for (int i = 1; i <= m; i++)
					dp[0][i][0] = dp[n + 1][i][1] = -INF;

				dp[0][1][0] = 0;
				for (int i = 1; i <= n; i++) {
					dp[i][1][0] = dp[i - 1][1][0] + map[i][1];
					dp[i][1][1] = -INF;
				}

				for (int j = 2; j <= m; j++) {

					for (int i = 1; i <= n; i++)
						dp[i][j][0] = max(dp[i - 1][j][0], max(dp[i][j - 1][0],
								dp[i][j - 1][1]))
								+ map[i][j];

					for (int i = n; i >= 1; i--)
						dp[i][j][1] = max(dp[i + 1][j][1], max(dp[i][j - 1][0],
								dp[i][j - 1][1]))
								+ map[i][j];
				}
				System.out.println(max(dp[1][m][0], dp[1][m][1]));
			}
		}
	}

	
	static Scanner s = new Scanner(System.in);

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static int max(int a, int b, int c) {
		return max(a, max(b, c));
	}
}
