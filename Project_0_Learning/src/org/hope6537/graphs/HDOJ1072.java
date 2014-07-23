package org.hope6537.graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class HDOJ1072 {

	static Scanner s = new Scanner(System.in);

	static int[][] move = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	static class Node {
		int x;
		int y;
		int time;
		int lasttime;

		@Override
		public String toString() {
			return "Node [lasttime=" + lasttime + ", time=" + time + ", x=" + x
					+ ", y=" + y + "]";
		}

		public Node(int x, int y, int time, int lasttime) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.lasttime = lasttime;
		}

		public Node() {

		}

	}

	static int map[][];

	static int N, M;

	static Node start, temp, next;

	static LinkedList<Node> quene;

	static int bfs() {
		while (!quene.isEmpty()) {
			temp = quene.poll();

			for (int i = 0; i < 4; i++) {
				next = new Node();
				int tx = temp.x + move[i][0];
				int ty = temp.y + move[i][1];
				next.x = tx;
				next.y = ty;
				boolean legal = tx > 0 && ty > 0 && tx <= N && ty <= M
						&& map[tx][ty] != 0 && temp.lasttime > 1;// 即边界合法的同时，还能走别的路程
				if (legal) {
					if (map[tx][ty] == 3) {
						return temp.time + 1;
					} else if (map[tx][ty] == 1) {
						next.time = temp.time + 1;
						next.lasttime = temp.lasttime - 1;
						quene.addLast(next);
					} else if (map[tx][ty] == 4) {
						next.time = temp.time + 1;
						next.lasttime = 6;
						quene.addLast(next);
						map[tx][ty] = 0;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				M = s.nextInt();
				N = s.nextInt();
				quene = new LinkedList<Node>();
				map = new int[N + 1][M + 1];
				for (int j = 1; j <= M; j++) {
					for (int i = 1; i <= N; i++) {
						map[i][j] = s.nextInt();
						if (map[i][j] == 2) {
							start = new Node(i, j, 0, 6);
							quene.addLast(start);
							map[i][j] = 0;
						}
					}
				}
				int res = bfs();
				System.out.println(res);

			}
		}
	}

}
