package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2567 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			while (n-- != 0) {
				String a = s.next();
				String b = s.next();
				String newString = "";
				for (int i = 0; i < a.length(); i++) {
					newString += a.charAt(i) + "";
					if (i + 1 == a.length() / 2) {
						newString += b;
					}
				}
				System.out.println(newString);
			}
		}
	}
}
