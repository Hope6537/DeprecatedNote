package org.hope6537.graphs;

import java.util.Scanner;

/**
 * @Describe 畅通工程 图的深度优先遍历 1140MS
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-25下午09:02:51
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1232 {

	static Scanner s = new Scanner(System.in);

	static int map[][];//使用邻接矩阵
	static int visited[];
	static int n;

	/**
	 * @Descirbe 深度优先搜索（标记法）
	 * @Author Hope6537(赵鹏)
	 * @Params @param i
	 * @SignDate 2014-5-25下午09:03:14
	 * @Version 0.9
	 */
	static void dfs(int i) {
		visited[i] = 1;
		for (int j = 0; j < n; j++) {
			if (visited[j] == 0 && map[i][j] == 1) {
				dfs(j);
			}
		}
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			n = s.nextInt();
			if (n == 0) {
				break;
			}
			int m = s.nextInt();
			visited = new int[n];
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < m; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				map[x - 1][y - 1] = 1;
				map[y - 1][x - 1] = 1;
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				if(visited[i] == 0){
					count++;
					dfs(i);
				}
			}
			System.out.println(count-1);
		}
	}

}
