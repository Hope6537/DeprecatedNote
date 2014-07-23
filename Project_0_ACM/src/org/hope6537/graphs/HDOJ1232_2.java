package org.hope6537.graphs;

import java.util.Scanner;

public class HDOJ1232_2 {

	static Scanner s = new Scanner(System.in);
	static int[][] map;
	static boolean[] visit;
	static int INF = 999999999;
	private static int towncount;

	static void dfs(int i) {
		visit[i] = true;

		for (int j = 0; j < towncount; j++) {
			if (map[i][j] == 1 && !visit[j]) {
				dfs(j);
			}
		}

	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			towncount = s.nextInt();
			if (towncount == 0) {
				break;
			}
			int roadcount = s.nextInt();
			map = new int[towncount][towncount];
			visit = new boolean[towncount];
			for (int i = 0; i < towncount; i++) {
				for (int j = 0; j < towncount; j++) {
					map[i][j] = INF;
				}
			}
			for (int i = 0; i < roadcount; i++) {
				int town1 = s.nextInt();
				int town2 = s.nextInt();
				map[town1 - 1][town2 - 1] = map[town2 - 1][town1 - 1] = 1;
			}
			for (int i = 0; i < towncount; i++) {
				map[i][i] = 0;
			}
			int count = 0;
			for (int i = 0; i < towncount; i++) {
				if (!visit[i]) {
					count++;
					dfs(i);
				}
			}
			System.out.println(count - 1);
		}
	}
}
