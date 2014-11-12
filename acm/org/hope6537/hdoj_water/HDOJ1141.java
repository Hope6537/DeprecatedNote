package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1141 {

	static int year = 0;
	static int YEAR = 0;
	static int i = 0;
	static int j = 0;
	static int m = 0;
	// 这是年份
	static double weight = 0.0;// 这是该年份的位数

	static double fl = 0.0;// 这是累加年份

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (s.hasNext()) {
			year = s.nextInt();
			if (year == 0) {
				System.exit(0);
			}
			weight = Math.log(4);
			for (YEAR = 1960; YEAR <= year; YEAR += 10) {
				weight = weight * 2;
			}
			i = 1;
			fl = 0;
			while (fl < weight) {
				fl += Math.log((double) ++i);
			}
			System.out.println(i - 1);
		}

	}

}
