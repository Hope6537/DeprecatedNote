package org.hope6537.graphs;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @Describe 走迷宫之深度优先搜索
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-6-2上午11:32:45
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1010 {

	static int abs(int a) {
		return a < 0 ? -a : a;
	}

	static Scanner s = new Scanner(new BufferedInputStream(System.in));

	static int sx, sy, ex, ey, n, m;// 分别代表开始x，y坐标和结束点x，y的坐标,和n行m列迷宫

	static char map[][];

	static int flag, step;// 标记和步数

	static int d[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 行走方式表

	// 即上，右，下，左

	static void dfs(int x, int y, int t) {
		if (flag == 1) {
			return;
		}
		if (t < abs(ex - x) + abs(ey - y)
				|| (t - abs(ex - x) + abs(ey - y)) % 2 != 0) {
			// 这是一个剪枝例程。若剩余时间-当前点到终点的横纵坐标之和为偶数，则该路最终到达终点时正好符合时间的
			// 如果为0则是无障碍道
			// 如果有障碍则绕道。即差值为-1+（nX2+3）为偶数 n是障碍数
			return;
		} else if (t == 0) {// 如果t==0时
			if (ex == x && ey == y) {
				// 符合条件，到达终点
				flag = 1;
				return;
			} else {
				return;
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + d[i][0];
				int ny = y + d[i][1];
				boolean isOK = nx > 0 && ny > 0 && nx <= n && ny <= m
						&& (map[nx][ny] == '.' || map[nx][ny] == 'D');
				if (isOK) {
					map[nx][ny] = 'X';
					dfs(nx, ny, t - 1);// 时间-1
					map[nx][ny] = '.';// 回溯
				}
			}
		}
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			n = s.nextInt();
			m = s.nextInt();
			int t = s.nextInt();
			if (n == 0 && m == 0 && t == 0) {
				break;
			}
			map = new char[n + 1][m + 1];
			for (int i = 1; i <= n; i++) {
				String str = s.next();
				for (int j = 1; j <= m; j++) {
					map[i][j] = str.charAt(j - 1);
					if (map[i][j] == 'S') {
						sx = i;
						sy = j;
					}
					if (map[i][j] == 'D') {
						ex = i;
						ey = j;
					}
				}
			}
			flag = 0;
			dfs(sx, sy, t);
			if (flag == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
