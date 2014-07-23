package org.hope6537.dpfunction;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class HDOJ1421 {

	static Scanner s = new Scanner(new BufferedInputStream(System.in));
	static int MAX = 2005;

	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int k = s.nextInt();
			int[] a = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				a[i] = s.nextInt();
			}
			Arrays.sort(a);
			// input done
			/*
			 * 状态转移方程 对于dp[i][j]来说 是表示前i件物品取j对的最优解
			 * j在外层循环 从第1对物品到第k对物品
			 * i在内层循环 跟j有直接关系 从第2*j件物品开始到第n件物品 依次寻找最优解;
			 * 当i == 2 * j时 它仅有一种选择 就是直接选取当前这对物品，
			 * 当i++之后 他和之前选择的物品进行一一比较 即min(dp[i-1][j],dp[i-2][j-1] + (a[i] - a[i-1]) * (a[i] - a[i-1]))
			 * 前者为之前选择的那对物品，后者为i++之后的新物品，并加到之前的最优解上和本状态进行比较
			 * dp[i][j] = min(dp[i-1][j], dp[i-2][j-1] + ((a[i] - a[i-1]) * (a[i] - a[i-1])));
			 */
			int dp[][] = new int[n + 1][n + 1];
			dp[2][1] = (a[2] - a[1]) * (a[2] - a[1]); 
			for (int j = 1; j <= k; j++) {
				for (int i = 2 * j; i <= n; i++) {
					if(i == 2 * j){
						dp[i][j] = dp[i-2][j-1] + ((a[i] - a[i-1]) * (a[i] - a[i-1]));
					}else{
						dp[i][j] = min(dp[i-1][j], dp[i-2][j-1] + ((a[i] - a[i-1]) * (a[i] - a[i-1])));
					}
				}
			}
			System.out.println(dp[n][k]);
		}
	}
}
