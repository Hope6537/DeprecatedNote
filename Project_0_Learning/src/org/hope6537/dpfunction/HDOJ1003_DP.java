package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @Describe 状态方程解法
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-19上午09:43:19
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1003_DP {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			int cases = 1;
			for (int k = 0 ; k < T ; k++) {
				int n = s.nextInt();
				int dp[] = new int[1005];
				int[] nums = new int[n];
				for (int i = 0; i < n; i++) {
					nums[i] = s.nextInt();
				}
				dp[0] = nums[0];
				// input done
				// 状态方程 设dp[J]表示第J处，以nums[J] 结尾的子序列的最大和。
				// 则dp[J] = max(nums[J] + dp[J-1] , nums[J]) ，
				// 而我们的所求的答案，就是从1- N对B数组求最大值。
				// d[i] = max{d[i - 1] + data[i], data[i]}
				int start = 1;
				int end = 0;
				int max = Integer.MIN_VALUE;
				for (int i = 1; i < n; i++) {
					dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
					if (dp[i] > max) {
						max = dp[i];
						start = i+1;
						end = i + 1;
					}
					if (dp[i - 1] < 0) {
						start = i + 1;
						end = start;
					}

				}
				System.out.println("Case " + (k+1) + ":");
				System.out.println(max + " " + start + " " + end);
				if(k<T){
					System.out.println();
				}
			}
		}
	}
}
