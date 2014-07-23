package org.hope6537.dpfunction;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class HDOJ2524 {

	static Scanner s = new Scanner(new BufferedInputStream(System.in));

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int n = s.nextInt();
				int m = s.nextInt();
				int dn = ((1 + n) * n) / 2;
				int dm = ((1 + m) * m) / 2;
				System.out.println(dn * dm);
			}

		}
	}

}
