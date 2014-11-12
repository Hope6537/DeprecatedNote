package org.hope6537.graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class HDOJ1175 {

	static Scanner s = new Scanner(System.in);

	static class Node {
		int x;
		int y;
		int t; //该点被遍历的次数
		int d; //改点的前驱
		@Override
		public String toString() {
			return "Node [d=" + d + ", t=" + t + ", x=" + x + ", y=" + y + "]";
		}
		public Node(int x, int y, int t, int d) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
			this.d = d;
		}

		public Node() {

		}
	}

	static int map[][];
	static boolean visit[][][];

	static int[][] move = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	static int N, M; // 行数和列数 分别对应y,x;

	static Node start, temp, next;

	static LinkedList<Node> nodes;

	static boolean bfs() {
		return false;/*

		while (!nodes.isEmpty()) {
			temp = nodes.poll();
			
			if (temp.x == temp.tx && temp.y == temp.ty) {
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + move[i][0];
				int ny = temp.y + move[i][1];
				System.out.println(nx + " " + ny);
				boolean legal = nx > 0 && ny > 0 && nx <= M && ny <= N && !visit[nx][ny];
				if (legal) {
					visit[temp.x][temp.y] = true;
					if (nx == temp.tx && ny == temp.ty) {
						return true;
					} else if (map[nx][ny] == 0) {
						next = new Node(nx, ny, temp.tx, temp.ty);
						nodes.addLast(next);
					}
				}
			}
		}
		return false;

	*/}

	public static void main(String[] args) {
		while (s.hasNext()) {
			N = s.nextInt();
			M = s.nextInt();
			nodes = new LinkedList<Node>();
			map = new int[N + 1][M + 1];
		//	visit = new boolean[N + 1][M + 1];
			for (int j = 1; j <= N; j++) {
				for (int i = 1; i <= M; i++) {
					map[j][i] = s.nextInt();
				}
			}
			int q = s.nextInt();
			for (int i = 0; i < q; i++) {
				nodes.clear();
				int x1 = s.nextInt();
				int y1 = s.nextInt();
				int x2 = s.nextInt();
				int y2 = s.nextInt();

				start = new Node(y1, x1, y2, x2);
				nodes.addLast(start);
				System.out.println(bfs());
			}

		}
	}
}
