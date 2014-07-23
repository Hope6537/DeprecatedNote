package org.hope6537.graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class HDOJ1495 {

	static Scanner s = new Scanner(System.in);

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static int sum, n, m; // �ֱ�������ƿ����������һ��ƿ�ӵ��������ڶ���ƿ�ӵ�����
	static int MAX = 150;

	static boolean mark[][];// ��ʾ����a,b��ˮi,j��״̬�Ƿ񵽴��

	static class Node {
		int a, b, c, time;// ������a,b,c���ˮ���͵�ˮ�Ĵ���

		public Node() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + ", c=" + c + ", time=" + time
					+ "]";
		}

		public Node(int a, int b, int c, int time) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
			this.time = time;
		}
	}

	static Node start;

	static int BFS() {

		start = new Node(2 * sum, 0, 0, 0);
		mark[start.a][start.b] = true;
		Node oq, next = null;
		LinkedList<Node> q = new LinkedList<Node>();
		q.addLast(start);
		while (!q.isEmpty()) {
			oq = q.poll();
			int x = 2 * sum - oq.a;
			int y = n - oq.b;
			int z = m - oq.c;
			if (x != 0) {// ���������a���浹ˮ
				if (oq.b != 0) {
					next = new Node(oq.a + min(x, oq.b), oq.b - min(x, oq.b),
							oq.c, oq.time + 1);// b��a��ˮ
				}
				if (!mark[next.a][next.b]) {
					mark[next.a][next.b] = true;
					if (next.a == sum && next.b == sum
							|| (next.a == sum && next.c == sum)
							|| (next.b == sum && next.c == sum))
						return next.time;
					q.addLast(next);
				}
				if (oq.c != 0)
					next = new Node(oq.a + min(x, oq.c), oq.b, oq.c
							- min(x, oq.c), oq.time + 1);// c��a��ˮ
				if (!mark[next.a][next.b]) {
					mark[next.a][next.b] = true;
					if (next.a == sum && next.b == sum
							|| (next.a == sum && next.c == sum)
							|| (next.b == sum && next.c == sum))
						return next.time;
					q.addLast(next);
				}
			}
			if (y != 0) {// ��b���浹ˮ
				if (oq.a != 0)
					next = new Node(oq.a - min(oq.a, y), oq.b + min(oq.a, y),
							oq.c, oq.time + 1);// a��b��ˮ
				if (!mark[next.a][next.b]) {
					mark[next.a][next.b] = true;
					if (next.a == sum && next.b == sum
							|| (next.a == sum && next.c == sum)
							|| (next.b == sum && next.c == sum))
						return next.time;
					q.addLast(next);
				}
				if (oq.c != 0) {
					next = new Node(oq.a, oq.b + min(y, oq.c), oq.c
							- min(y, oq.c), oq.time + 1);// c��b��ˮ
				}
				if (!mark[next.a][next.b]) {
					mark[next.a][next.b] = true;
					if (next.a == sum && next.b == sum
							|| (next.a == sum && next.c == sum)
							|| (next.b == sum && next.c == sum))
						return next.time;
					q.addLast(next);
				}
			}
			if (z != 0) {// ��c��ˮ
				if (oq.a != 0) {
					next = new Node(oq.a - min(oq.a, z), oq.b, oq.c
							+ min(oq.a, z), oq.time + 1);// a��c��ˮ
				}
				if (!mark[next.a][next.b]) {
					mark[next.a][next.b] = true;
					if (next.a == sum && next.b == sum
							|| (next.a == sum && next.c == sum)
							|| (next.b == sum && next.c == sum))
						return next.time;
					q.addLast(next);
				}
				if (oq.b != 0) {
					next = new Node(oq.a, oq.b - min(oq.b, z), oq.c
							+ min(oq.b, z), oq.time + 1);// b��c��ˮ
				}
				if (!mark[next.a][next.b]) {
					mark[next.a][next.b] = true;
					if (next.a == sum && next.b == sum
							|| (next.a == sum && next.c == sum)
							|| (next.b == sum && next.c == sum))
						return next.time;
					q.addLast(next);
				}
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			sum = s.nextInt();
			n = s.nextInt();
			m = s.nextInt();
			mark = new boolean[MAX][MAX];
			if (sum == 0 && n == 0 && m == 0) {
				break;
			}
			if (sum % 2 != 0) {
				System.out.println("NO");
				continue;
			}
			sum = sum / 2;
			int temp = BFS();
			if (temp == -1) {
				System.out.println("NO");
			} else {
				System.out.println(temp);
			}
		}
	}

}
