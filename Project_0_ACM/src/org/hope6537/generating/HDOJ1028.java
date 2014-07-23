package org.hope6537.generating;

import java.util.Scanner;

public class HDOJ1028 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();

			int c1[] = new int[125];
			int c2[] = new int[125];
			int nNum = n;
			for (int i = 0; i <= nNum; ++i) {
				c1[i] = 1;
				c2[i] = 0;
			}
			for (int i = 2; i <= nNum; ++i) {

				for (int j = 0; j <= nNum; ++j)

					for (int k = 0; k + j <= nNum; k += i) {
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
