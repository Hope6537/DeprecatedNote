package org.hope6537.graphs;

import java.util.Scanner;

public class HDOJ1312 {

	static boolean visit[];

	static char[][] map;

	static Scanner s = new Scanner(System.in);

	static int max, sx, sy, w, h;

	static int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + move[i][0];
			int ny = y + move[i][1];
			boolean isOK = nx > 0 && ny > 0 && nx <= w && ny <= h
					&& (map[nx][ny] == '.');
			if (isOK) {
				max++;
				map[nx][ny] = '#';
				dfs(nx, ny);
			}
		}
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			max = 1;
			w = s.nextInt();
			h = s.nextInt();
			if (w == 0 && h == 0) {
				break;
			}
			map = new char[w + 1][h + 1];
			for (int j = 1; j <= h; j++) {
				String str = s.next();
				for (int i = 1; i <= w; i++) {
					map[i][j] = str.charAt(i - 1);
					if (map[i][j] == '@') {
						sx = i;
						sy = j;
					}
				}
			}
			dfs(sx, sy);
			System.out.println(max);

		}
	}
}
