package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2565 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int n = s.nextInt();
				for (int i = -n / 2; i <= n / 2; i++) {
					for (int j = -n / 2; j <= n / 2; j++) {
						if (j == i)
							printf("X");
						else if (j == -i)
							printf("X");
						else if (j > i && j < -i)
							printf(" ");
						else if (i > j)
							printf(" ");
					}
					printf("\r\n");
				}
				printf("\r\n");

			}
		}
	}

	private static void printf(String string) {
		System.out.print(string);
		
	}

}
