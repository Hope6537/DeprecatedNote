package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @Describe 和HDOJ1003一模一样
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-19下午02:24:37
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1231 {

	static Scanner s = new Scanner(System.in);
	static int MAX = 10005;

	public static void main(String[] args) {
		while (s.hasNext()) {
			// 状态方程d[i] = max{d[i - 1] + data[i], data[i]}
			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			int[] data = new int[MAX];
			int fuCount = 0;
			for (int i = 0; i < n; i++) {
				data[i] = s.nextInt();
				if (data[i] < 0) {
					fuCount++;
				}
			}
			if (fuCount == n) {
				System.out.println(0 + " " + data[0] + " " + data[n - 1]);
			} else {
				int[] d = new int[MAX];
				d[0] = data[0];
				int max = d[0];
				int sum = d[0];
				int temp = d[0];
				int start = d[0];
				int end = d[0];

				for (int i = 1; i < n; i++) {
					// 起点判断必须在这 重要
					if (sum < 0) {
						temp = data[i];
						sum = 0;
					}
					int d_i_1 = d[i - 1];// Debug用临时变量
					int dataValue = data[i];// Debug用临时变量
					if (d_i_1 + dataValue > dataValue) {
						d[i] = d_i_1 + dataValue;

					} else {
						d[i] = dataValue;
					}
					sum = d[i];//Debug用临时变量
					if (sum > max) {
						max = sum;
						end = dataValue;
						start = temp;
					}

				}
				System.out.println(max + " " + start + " " + end);
			}

		}
	}
}
