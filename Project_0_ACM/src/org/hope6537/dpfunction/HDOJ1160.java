package org.hope6537.dpfunction;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ1160 {

	static Scanner s = new Scanner(
			"6008 1300 6000 2100 500 2000 1000 4000 1100 3000 6000 2000 8000 1400 6000 1200 2000 1900");

	private static class Mouse implements Comparable<Mouse> {
		int speed;
		int weight;

		public Mouse(int weight, int speed) {
			super();
			this.speed = speed;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Mouse [speed=" + speed + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Mouse o) {
			if (this.weight > o.weight) {
				return -1;
			} else if (this.weight == o.weight) {
				if (this.speed < o.speed) {
					return -1;
				} else {
					return 1;
				}
			} else if (this.weight == o.weight && this.speed == o.speed) {
				return 0;
			} else {
				return 1;
			}

		}

	}

	public static void main(String[] args) {
		Mouse[] mouses = new Mouse[1005];
		int i = 0;
		while (s.hasNext()) {
			mouses[i++] = new Mouse(s.nextInt(), s.nextInt());
		}
		Arrays.sort(mouses);
		// input done
		int dp[] = new int[1005];
		dp[0] = 1;
		for (int j = 0; j < i; j++) {
			Mouse temp = mouses[j];
			for (int k = 0; k < j; k++) {
				Mouse temp2 = mouses[k];
				dp[j] = Math.max(dp[j], dp[k] + 1);
				if (temp2.speed > temp.speed && temp2.weight < temp.weight) {

				}
			}
		}
	}
}
