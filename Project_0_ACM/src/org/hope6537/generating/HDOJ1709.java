package org.hope6537.generating;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ1709 {
	static int MAX = 30000;
	static int HALF = MAX / 2;
	static Scanner s = new Scanner(System.in);

	public static int fuI(int i) {
		return HALF - i;
	}

	public static int zhI(int i) {
		return i + HALF;
	}

	public static void main(String[] args) {

		while (s.hasNext()) {
			int c1[] = new int[MAX];
			int c2[] = new int[MAX];

			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			int[] value = new int[n];
			int n1 = 0;
			while (n-- != 0) {
				int index = s.nextInt();
				value[n1] = index;
				n1++;
				c1[fuI(index)] = 1;// �����ֵ
				c1[zhI(index)] = 1;// �����ֵ
			}
			c1[HALF] = 1;
			Arrays.sort(value);
			// input done
			int maxlength = zhI(value[0]);// ������ۺ����Ͻ�
			int minlength = fuI(value[0]);// ������ۺ����½�
			for (int m = 1; m < n1; m++) {
				int i = value[m];// ���ǻ�õ�m+1�����ʽ�������Ȩֵ
				int location = fuI(i);// ���Ǹ�Ȩֵ�ڵ�ǰ�����еĵ�λ
				int high = zhI(i);// ���Ǹ�Ȩֵ�ڵ�ǰ�����еĸ�λ
				for (int j = minlength; j <= maxlength; j++) {
					for (int k = location; k <= high; k += i) {
						// �ܹ�����3���λ 0 ��λ
						int j_K = j + k;
						if (j_K > 10) {
							j_K = j_K - HALF;
						}
						c2[j_K] += c1[j];
					}
				}
				maxlength += i;
				minlength -= i;
				for (int j = minlength; j <= maxlength; j++) {
					c1[j] = c2[j];
					c2[j] = 0;
				}
			}
			int count = 0;
			for (int i = HALF; i <= maxlength; i++) {
				if (c1[i] == 0) {
					count++;
				}
			}
			if (count == 0) {
				System.out.println(count);
			} else {
				System.out.println(count);
				int flag = 0;
				for (int i = HALF; i <= maxlength; i++) {
					if (c1[i] == 0) {
						if (flag == 1) {
							System.out.print(" ");
						}
						System.out.print(i - HALF);
						flag = 1;
					}
				}
				System.out.println();
			}
		}

	}
}