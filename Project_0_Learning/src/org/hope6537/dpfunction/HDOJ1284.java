package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @Describe ��ȫ��������
 * @Author Hope6537(����)
 * @Signdate 2014-5-18����03:31:44
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1284 {
	static Scanner s = new Scanner(System.in);
	static int MAX = 32768 + 10;

	public static void main(String[] args) {
		while (s.hasNext()) {
			long V = s.nextInt();
			int[] values = { 1, 2, 3 };
			// ���ù�ʽ
			/*
			 * dp[j] = max{f[j],f[j-c[i]]+w[i]} ����w[i] = 1 , 2 , 3 �����Ϊ1 c[i] =
			 * 1; dp[j]��ʾj�м���ֻ�� 1��2, 3���������ֵĲ�ַ�����i ����Ӳ�ҵļ�ֵ��
			 * ���ֻ�ż�ֵΪ1��Ӳ�ң���d[1]���Ƶ�d[n]������ټ��ϼ�ֵΪ2��Ӳ�ң���ô�ʹ�d[2]���Ƶ�d[n]
			 * �ڼ��ϼ�ֵΪ3��Ӳ�ң��ʹ�d[3]���Ƶ�d[n].���ƹ�ʽ��d[j] = d[j] + d[j-i]
			 */
			long[] dp = new long[MAX];
			dp[0] = 1;
			for (int i = 0; i < 3; i++) {
				for (int k = values[i]; k <= V; k++) {
					dp[k] = dp[k] + dp[k - values[i]];
				}
			}
			System.out.println(dp[(int) V]);
		}
	}
}
