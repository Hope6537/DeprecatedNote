package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ2955 {

	static Scanner s = new Scanner(System.in);

	static double max(double a, double b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		// while~!
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				double P = s.nextDouble();
				P = 1 - P;
				int N = s.nextInt();
				int MAXMONEY = 0;
				int[] m = new int[N+1];
				double[] p = new double[N+1];
				for (int i = 1; i <= N; i++) {
					m[i] = s.nextInt();
					MAXMONEY += m[i];
					p[i] = s.nextDouble();
					p[i] = (1 - p[i]);
				}
				// input done
				// 装态转移方程
				/*
				 * 将其转化为背包问题 dp[j] = max{dp[j] , dp[j - m[i]] * p[i]}
				 * 用成功逃走的概率当做价值，他所能拿到的银行的总钱数当做价值
				 * 所以需要将概率 1 - P
				 */
				double dp[] = new double[MAXMONEY + 1];
				for (int i = 0; i <= MAXMONEY; i++) {
					dp[i] = -1;
				}
				dp[0] = 1;
				for (int i = 1; i <= N; i++) {
					for (int j = MAXMONEY; j >= m[i]; j--) {
						dp[j] = max(dp[j],dp[j-m[i]]*p[i]);
					}
				}
				int maxIndex = -1;
				for (int i = MAXMONEY; i >= 0; i--) {
					//第一次忘记一分钱不抢的概率了
					if(dp[i] > P){
						maxIndex = i;
						break;
					}
				}
				System.out.println(maxIndex);
				
			}
		}
	}
}
