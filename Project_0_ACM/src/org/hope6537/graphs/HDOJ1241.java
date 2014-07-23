package org.hope6537.graphs;

import java.util.Scanner;

public class HDOJ1241 {

	static boolean visit[][];

	static char[][] map;

	static Scanner s = new Scanner(System.in);

	static int count, sx, sy, w, h;

	static boolean flag;

	static int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 },
			{ -1, -1 }, { 1, -1 }, { -1, 1 } };

	static boolean dfs(int x, int y) {
		if (map[x][y] == '*') {
			return flag;
		}
		flag = true;
		map[x][y] = '*';
		for (int i = 0; i < 8; i++) {
			int nx = x + move[i][0];
			int ny = y + move[i][1];
			boolean isOK = nx > 0 && ny > 0 && nx <= w && ny <= h;
			if (isOK) {
				dfs(nx, ny);
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			count = 0;
			h = s.nextInt();
			w = s.nextInt();
			if (h == 0 && w == 0) {
				break;
			}
			map = new char[w + 1][h + 1];
			visit = new boolean[w + 1][h + 1];
			for (int j = 1; j <= h; j++) {
				String str = s.next();
				for (int i = 1; i <= w; i++) {
					map[i][j] = str.charAt(i - 1);
				}
			}

			for (int i = 1; i <= w; i++) {
				for (int j = 1; j <= h; j++) {
					flag = false;
					if (dfs(i, j)) {
						count++;
					}
				}
			}
			System.out.println(count);

		}
	}
}
