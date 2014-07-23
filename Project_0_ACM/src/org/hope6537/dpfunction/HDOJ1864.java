package org.hope6537.dpfunction;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe 最大报销额问题
 * @Author Hope6537(赵鹏) 原本金额的数目应该是double 但是这里应该改成int 以适应下标为整数的需要
 * 
 */
public class HDOJ1864 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int Q = (int) (s.nextDouble() * 100);
			int N = s.nextInt();
			if (N == 0) {
				break;
			}
			int[] money = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				int m = s.nextInt();
				int a = 0;
				int b = 0;
				int c = 0;
				int tag = 0;
				for (int j = 0; j < m; j++) {
					String item = s.next();
					String strs[] = item.split(":");
					char type = strs[0].charAt(0);
					int value = (int) (Double.parseDouble(strs[1]) * 100);
					if (type == 'A') {
						a += value;
					} else if (type == 'B') {
						b += value;
					} else if (type == 'C') {
						c += value;
					} else {
						tag = 1;
					}
					if (tag != 1 && a + b + c <= 100000 && a <= 60000
							&& b <= 60000 && c <= 60000) {
						money[i] = a + b + c;
					} else {
						money[i] = Q + 1;
					}
				}

			}
			// input done

			int dp[] = new int[Q + 5];
			for (int i = 1; i <= N; i++) {
				for (int j = Q; j >= money[i]; j--) {
						dp[j] = Math.max(dp[j], dp[j - money[i]]
								+ money[i]);
				}
			}

			System.out.printf("%.2f\r\n", dp[Q] * 1.0 / 100.0);

		}
	}
}
