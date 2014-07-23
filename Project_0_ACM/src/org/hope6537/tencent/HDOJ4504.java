package org.hope6537.tencent;

import java.util.Scanner;

/**
 * @Describe 组合函数法dp
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-6-6上午09:45:35
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ4504 {

	static Scanner s = new Scanner(System.in);
	static int MAX = 100;

	public static void main(String[] args) {

		// 他妈的限时300MS 你是不是在这和我扯犊子呢？ 赶紧预处理
		int[][] dp = new int[MAX + 1][(MAX * 3) + 1];
		dp[0][0] = dp[1][1] = dp[1][2] = dp[1][3] = 1;
		for (int i = 2; i <= MAX; i++) {
			for (int j = 1; j <= MAX * 3; j++) {
				dp[i][j] = dp[i - 1][j - 1]; // 使用罚篮法投进
				if (j >= 2) {
					dp[i][j] += dp[i - 1][j - 2]; // 使用中距离投篮
				}
				if (j >= 3) {
					dp[i][j] += dp[i - 1][j - 3]; // 使用三分球投篮
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
			if (score < enemycount + ourcount) { // 忘记加这个判断了
				// 如果出现负数的弥补情况
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
