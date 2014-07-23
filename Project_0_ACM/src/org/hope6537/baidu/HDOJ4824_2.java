package org.hope6537.baidu;

import java.util.Scanner;

/**
 * @Describe �ٶ�֮�ǵڶ��� ˫��ŷ���������������
 * @Author Hope6537(����)
 * @Signdate 2014-6-5����06:22:57
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ4824_2 {

	/**
	 * @Describe ��ȡ���ݽڵ�
	 * @Author Hope6537(����)
	 * @Signdate 2014-6-5����06:23:20
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

	// ����װ������ �����������ݰ���t�ĵ���˳������
	static Node[] nodes;
	// dp(i,j)��¼�Ŵ�i��j�����Ȩֵ·�� ״̬���̷�Ϊ�������������
	static int dp[][];
	// �ڵ�ĸ���
	static int n;
	// ��¼��i��j��Ȩֵ
	static int dist[][];
	static int INF = 99999999;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * ��ʼ��
		 */
		dp = new int[1010][1010];
		dist = new int[1010][1010];
		nodes = new Node[1010];
		int t = s.nextInt();
		while (t-- != 0) {
			n = s.nextInt();
			n++;
			/*
			 * �����һ�����Ķ���(0,0)��
			 */
			nodes[1] = new Node(0, 0);
			for (int i = 2; i <= n; i++) {
				// ��һ������������1�������Եڶ�����2��ʼ
				nodes[i] = new Node(s.nextInt(), s.nextInt());
				// �ֱ����Ƕ������õ����ŽǶ�ֵ
				for (int j = 1; j < i; j++) {
					int res = Math.abs(nodes[i].s - nodes[j].s);
					res = res > 180 ? 360 - res : res;
					dist[i][j] = dist[j][i] = (nodes[i].t - nodes[j].t) * 400
							+ res;
					// ���㲢������Ȩֵ������
				}
			}
			// �����ж���֮���·���趨������Զ
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					dp[i][j] = dp[j][i] = INF;
				}
			}
			// ��¼���͵�һ�������ֵ|��ʼ���¡�
			dp[2][1] = dp[1][2] = dist[1][2];
			// �ӵڶ������㿪ʼ�� ���θ���״̬ת�Ʒ�����ȷ��
			/**
			 * @Question ˫��ŷ����û�·����
			 * @���� ��������˫�����⣬���Ա���Ҫ��һ����������x������ݰ��յ�������������ȷ�������ԣ��Ӷ�ȷ������������Ⱥ���
			 * @�����ӽṹ �����Pi��Pj��·��Ϊdp[i][j] = dp[j][i]
			 *        ��Pi��������һֱ��P1��Ȼ�������һֱ��Pj�������·����
			 *        ���ᾭ��Pmax(i,j)֮������е㣬�ҽ�����һ�Ρ��҂��H���]i>=j�����
			 * @���Ž� ����Ҫ���dp[n][n]��·��Ȩֵʱ��
			 * @�ֽ������� �ٵ�j < i-1ʱ dp(i.j) = dp(i-1,j) + dist(i-1,i);
			 *        �ж����֪����Pi-->1һ����Pi-->Pj������j �� i-1�����Pi���������ڵ���Pi-1 ��˿ɵù�ʽ
			 *        �ڵ�j = i-1ʱ dp(i,j) = dp(i,i-1) = min{d(k,j) + dist(k,j)} 1
			 *        <= k <= j; �۵�j = i ʱ ·����������������������P1--Pi P2--Pi ....
			 *        Pi-1--Pi ���dp(i,i) =
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
