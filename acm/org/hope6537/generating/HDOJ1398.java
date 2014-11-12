package org.hope6537.generating;

import java.util.Scanner;

public class HDOJ1398 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			int c1[] = new int[500];
			int c2[] = new int[500];
			int nNum = n;
			for (int i = 0; i <= nNum; i++) {
				c1[i] = 1;
				c2[i] = 0;
			}
			for (int i = 2; i * i <= nNum; ++i) {

				for (int j = 0; j <= nNum; ++j)
					// ----- ③
					for (int k = 0; k + j <= nNum; k += i * i) {
						c2[j + k] += c1[j];
					}
				for (int j = 0; j <= nNum; ++j) {
					c1[j] = c2[j];
					c2[j] = 0;
				}
			}

			System.out.print(c1[n] + "\r\n");
		}
	}
}
