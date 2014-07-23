package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1260 {

	static Scanner s = new Scanner(System.in);

	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			while (n-- != 0) {
				int k = s.nextInt();
				int mintime = 0;
				String start = "08:00:00 am";
				int[] single = new int[k + 1];
				int[] couple = new int[k];
				for (int i = 1; i <= k; i++) {
					single[i] = s.nextInt();
				}
				for (int i = 1; i <= k - 1; i++) {
					couple[i] = s.nextInt();
				}
				// input done
				int[] dp = new int[k + 1];
				if (k == 1) {
					mintime = single[1];
				} else if (k == 2) {
					mintime = single[1] + single[2] < couple[1] ? single[1]
							+ single[2] : couple[1];
				} else {
					dp[1] = single[1];
					dp[2] = single[1] + single[2] < couple[1] ? single[1]
							+ single[2] : couple[1];
					for (int i = 3; i <= k; i++) {
						dp[i] = min(dp[i - 1] + single[i], dp[i - 2]
								+ couple[i - 1]);
					}
					mintime = dp[k];
				}
				//System.out.println(mintime);
				int hours = 8;
				int minute = 0;
				int second = 0;
				String dayLine = "am";
				if (mintime >= 3600) {
					hours += mintime / 3600;
					mintime = mintime % 3600;
				}
				if (hours >= 12) {
					dayLine = "pm";
				}
				if (mintime >= 60) {
					minute = mintime / 60;
					mintime = mintime % 60;
				}
				second = mintime;
				System.out.println((hours < 10 ? "0" + hours : hours) + ":"+ (minute < 10 ? "0" + minute : minute) + ":"+ (second < 10 ? "0" + second : second) + " "+ dayLine);
			}
		}
	}
}
