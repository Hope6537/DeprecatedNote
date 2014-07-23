package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1203 {

	static Scanner s = new Scanner(System.in);
	static int MAX = 10002;
	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();// Ǯ === ����
			int m = s.nextInt();// ����
			if (n + m == 0) {
				break;
			}
			int[] c = new int[MAX]; // ���� == Ǯ
			double[] w = new double[MAX]; // ��ֵ == ����
			for (int i = 0; i < m; i++) {
				c[i] = s.nextInt();
				w[i] = s.nextDouble();
			}
			double[] dp = new double[MAX];
			for (int i = 0; i < MAX; i++) {
				dp[i] = 1.0;
			}
			for (int i = 0; i < m; i++) {
				for (int v = n; v >= c[i]; v--) {
					dp[v] = Math.min(dp[v], dp[v - c[i]] * (1.0 - w[i]));
				}
			}
			System.out.printf("%.1f%%\r\n", ((1.0 - dp[n]) * 100));
		}
	}
}
