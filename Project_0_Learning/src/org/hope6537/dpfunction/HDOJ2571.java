package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ2571 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 状态方程:sum[i][j]=max{sum[i-1][j],sum[i][r]}+v[i][j];其中1<=r<=j-1,且r是j的因子
		 */
		while (s.hasNext()) {
			int C = s.nextInt();
			while (C-- != 0) {
				int n = s.nextInt();
				int m = s.nextInt();
				//构造迷宫地图
				int[][] map = new int[n + 1][m + 1];
				//构造动态方程 
				int dp[][] = new int[n + 1][m + 1];
				//然后按每行每列进行输入
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						map[i][j] = s.nextInt();
					}
					//因为运气值会出现负数，所以所有的初始值都设定为最小 
					dp[i][0] = Integer.MIN_VALUE;
				}
				// input done
				for (int i = 0; i <= m; i++) {
					dp[0][i] = Integer.MIN_VALUE;
				}
				//对于起点不能进行累加
				dp[1][1] = map[1][1];
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						if (i == 1 && j == 1) {
							//所以在i==1 j==1的时候进行额外的判定，即dp[1][1] = map[1][1];
							continue;
						}
						//获取到x-1过来的运气值和y-1过来的运气值的最大项
						int maxi = Math.max(dp[i - 1][j], dp[i][j - 1]);
						for (int r = j / 2; r != 0; r--) {
							//同时带入状态方程的r 让其可以随着j的倍数移动从i,r跳跃到i,j  j = r * prej;
							if ((j % r == 0) && (maxi < dp[i][r])) {
								maxi = dp[i][r];
							}
						}
						//选出最大值 最优子结构
						dp[i][j] = maxi + map[i][j];
					}
				}
				System.out.println(dp[n][m]);
			}
		}
	}
}
