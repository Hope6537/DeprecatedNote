package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ2571 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * ״̬����:sum[i][j]=max{sum[i-1][j],sum[i][r]}+v[i][j];����1<=r<=j-1,��r��j������
		 */
		while (s.hasNext()) {
			int C = s.nextInt();
			while (C-- != 0) {
				int n = s.nextInt();
				int m = s.nextInt();
				//�����Թ���ͼ
				int[][] map = new int[n + 1][m + 1];
				//���춯̬���� 
				int dp[][] = new int[n + 1][m + 1];
				//Ȼ��ÿ��ÿ�н�������
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						map[i][j] = s.nextInt();
					}
					//��Ϊ����ֵ����ָ������������еĳ�ʼֵ���趨Ϊ��С 
					dp[i][0] = Integer.MIN_VALUE;
				}
				// input done
				for (int i = 0; i <= m; i++) {
					dp[0][i] = Integer.MIN_VALUE;
				}
				//������㲻�ܽ����ۼ�
				dp[1][1] = map[1][1];
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						if (i == 1 && j == 1) {
							//������i==1 j==1��ʱ����ж�����ж�����dp[1][1] = map[1][1];
							continue;
						}
						//��ȡ��x-1����������ֵ��y-1����������ֵ�������
						int maxi = Math.max(dp[i - 1][j], dp[i][j - 1]);
						for (int r = j / 2; r != 0; r--) {
							//ͬʱ����״̬���̵�r �����������j�ı����ƶ���i,r��Ծ��i,j  j = r * prej;
							if ((j % r == 0) && (maxi < dp[i][r])) {
								maxi = dp[i][r];
							}
						}
						//ѡ�����ֵ �����ӽṹ
						dp[i][j] = maxi + map[i][j];
					}
				}
				System.out.println(dp[n][m]);
			}
		}
	}
}
