package org.hope6537.tencent;

import java.util.Scanner;

/**
 * @Describe 多重状态01背包问题
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-6-5下午05:55:52
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ4501 {

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int k = s.nextInt();
			node[] ns = new node[n + 1];
			for (int i = 1; i <= n; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				int c = s.nextInt();
				ns[i] = new node(a, b, c);
			}
			//本题出现了多种状态 即可以用白拿名额，还可以用现金买，用积分兑换。简直纵的飞起来
			int dp[][][] = new int[k + 1][v1 + 1][v2 + 1];
			for (int i = 1; i <= n; i++) {
				//一维数组01背包法。
				for (int x = k; x >= 0; x--) {
					for (int y = v1; y >= 0; y--) {
						for (int z = v2; z >= 0; z--) {
							int temp = 0;
							if (x - 1 >= 0) {
								temp = max(temp, dp[x - 1][y][z] + ns[i].value);
							}
							if (y - ns[i].a >= 0) {
								temp = max(temp, dp[x][y - ns[i].a][z]
										+ ns[i].value);
							}
							if (z - ns[i].b >= 0) {
								temp = max(temp, dp[x][y][z - ns[i].b]
										+ ns[i].value);
							}
							dp[x][y][z] = max(temp, dp[x][y][z]);
						}
					}
				}
			}
			System.out.println(dp[k][v1][v2]);
		}
	}

	static Scanner s = new Scanner(System.in);

	static class node {
		int a;
		int b;
		int value;

		public node(int a, int b, int value) {
			super();
			this.a = a;
			this.b = b;
			this.value = value;
		}

		@Override
		public String toString() {
			return "node [a=" + a + ", b=" + b + ", value=" + value + "]";
		}

	}

	static int max(int a, int b) {
		return a > b ? a : b;
	}
}
