package org.hope6537.graphs;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HDOJ1242 {

	static int[][] map;

	static Scanner s = new Scanner(System.in);

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int time;

		@Override
		public String toString() {
			return "Node [time=" + time + ", x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Node o) {
			return time - o.time;
		}

	}

	static Node temp, next, end;

	static int N, M;

	static int[][] move = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	static PriorityQueue<Node> nodes;

	static int bfs() {

		while (!nodes.isEmpty()) {
			//System.out.println(nodes.toString());
			temp = nodes.poll();
			for (int i = 0; i < 4; i++) {
				int tx = temp.x + move[i][0];
				int ty = temp.y + move[i][1];
				boolean isOK = tx > 0 && ty > 0 && tx <= N && ty <= M
						&& map[tx][ty] != 0;
				if (isOK) {
					// System.out.println(tx + " " + ty);
					next = new Node();
					next.x = tx;
					next.y = ty;
					next.time = temp.time + map[tx][ty];
					nodes.add(next);
					
					if (tx == end.x && ty == end.y) {
					//	System.out.println("temp time" + temp.time);
						return temp.time + 1;
					}
					map[tx][ty] = 0;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			M = s.nextInt();
			N = s.nextInt();
			end = new Node();
			nodes = new PriorityQueue<Node>();
			map = new int[N + 1][M + 1];
			for (int j = 1; j <= M; j++) {
				String str = s.next();
				for (int i = 1; i <= N; i++) {
					char c = str.charAt(i - 1);
					int res = 0;
					if (c == '.') {
						res = 1;
					}
					if (c == '#') {
						res = 0;
					}
					if (c == 'x') {
						res = 2;
					}
					if (c == 'a') {
						next = new Node();
						next.x = i;
						next.y = j;
						next.time = 0;
						nodes.add(next);
						res = 1;
					}
					if (c == 'r') {
						end.x = i;
						end.y = j;
						res = 1;
					}
					map[i][j] = res;
				}
			}
			int time = bfs();
			if (time == -1) {
				System.out
						.println("Poor ANGEL has to stay in the prison all his life.");
			} else {
				System.out.println(time);
			}
		}
	}
}
