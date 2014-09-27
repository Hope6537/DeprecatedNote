package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ2544 {

	static Scanner s = new Scanner(System.in);
	static int MAX = 100005;

	public static void main(String[] args) {
		while (s.hasNext()) {
			int N = s.nextInt();
			int M = s.nextInt();
			if (N == 0 && M == 0) {
				break;
			}

			int[][] routes = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					routes[i][j] = MAX;
				}
			}
			for (int i = 1; i <= M; i++) {
				int la = s.nextInt();
				int lb = s.nextInt();
				int c = s.nextInt();
				if (la > lb) {
					int temp = la;
					la = lb;
					lb = temp;
				}
				if (routes[la][lb] > c) {
					routes[la][lb] = c;
				}

			}
			// input done
			/*
			 * 状态方程 dp[i] 代表经过第i个路口的最短路径 dp[i] = min{dp[j] + route(j --> i)} (i
			 * = 2 ---> N) (j = 1 --- > i-1)
			 */
			// 形成一个路径矩阵
			int dp[] = new int[N + 1];
			dp[1] = 0;
			for (int i = 2; i <= N; i++) {
				dp[i] = routes[i][i];
				for (int j = 1; j <= i - 1; j++) {
					int res = dp[j] + routes[j][i];
					if (res < dp[i]) {
						dp[i] = res;
					}
				}
			}
			System.out.println(dp[N]);
		}
	}
}
