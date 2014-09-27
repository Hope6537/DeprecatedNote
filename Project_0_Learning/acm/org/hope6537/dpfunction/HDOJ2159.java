package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @Describe 输入数据有多组，对于每组数据第一行输入n，m，k，s(0 < n,m,k,s < 100)四个正整数。
 *           分别表示还需的经验值，保留的忍耐度，怪的种数和最多的杀怪数。 接下来输入k行数据。每行数据输入两个正整数a，b(0 < a,b <
 *           20)； 分别表示杀掉一只这种怪xhd会得到的经验值和会减掉的忍耐度。(每种怪都有无数个)
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-21下午07:56:49
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2159 {

	static Scanner scanner = new Scanner(System.in);

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {

		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int k = scanner.nextInt();
			int s = scanner.nextInt();
			int[] value = new int[k + 1];
			int[] volume = new int[k + 1];
			for (int i = 1; i <= k; i++) {
				value[i] = scanner.nextInt();
				volume[i] = scanner.nextInt();
			}
			// input done
			int[][] dp = new int[m + 1][s + 1];

			for (int i = 1; i <= k; i++) {
				for (int j = volume[i]; j <= m; j++) {
					for (int k1 = 1; k1 <= s; k1++) {
						dp[j][k1] = max(dp[j][k1], dp[j - volume[i]][k1 - 1]
								+ value[i]);
					}
				}
			}

			if (dp[m][s] < n) {
				System.out.println(-1);
			} else {
				int minj = m;
				for (int j = 0; j <= m; j++) {
					for (int k1 = 1; k1 <= s; k1++) {
						if (dp[j][k1] >= n) {
							if (j < minj) {
								minj = j;
							}
						}
					}
				}
				System.out.println(m - minj);
			}
		}
	}

}
