package org.hope6537.hdoj_water;

import java.io.IOException;
import java.util.Scanner;

public class HDOJ1097 {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int a, b, c;
		while (s.hasNext()) {
			int n = s.nextInt();
			for (int i = 0; i < n; i++) {
				a = s.nextInt();
				b = a;
				b %= 4;
				a %= 10;
				c = a;
				if (b == 0) {
					b = 4;
				}
				while (--b != 0) {
					c = c * a % 10;
				}
				System.out.println(c);
			}

		}

	}

}
