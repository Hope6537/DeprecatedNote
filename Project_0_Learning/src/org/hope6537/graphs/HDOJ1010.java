package org.hope6537.graphs;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @Describe ���Թ�֮�����������
 * @Author Hope6537(����)
 * @Signdate 2014-6-2����11:32:45
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1010 {

	static int abs(int a) {
		return a < 0 ? -a : a;
	}

	static Scanner s = new Scanner(new BufferedInputStream(System.in));

	static int sx, sy, ex, ey, n, m;// �ֱ����ʼx��y����ͽ�����x��y������,��n��m���Թ�

	static char map[][];

	static int flag, step;// ��ǺͲ���

	static int d[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // ���߷�ʽ��

	// ���ϣ��ң��£���

	static void dfs(int x, int y, int t) {
		if (flag == 1) {
			return;
		}
		if (t < abs(ex - x) + abs(ey - y)
				|| (t - abs(ex - x) + abs(ey - y)) % 2 != 0) {
			// ����һ����֦���̡���ʣ��ʱ��-��ǰ�㵽�յ�ĺ�������֮��Ϊż�������·���յ����յ�ʱ���÷���ʱ���
			// ���Ϊ0�������ϰ���
			// ������ϰ����Ƶ�������ֵΪ-1+��nX2+3��Ϊż�� n���ϰ���
			return;
		} else if (t == 0) {// ���t==0ʱ
			if (ex == x && ey == y) {
				// ���������������յ�
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
					dfs(nx, ny, t - 1);// ʱ��-1
					map[nx][ny] = '.';// ����
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
