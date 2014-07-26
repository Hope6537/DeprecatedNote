package org.hope6537.baidu;

import java.util.Scanner;

/**
 * @Describe 百度之星第二题 双调欧几里得旅行商问题
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-6-5下午06:22:57
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ4824_2 {

	/**
	 * @Describe 读取数据节点
	 * @Author Hope6537(赵鹏)
	 * @Signdate 2014-6-5下午06:23:20
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	static class Node {
		int t;
		int s;

		public Node(int t, int s) {
			super();
			this.t = t;
			this.s = s;
		}

	}

	// 对象装载容器 其中所有数据按照t的递增顺序排序
	static Node[] nodes;
	// dp(i,j)记录着从i到j的最短权值路径 状态方程分为三种情况，下列
	static int dp[][];
	// 节点的个数
	static int n;
	// 记录从i到j的权值
	static int dist[][];
	static int INF = 99999999;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 初始化
		 */
		dp = new int[1010][1010];
		dist = new int[1010][1010];
		nodes = new Node[1010];
		int t = s.nextInt();
		while (t-- != 0) {
			n = s.nextInt();
			n++;
			/*
			 * 载入第一个起点的对象，(0,0)；
			 */
			nodes[1] = new Node(0, 0);
			for (int i = 2; i <= n; i++) {
				// 第一个定点在索引1处，所以第二个从2开始
				nodes[i] = new Node(s.nextInt(), s.nextInt());
				// 分别计算角度相差，并得到最优角度值
				for (int j = 1; j < i; j++) {
					int res = Math.abs(nodes[i].s - nodes[j].s);
					res = res > 180 ? 360 - res : res;
					dist[i][j] = dist[j][i] = (nodes[i].t - nodes[j].t) * 400
							+ res;
					// 计算并储存在权值数组里
				}
			}
			// 将所有顶点之间的路径设定成无限远
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					dp[i][j] = dp[j][i] = INF;
				}
			}
			// 记录起点和第一个顶点的值|初始化下。
			dp[2][1] = dp[1][2] = dist[1][2];
			// 从第二个顶点开始， 依次根据状态转移方程来确定
			/**
			 * @Question 双调欧几里得回路问题
			 * @分析 ①由于属双调问题，所以必须要有一个数据坐标x轴的数据按照单调递增来排序确保有序性，从而确定顶点遍历的先后性
			 * @最优子结构 定义从Pi到Pj的路径为dp[i][j] = dp[j][i]
			 *        从Pi从右向左一直到P1，然后从左到右一直到Pj，在这个路径上
			 *        ，会经过Pmax(i,j)之间的所有点，且仅经过一次。我們僅考慮i>=j的情况
			 * @最优解 我们要求出dp[n][n]的路径权值时间
			 * @分解子问题 ①当j < i-1时 dp(i.j) = dp(i-1,j) + dist(i-1,i);
			 *        有定义可知，点Pi-->1一定在Pi-->Pj上又有j ＜ i-1，因此Pi的最面相邻点是Pi-1 因此可得公式
			 *        ②当j = i-1时 dp(i,j) = dp(i,i-1) = min{d(k,j) + dist(k,j)} 1
			 *        <= k <= j; ③当j = i 时 路径中最后相连的两点可能是P1--Pi P2--Pi ....
			 *        Pi-1--Pi 因此dp(i,i) =
			 *        min{dp(i,1)+dist(1,i),...,dp(i,i-1)+dist(i-1,i)}
			 */
			for (int j = 3; j <= n; j++)

			{
				dp[j][1] = dp[1][j] = dp[1][j - 1] + dist[j - 1][j];
			}
			for (int i = 2; i <= n; i++) {
				int ans = INF;
				for (int k = 1; k < i; k++) {
					if (ans > dp[i][k] + dist[k][i + 1]) {
						ans = dp[i][k] + dist[k][i + 1];
					}
				}
				dp[i + 1][i] = dp[i][i + 1] = ans;
				for (int j = i + 2; j <= n; j++) {
					dp[j][i] = dp[i][j] = dp[i][j - 1] + dist[j - 1][j];
				}
			}
			dp[n][n] = dp[n][n - 1] + dist[n - 1][n];
			System.out.println(dp[n][n] + (n - 1) * 10);
		}
	}

}
