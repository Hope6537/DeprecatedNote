package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @Describe Bone Collecter , 01��������
 * @Author Hope6537(����)
 * @Signdate 2014-5-18����01:00:12
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2602 {

	static int MAX = 5000;

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int N = s.nextInt(); // ��ͷ�ĸ���
				int V = s.nextInt(); // ����������
				int[] values = new int[MAX];
				int[] volumes = new int[MAX];

				int[] values_2 = new int[MAX];
				int[] volumes_2 = new int[MAX];
				int[][] dp1 = new int[1010][1010];
				// ����dp[i]��˵�����ǵ���������ƷΪi������ʱ�ļ�ֵ
				int[] dp = new int[MAX];

				for (int i = 0; i < N; i++) {
					int value = s.nextInt();
					values[i] = value;
				}
				for (int i = 0; i < N; i++) {
					int volume = s.nextInt();
					volumes[i] = volume;
				}
				for (int i = 1; i <= N; i++) {
					values_2[i] = values[i - 1];
				}
				for (int i = 1; i <= N; i++) {
					volumes_2[i] = volumes[i - 1];
				}
				// input done
				/*
				 * 01������״̬���� dp[i][v] = max{dp[i-1][v],dp[i-1][v-volumes[i]]
				 * +values[i]}; ������⣺dp[i][v]��ʾǰi����Ʒǡ����һ������Ϊv�ı������Ի�õ�����ֵ
				 * ���ڵ�i����Ʒ ����������� 
				 * ���������i��ʱ�ļ�ֵ�ͷ����i��ʱ�ļ�ֵ������max�������ǰ�ߺͺ���
				 * Ȼ��ȡ����֮������ֵ����Ϊ���Ž� �����Ƕ�ά����ⷨ
				 */

				for (int i = 1; i <= N; i++) {
					for (int v = 0; v <= V; v++) {
						// ��ֹ��������ռ�ĸ�ֵ��
						if (volumes_2[i] <= v) {
							int tempValues = values_2[i];
							int tempDp1 = dp1[i - 1][v - volumes_2[i]];
							if (dp1[i - 1][v] < tempDp1 + tempValues) {
								dp1[i][v] = tempDp1 + tempValues;
							} else {
								dp1[i][v] = dp1[i - 1][v];
							}
						} else {
							dp1[i][v] = dp1[i - 1][v];
						}
					}
				}
				/*
				 * һά����Ľⷨ ��֪��զ�� ����i����ǰһ�� Ȼ��j = V---->0 Ȼ�����dp[j] �����ֵ 
				 * ����dp[j] �� dp[v-volumes[i]] + values[i] ��
				 */
				for (int i = 0; i < N; i++) {
					for (int j = V; j >= volumes[i]; j--) {
						if (dp[j] < dp[j - volumes[i]] + values[i]) {
							dp[j] = dp[j - volumes[i]] + values[i];
						}
					}
				}
				System.out.println(dp1[N][V]);
				//System.out.println(dp[V]);
			}
		}
	}

}
