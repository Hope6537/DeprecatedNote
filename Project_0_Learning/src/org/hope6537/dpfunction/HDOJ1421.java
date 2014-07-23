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
			 * ״̬ת�Ʒ��� ����dp[i][j]��˵ �Ǳ�ʾǰi����Ʒȡj�Ե����Ž�
			 * j�����ѭ�� �ӵ�1����Ʒ����k����Ʒ
			 * i���ڲ�ѭ�� ��j��ֱ�ӹ�ϵ �ӵ�2*j����Ʒ��ʼ����n����Ʒ ����Ѱ�����Ž�;
			 * ��i == 2 * jʱ ������һ��ѡ�� ����ֱ��ѡȡ��ǰ�����Ʒ��
			 * ��i++֮�� ����֮ǰѡ�����Ʒ����һһ�Ƚ� ��min(dp[i-1][j],dp[i-2][j-1] + (a[i] - a[i-1]) * (a[i] - a[i-1]))
			 * ǰ��Ϊ֮ǰѡ����Ƕ���Ʒ������Ϊi++֮�������Ʒ�����ӵ�֮ǰ�����Ž��Ϻͱ�״̬���бȽ�
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
