package org.hope6537.greeting;

import java.util.Scanner;

public class HDOJ1045 {

	static Scanner s = new Scanner(System.in);

	private static class Count {
		int i = 0;
		int j = 0;
		int walls = 0;

		public Count(int i, int j) {
			this.i = i;
			this.j = j;
			this.walls = 0;
		}

		@Override
		public String toString() {
			return "Count [i=" + i + ", j=" + j + ", walls=" + walls + "]";
		}

	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n <= 0 || n > 4) {
				break;
			}
			char[][] city = new char[5][5];// Ϊ�˷�ֹ�ɱƣ�����0��ʼ
			for (int i = 1; i <= n; i++) {
				String str = s.next();
				for (int j = 1; j <= str.length(); j++) {
					city[i][j] = str.charAt(j - 1);
				}
			}
			// input ������ϣ�����̰���㷨Ѱ�ҳ�������ֻ�������������
			int maxNum = 0;
			// ��Ѱ�����������м���ǽ
			Count[] counts = new Count[16];
			int num = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					counts[num] = new Count(i, j);
					if (city[i][j] == '.') {
						// ����Ч·�� ��ʼѰ��ǽ�ĸ���
						for (int i1 = 1, j1 = 1;;) {
							if (i1 <= n) {
								if (city[i1][j] == 'X') {
									counts[num].walls++;
								}
								i1++;
							} else if (j1 <= n) {
								if (city[i][j1] == 'X') {
									counts[num].walls++;
								}
								j1++;
							} else {

								break;
							}

						}
					}
					num++;
				}
			}
			// Ȼ����������
			for (int i = 0; i < n * n; i++) {
				for (int j = 0; j < n * n; j++) {
					if (counts[i].walls > counts[j].walls) {
						Count temp = counts[i];
						counts[i] = counts[j];
						counts[j] = temp;
					}
				}
			}

			for (int k = 0; k < n * n; k++) {
				Count c = counts[k];// ȡ�����ǽ�����Ǹ�
				int i = c.i;
				int j = c.j;
				if (city[i][j] == '.') {
					maxNum++;
					for (int i1 = i; i1 <= n; i1++) { // ����
						if (city[i1][j] == '.') {
							city[i1][j] = '!';
						} else if (city[i1][j] == 'X') {// ����ǽͣ����
							break;
						}
					}
					for (int i1 = i; i1 >= 0; i1--) { // ����
						if (city[i1][j] == '.') {
							city[i1][j] = '!';
						} else if (city[i1][j] == 'X') {// ����ǽͣ����
							break;
						}
					}
					for (int j1 = j; j1 <= n; j1++) { // ����
						if (city[i][j1] == '.') {
							city[i][j1] = '!';
						} else if (city[i][j1] == 'X') {// ����ǽͣ����
							break;
						}
					}
					for (int j1 = j; j1 >= 0; j1--) { // ����
						if (city[i][j1] == '.') {
							city[i][j1] = '!';
						} else if (city[i][j1] == 'X') {// ����ǽͣ����
							break;
						}
					}
				}
			}
			System.out.println(maxNum);
		}
	}
}
