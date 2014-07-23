package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2143 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			boolean b = false;
			int a[] = { s.nextInt(), s.nextInt(), s.nextInt() };
			a: for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == j)
						continue;
					int k = 3 - i - j;
					/*
					 * 加法和减法重复，加法会超Int范围 乘除同理 除法/表示整除
					 */
					if (a[i] - a[j] == a[k]
							|| (a[j] != 0 && a[i] / a[j] == a[k] && a[i] % a[j] == 0)
							|| (a[j] != 0 && a[i] % a[j] == a[k])) {
						b = true;
						break a;
					}
				}
			}
			if (b) {
				System.out.println("oh,lucky!");
			} else {
				System.out.println("what a pity!");
			}
		}
	}
}
