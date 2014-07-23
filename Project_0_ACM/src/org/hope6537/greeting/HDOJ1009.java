package org.hope6537.greeting;

import java.util.Scanner;

public class HDOJ1009 {
	static Scanner s = new Scanner(System.in);

	private static class Trade {
		int j;
		int f;
		double prize;

		public Trade(int j, int f) {
			this.j = j;
			this.f = f;
			prize = 1.0 * (j * 1.0 / f);
		}

		@Override
		public String toString() {
			return "Trade [f=" + f + ", j=" + j + ", prize=" + prize + "]";
		}

	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int m = s.nextInt();
			int n = s.nextInt();
			if (m == n && m == -1) {
				break;
			}
			Trade[] trades = new Trade[n];
			for (int i = 0; i < n; i++) {
				trades[i] = new Trade(s.nextInt(), s.nextInt());
			}
			// input done
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (trades[i].prize > trades[j].prize) {
						Trade t = trades[i];
						trades[i] = trades[j];
						trades[j] = t;
					}

				}
			}
			// 排序完毕
			double jSum = 0; // 这是他得到的
			double fSum = m; // 这是他原有的
			for (int i = 0; i < n; i++) {
				if (fSum <= 0) {
					break;
				}
				Trade t = trades[i];
				if (fSum > t.f) {// 如果完全付得起
					fSum -= t.f;
					jSum += t.j;
				} else {
					double a = fSum / t.f;
					fSum = 0;
					jSum += (t.j * a);
				}
			}
			System.out.printf("%.3f\r\n", jSum);
		}

	}
}