package org.hope6537.hdoj_water;

import java.util.Scanner;

/**
 * @deprecated
 * @Describe
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-17下午08:25:00
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1202 {

	static Scanner s = new Scanner(System.in);

	/**
	 * @Descirbe A90 - 100 4 点 B80 - 89 3 点 C70 - 79 2 点 D60 - 69 1 点 E0 - 59 0点
	 * @Author Hope6537(赵鹏)
	 * @Params @param s
	 * @Params @param g
	 * @Params @return
	 * @SignDate 2014-5-17下午07:56:39
	 * @Version 0.9
	 */
	public static double gpa(int s, double g) {
		int point = 0;
		if (g >= 90 && g <= 100) {
			point = 4;
		} else if (g >= 80 && g < 90) {
			point = 3;
		} else if (g >= 70 && g < 80) {
			point = 2;
		} else if (g >= 60 && g < 70) {
			point = 1;
		} else {
			point = 0;
		}
		return s * 1.0 * point;

	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int sumsc = 0;
			double gpa = 0;
			int k = 0;
			for (int i = 0; i < n; i++) {
				int sc = s.nextInt();
				double g = s.nextDouble();
				if (g >= 90 && g <= 100) {
					sumsc += sc;
					gpa += 4 * sc;
				} else if (g >= 80 && g < 90) {
					sumsc += sc;
					gpa += 3 * sc;
				} else if (g >= 70 && g < 80) {
					sumsc += sc;
					gpa += 2 * sc;
				} else if (g >= 60 && g < 70) {
					sumsc += sc;
					gpa += 1 * sc;
				} else if (g >= 0 && g < 60) {
					sumsc += sc;
					gpa += 0 * sc;
				} else {
					k++;
				}

			}
			if (sumsc == 0 || k == n) {
				System.out.println("-1");
			} else {
				System.out.printf("%.2f\r\n", gpa * 1.0 / sumsc);
			}

		}
	}

}
