package org.hope6537.tencent;

import java.util.Scanner;

public class HDOJ4500 {

	static Scanner s = new Scanner(System.in);

	static int[][] map;
	static int[][] heat;
	static int mx, my, max;
	static int[][] command = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	private static int n, m;

	static void init(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + command[i][0];
			int ny = y + command[i][1];
			int abs = map[x][y] > 0 ? -1 : 1;
			boolean isOK = nx >= 0 && ny >= 0 && nx < n && ny < m;
			if (isOK) {
				heat[x][y] += (abs * map[nx][ny]);
			}
		}
		if (heat[x][y] > max) {
			mx = x;
			my = y;
			max = heat[x][y];
		} else if (heat[x][y] == max) {
			if (x < mx) {
				mx = x;
				my = y;
				max = heat[x][y];
			} else if (x == mx) {
				if (y < my) {
					mx = x;
					my = y;
					max = heat[x][y];
				}
			}
		}
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			n = s.nextInt();
			m = s.nextInt();
			if (n == 0 && m == 0) {
				break;
			}
			mx = my = max = 0;
			map = new int[n][m];
			heat = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = s.nextInt();
				}
			}
			// input done
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					init(i, j);
				}
			}
			System.out.println((mx + 1) + " " + (my + 1) + " " + max);
		}
	}
}
