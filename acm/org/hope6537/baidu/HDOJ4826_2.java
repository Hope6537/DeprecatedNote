package org.hope6537.baidu;

import java.util.Scanner;

public class HDOJ4826_2 {
	static int N = 105;
	static int INF = 0x3f3f3f3f;
	static int n, m;
	static int g[][];
	static int dp[][][];
	static Scanner s = new Scanner(System.in);

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	int max(int a, int b, int c) {
		return max(a, max(b, c));
	}

	static void init() {
		n = s.nextInt();
		m = s.nextInt();
		g = new int[N][N];
		dp = new int[N][N][2];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				g[i][j] = s.nextInt();
	}

	static int solve() {

		for (int i = 1; i <= m; i++)
			dp[0][i][0] = dp[n + 1][i][1] = -INF;

		dp[0][1][0] = 0;
		for (int i = 1; i <= n; i++) {
			dp[i][1][0] = dp[i - 1][1][0] + g[i][1];
			dp[i][1][1] = -INF;
		}

		for (int j = 2; j <= m; j++) {

			for (int i = 1; i <= n; i++)
				dp[i][j][0] = max(dp[i - 1][j][0], max(dp[i][j - 1][0],
						dp[i][j - 1][1]))
						+ g[i][j];

			for (int i = n; i >= 1; i--)
				dp[i][j][1] = max(dp[i + 1][j][1], max(dp[i][j - 1][0],
						dp[i][j - 1][1]))
						+ g[i][j];
		}
		return max(dp[1][m][0], dp[1][m][1]);
	}

	public static void main(String[] args) {
		int cas = s.nextInt();
		for (int i = 1; i <= cas; i++) {
			init();
			System.out.printf("Case #%d:\r\n%d\r\n", i, solve());
		}
	}

}
