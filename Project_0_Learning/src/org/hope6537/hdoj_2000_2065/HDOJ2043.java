package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2043 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		while (s.hasNext()) {

			int n = Integer.parseInt(s.nextLine());
			for (int i = 0; i < n; i++) {
				int a = 0;
				int b = 0;
				int c1 = 0;
				int d = 0;
				String p = s.nextLine();
				if (p.length() >= 8 && p.length() <= 16) {
					for (int j = 0; j < p.length(); j++) {
						char c = p.charAt(j);
						if (c >= 'A' && c <= 'Z') {
							a = 1;
						}
						if (c >= 'a' && c <= 'z') {
							b = 1;
						}
						if (c >= '0' && c <= '9') {
							c1 = 1;
						}
						if (c == '~' || c == '!' || c == '@' || c == '#'
								|| c == '$' || c == '%' || c == '^') {
							d = 1;
						}
					}

					if (a + b + c1 + d >= 3) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				}
			}
		}
	}

}
