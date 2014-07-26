package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @Describe 输入数据首先包含一个正整数C，表示有C组测试用例， 每组测试用例的第一行是两个整数n和m(1<=n<=100, 1<=m<=100),
 *           分别表示经费的金额和大米的种类， 然后是m行数据，每行包含3个数p，h和c(1<=p<=20,1<=h<=200,1<=c<=20)，
 *           分别表示每袋的价格、每袋的重量以及对应种类大米的袋数。
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-21下午08:13:41
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2191 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int C = s.nextInt();
		while (C-- != 0) {
			/*
			 * 输入数据首先包含一个正整数C，表示有C组测试用例， 每组测试用例的第一行是两个整数n和m(1<=n<=100,
			 * 1<=m<=100), 分别表示经费的金额和大米的种类，
			 * 然后是m行数据，每行包含3个数p，h和c(1<=p<=20,1<=h<=200,1<=c<=20)，
			 * 分别表示每袋的价格、每袋的重量以及对应种类大米的袋数。
			 */
			int n = s.nextInt();
			int m = s.nextInt();
			int[] cash = new int[m + 1];
			int[] weight = new int[m + 1];
			int[] type = new int[m + 1];
			for (int i = 1; i <= m; i++) {
				int p = s.nextInt();
				int h = s.nextInt();
				int c = s.nextInt();
				cash[i] = p;
				weight[i] = h;
				type[i] = c;
			}
			/*
			 * 对于每组测试数据，请输出能够购买大米的最多重量，你可以假设经费买不光所有的大米， 并且经费你可以不用完。每个实例的输出占一行。
			 */
			/**
			 * N种物品和一个容量为V的背包。第i种物品最多有n[i]件可用，每件费用是c[i]，价值是w[i]。
			 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
			 * 令f[i][v]表示前i种物品恰放入一个容量为v的背包的最大权值
			 * 
			 * f[i][v]=max{f[i-1][v-k*c[i]]+k*w[i]|0<=k<=n[i]}
			 */

			/*
			 * dp[i][j]表示前i种大米恰用金额为v的数值买到的最大重量 cash[i] = c[i] 代表价格 这里相当于背包的容量
			 * weight[i] = w[i] 代表重量 这里相当于背包内的物品的价值 type[i] = n[i] 代表第i件物品的可用数量
			 * dp[i][j] = max{dp[i-1][v - k * cash[i]] + k * weight[i]}
			 * (0<=k<=type[i]) n代表经费的金额 m代表大米的种类
			 */
			/*
			 * int[][] dp = new int[m+5][n+5]; for(int i = 1 ; i <= m ; i++){
			 * for(int j = n ; j >= type[i] * cash[i] ; j--){ dp[i][j] = 0;
			 * for(int k = 0 ; k <= type[i] ; k++){ int res = dp[i-1][j - (k *
			 * cash[i])] + k * weight[i]; if(res > dp[i][j]){ dp[i][j] = res; }
			 * }
			 * 
			 * } }
			 */
			int[] dp = new int[n + 1];
			for (int i = 1; i <= m; i++) {
				for (int j = 0; j < type[i]; j++) {
					for (int k = n; k >= cash[i]; k--) {
						int res = dp[k-cash[i]] + weight[i];
						if(res > dp[k]){
							dp[k] = res;
						}
					}
				}
			}
			System.out.println(dp[n]);
//			System.out.println(dp[m][n]);

		}

	}
}
