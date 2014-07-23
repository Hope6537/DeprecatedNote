package org.hope6537.hdoj_water;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ2109 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			int[] hdu = new int[n];
			int[] jpa = new int[n];
			for (int i = 0; i < n; i++) {
				hdu[i] = s.nextInt();
			}
			for (int i = 0; i < n; i++) {
				jpa[i] = s.nextInt();
			}

			Arrays.sort(hdu);
			Arrays.sort(jpa);
			int hs = 0;
			int js = 0;
			for (int i = 0; i < n; i++) {
				if (hdu[i] > jpa[i]) {
					hs += 2;
				} else if (hdu[i] == jpa[i]) {
					hs++;
					js++;
				} else {
					js += 2;
				}
			}
			System.out.println(hs + " vs " + js);
		}

	}
}
