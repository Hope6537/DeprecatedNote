package org.hope6537.baidu;

import java.util.Scanner;

public class HDOJ4824 {

	static Scanner s = new Scanner(System.in);

	static int INF = Integer.MAX_VALUE;
	
	static int dist(int x, int y, int x1, int y1) {
		int res = 0;
		res += Math.abs(x - x1) * 400;
		int shanqu = Math.abs(y - y1);
		shanqu = shanqu > 180 ? 360 - shanqu : shanqu;
		res += shanqu;
		return res;

	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int n = s.nextInt();// 数据的个数
				int[] t = new int[n + 1];
				int[] s1 = new int[n + 1];
				int[][] dp = new int[n + 1][n + 1];
				int[][] dist = new int[n + 1][n + 1];
				t[0] = 0;
				s1[0] = 0;
				for (int i = 1; i <= n; i++) {
					t[i] = s.nextInt();
					s1[i] = s.nextInt();
				}
				for (int i = 0; i <= n; i++) {
					for (int j = i + 1; j <= n; j++) {
						dist[j][i] = dist[i][j] = dist(t[i], s1[i], t[j], s1[j]);
						dp[i][j] = INF;
					}
				}
				dp[0][1] = dp[1][0] = dist[0][1];
				/*
				 * int tnum = 0; int snum = 0; long time = 0; for (int i = 0; i
				 * < n; i++) { int tart = t[i]; int tars = s1[i]; time +=
				 * Math.abs(tart - tnum) * 400; time += (Math.abs(tars - snum) >
				 * 180 ? 360 - Math.abs(tars - snum) : tars - snum); tnum =
				 * tart; snum = tars;
				 * 
				 * time += 10; } time += Math.abs(tnum) * 400; time +=
				 * (Math.abs(snum) > 180 ? 360 - Math.abs(snum) : snum);
				 * System.out.println(time);
				 */
				for (int i = 0; i <= n; i++) {
					for (int j = 0; j <= i; j++) {
						if (j < (i - 1)) {
							dp[i][j] = dp[i - 1][j] + dist[i - 1][i] ;
						}
						if (j == (i - 1)) {
							int ans = INF;
							for (int k = 0; k <= j; k++) {
								int res = dp[k][j] + dist[i][k];
								if (res < ans) {
									ans = res;

								}
								dp[i][j] = ans ;
							}
						}
						if (j == i) {
							int ans = INF;
							for (int w = 0; w < i; w++) {
								int res = dp[i][w] + dist[w][i] ;
								if (res < ans) {
									ans = res;

								}
								dp[i][i] = ans;
							}
						}
					}
				}
				System.out.println(dp[n][n] + (n) * 10);
			}
		}
	}
}
