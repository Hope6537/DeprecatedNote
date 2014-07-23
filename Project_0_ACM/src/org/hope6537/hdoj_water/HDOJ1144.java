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
			int k = s.nextInt();// �γ���
			if (k == 0) {
				break;
			}
			int m = s.nextInt();// �����

			int[] k_num = new int[k];
			for (int i = 0; i < k; i++) {
				k_num[i] = s.nextInt();
			}// �������޵��б�
			// ���������������
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
			// ���������� ��ʼ����

			for (int i = 0; i < l.length; i++) {// ������
				int count = 0;// ���и�����Ŀ�ļ���
				int[] temp = l[i].classid;// ����Ŀ
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
