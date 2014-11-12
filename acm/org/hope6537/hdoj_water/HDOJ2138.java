package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2138 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		while (s.hasNext()) {
			int T = s.nextInt();
			int count = 0;
			while (T-- != 0) {
				int num = s.nextInt();
				num = (int) Math.sqrt(num);
				boolean flag = false;
				for (int i = 2; i <= num; i++) {
					if (num % i == 0) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
