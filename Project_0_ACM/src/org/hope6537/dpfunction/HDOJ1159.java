package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @Describe 最长公共子序列问题 (LCS)
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-19上午07:59:46
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1159 {
	static Scanner s = new Scanner(System.in);

	public static void printLCS(String[][] b, String X, int i, int j) {
		if (i == 0 || j == 0) {
			return;
		}
		if (b[i][j].equals("LEFTUP")) {
			printLCS(b, X, i - 1, j - 1);
			System.out.print(X.charAt(i - 1));
		} else if (b[i][j].equals("UP")) {
			printLCS(b, X, i - 1, j);

		} else {
			printLCS(b, X, i, j - 1);
		}
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			String s1 = s.next();
			String s2 = s.next();
			int m = s1.length();
			int n = s2.length();
			String[][] b = new String[m + 1][n + 1];
			int[][] c = new int[m + 1][n + 1];
			for (int i = 1; i <= m; i++) {
				c[i][0] = 0;
			}
			for (int j = 0; j <= n; j++) {
				c[0][j] = 0;
			}
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						c[i][j] = c[i - 1][j - 1] + 1;
						b[i][j] = "LEFTUP";
					} else if (c[i - 1][j] >= c[i][j - 1]) {
						c[i][j] = c[i - 1][j];
						b[i][j] = "UP";
					} else {
						c[i][j] = c[i][j - 1];
						b[i][j] = "LEFT";
					}
				}
			}
			// c[m][n]为最大公共子序列长度
			System.out.println(c[m][n]);
			// 接下来是构造LCS 不在本题范围内，所以声明函数
			//printLCS(b, s1, m, n);
		}
	}
}
