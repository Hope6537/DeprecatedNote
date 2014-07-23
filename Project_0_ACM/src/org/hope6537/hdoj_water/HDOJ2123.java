package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2123 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int T = s.nextInt();
		while (T-- != 0) {
			int size = s.nextInt();
			for (int i = 1; i <= size; i++) {
				int flag = 0;
				for (int j = 1; j <= size; j++) {
					if (flag == 1) {
						System.out.print(" ");
					}
					System.out.print(i * j);
					flag = 1;
				}
				System.out.println();
			}
		}
	}

}
