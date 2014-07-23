package org.hope6537.tencent;

import java.util.Scanner;

/**
 * @Describe ��Ϻ�����dp
 * @Author Hope6537(����)
 * @Signdate 2014-6-6����09:45:35
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ4504 {

	static Scanner s = new Scanner(System.in);
	static int MAX = 100;

	public static void main(String[] args) {

		// �������ʱ300MS ���ǲ���������ҳ������أ� �Ͻ�Ԥ����
		int[][] dp = new int[MAX + 1][(MAX * 3) + 1];
		dp[0][0] = dp[1][1] = dp[1][2] = dp[1][3] = 1;
		for (int i = 2; i <= MAX; i++) {
			for (int j = 1; j <= MAX * 3; j++) {
				dp[i][j] = dp[i - 1][j - 1]; // ʹ�÷�����Ͷ��
				if (j >= 2) {
					dp[i][j] += dp[i - 1][j - 2]; // ʹ���о���Ͷ��
				}
				if (j >= 3) {
					dp[i][j] += dp[i - 1][j - 3]; // ʹ��������Ͷ��
				}
			}
		}

		while (s.hasNext()) {
			int a = s.nextInt();
			int b = s.nextInt();
			int time = s.nextInt();
			int enemycount = (time / 15) / 2;
			int ourcount = ((time / 15) % 2 != 0 ? 1 : 0);
			int score = (b + enemycount - a + 1);
			if (score < enemycount + ourcount) { // ���Ǽ�����ж���
				// ������ָ������ֲ����
				score = (enemycount + ourcount);

			}

			long sum = 0;
			for (int i = score; i <= (enemycount + ourcount) * 3; i++) {
				sum += dp[(enemycount + ourcount)][i];
			}
			System.out.println(sum);
		}

	}
}
