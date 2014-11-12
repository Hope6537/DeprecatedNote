package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ2059 {

	static Scanner s = new Scanner(System.in);

	/*
	 * 第一行是一个整数L代表跑道的总长度 第二行包含三个整数N，C，T，分别表示充电站的个数，电动车冲满电以后能行驶的距离以及每次充电所需要的时间
	 * 第三行也是三个整数VR，VT1，VT2，分别表示兔子跑步的速度，乌龟开电动车的速度，乌龟脚蹬电动车的速度
	 * 第四行包含了N(N<=100)个整数p1,p2...pn,分别表示各个充电站离跑道起点的距离，其中0<p1<p2<...<pn<L
	 */
	public static double max(double a, double b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			double L = s.nextDouble();
			int N = s.nextInt();
			double C = s.nextDouble();
			double T = s.nextDouble();
			double VR = s.nextDouble();
			double VT1 = s.nextDouble();
			double VT2 = s.nextDouble();
			double[] P = new double[N + 2];
			for (int i = 1; i <= N; i++) {
				P[i] = s.nextDouble();
			}
			P[N + 1] = L;
			double rabbitTime = 1.0 * L / VR;
			// input done
			// 列状态方程啊同学 .....草
			// 那么加油站在起点是0 第一个加油站下标是1---->N
			// dp[i]代表乌龟经过要从第i个加油站准备出发时的时间
			// dp[i] = dp[i-1]+Max{T + len - C > 0 ? C/VT1 + len-C / VT2 :
			// len/VT1 , (C-tempC)/VT1 + (len - (C - tempC) > 0?len - (C -
			// tempC) : 0 )/VT2}
			double dp[] = new double[N + 2];
			dp[0] = 0;
			double len = P[1] - 0;
			double tempC = 0;
			for (int i = 1; i < N + 2; i++) {
				double tempTempC1 = tempC;
				double tempTempC2 = tempC;
				double sit1 = 0;
				if (i >= 2) {
					len = P[i] - P[i - 1];
					sit1 += T;
				}
				// 第一种情况 就是加油再冲

				// 已经加过油了 可以全速跑
				tempTempC1 = 0;
				if (len - (C - tempTempC1) > 0) {
					// 剩下的里程不够跑 C-tempC 才是现在能开车的里程数
					sit1 += (C - tempTempC1) / VT1 + (len - (C - tempTempC1))
							/ VT2;
					tempTempC1 = C;
				} else {
					// 剩下的里程够跑
					sit1 += len / VT1;
					tempTempC1 += len;
				}

				// 第二种情况 就是直接冲
				double sit2 = 0;
				if (C - tempC > len) {
					sit2 += len / VT1;
					tempTempC2 = tempC + len;
				} else if (C - tempC <= len) {
					sit2 += (C - tempC) / VT1;
					if (len - (C - tempC) > 0) {
						sit2 += (len - (C - tempC)) / 2;
					}
					tempTempC2 = C;
				}

				dp[i] = dp[i - 1];
				if (sit1 < sit2) {
					dp[i] += sit1;
					tempC = tempTempC1;
				} else {
					dp[i] += sit2;
					tempC = tempTempC2;
				}
			}
			/*
			 * System.out.println(rabbitTime); System.out.println(dp[N+1]);
			 */
			System.out.println(rabbitTime > dp[N + 1] ? "What a pity rabbit!"
					: "Good job,rabbit!");
		}
	}
}
