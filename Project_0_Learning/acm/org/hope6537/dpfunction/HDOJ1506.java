package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1506 {

	static Scanner s = new Scanner(System.in);

	static long min(long a, long b) {
		return a < b ? a : b;
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			long[] left = new long[n + 1];
			long[] right = new long[n + 1];
			long[] dp = new long[n + 1];
			long[] value = new long[n + 1];
			for (int i = 0; i <= n; i++) {
				value[i] = s.nextLong();
			}
			dp[1] = value[1];
			for (int i = 1; i <= n; i++) {
				while(dp[(int) (left[i]-1)]>=dp[i]){
					left[i] = left[(int) (left[i]-1)];
				}
			}
			for(int i = n ; i >= 1 ; i--){
				while(dp[(int) (right[i]+1)]>=dp[i]){
					right[i] = right[(int) (right[i]+1)];
				}
			}
		}
	}
}
