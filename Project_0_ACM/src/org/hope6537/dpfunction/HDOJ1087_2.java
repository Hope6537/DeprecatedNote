package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @状态转移方程式为 dp[i] = Max(dp[j]+value[i] , value[i]);
 * @状态方程的意义 dp[i] 代表的是以value[i]为结尾的最大分数，即从跳到i位置时的最优解,其中value[j] < value[i]
 *          即i可以从j跳过去 类似于1跳3 1 = j 而 3 = i (0<=j<i) 即i在j之后;
 * @Dp性质
 * @其边界为 dp[0]，即从跳到第一个顶点
 * @最优子结构为 每个dp[i]都是最优解
 * @条件判定 即value[j]<value[i] 否则无法从j跳到i处，即i的前驱不可能是j;
 */
public class HDOJ1087_2 {

	static Scanner s = new Scanner(System.in);
	static int MAX = 1005;

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			// 代表的值的方程
			int value[] = new int[MAX];
			// 代表动态规划的值
			int dp[] = new int[MAX];
			// 然后从第一个点开始输入权值
			for (int i = 0; i < n; i++) {
				value[i] = s.nextInt();
			}
			// 将最大值暂时赋给从第一个点出发然后直接跳到终点的路径权值
			// max代表的是最大终点累和
			int max = value[0];
			//dp[0]代表的是从起点出发跳到第一个点，只有一种情况，视为边界
			dp[0] = value[0];
			// input done;
			//从第二个顶点开始
			for (int i = 1; i < n; i++) {
				//获取到直接从起点跳到顶点的额值
				dp[i] = value[i];
				for (int j = 0; j < i; j++) {
					//然后找他的前驱 j---->i
					if (value[i] > value[j]) {
						//如果符合前驱条件
						if (dp[i] < dp[j] + value[i]) {
							//同时累和跳还大于直接跳过来的||或者是大于从其他点跳过来的。那么赋值
							dp[i] = dp[j] + value[i];
						}
					}
				}
				//如果跳到i点的值，再直接跳到终点大于现有的终点值，那么取代
				if (dp[i] > max) {
					max = dp[i];
				}
			}
			System.out.println(max);
		}
	}

}
