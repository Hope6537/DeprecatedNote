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
				c1[fuI(index)] = 1;// 给负项赋值
				c1[zhI(index)] = 1;// 给正项赋值
			}
			c1[HALF] = 1;
			Arrays.sort(value);
			// input done
			int maxlength = zhI(value[0]);// 最初的累和项上界
			int minlength = fuI(value[0]);// 最初的累和项下界
			for (int m = 1; m < n1; m++) {
				int i = value[m];// 这是获得第m+1个表达式所代表的权值
				int location = fuI(i);// 这是改权值在当前数组中的低位
				int high = zhI(i);// 这是改权值在当前数组中的高位
				for (int j = minlength; j <= maxlength; j++) {
					for (int k = location; k <= high; k += i) {
						// 总共经历3项，低位 0 高位
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