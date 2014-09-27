package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1144 {

	private static class leibie {
		@SuppressWarnings("unused")
		int classnum;
		int minnum;
		int[] classid;

		public leibie(int num, int min, int[] classid) {
			this.classnum = num;
			minnum = min;
			this.classid = classid;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {

			int isYes = 0;
			int k = s.nextInt();// 课程数
			if (k == 0) {
				break;
			}
			int m = s.nextInt();// 类别数

			int[] k_num = new int[k];
			for (int i = 0; i < k; i++) {
				k_num[i] = s.nextInt();
			}// 这是他修的列表
			// 接下来是输入类别
			leibie[] l = new leibie[m];
			for (int i = 0; i < m; i++) {
				int num = s.nextInt();
				int min = s.nextInt();
				int[] classid = new int[num];
				for (int j = 0; j < num; j++) {
					classid[j] = s.nextInt();
				}
				l[i] = new leibie(num, min, classid);
			}
			// 类别输入完成 开始检索

			for (int i = 0; i < l.length; i++) {// 类别迭代
				int count = 0;// 进行该类别科目的计数
				int[] temp = l[i].classid;// 类别科目
				// System.out.println(temp);
				for (int j = 0; j < temp.length; j++) {
					for (int t = 0; t < k_num.length; t++) {
						if (temp[j] == k_num[t]) {
							count++;
						}
					}
				}
				// System.out.println(count);
				if (count >= l[i].minnum) {
					isYes = isYes + 0;
				} else {
					isYes = isYes + 1;
				}

			}
			if (isYes > 0) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}
	}
}
