package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2564 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String n = s.nextLine();
		int N = Integer.parseInt(n);
		while (N-- != 0) {
			String string = s.nextLine();
			String[] strings = string.split(" ");
			String newString = "";
			for (int i = 0; i < strings.length; i++) {
				if (!strings[i].isEmpty()) {
					newString += strings[i].charAt(0);

				}
			}
			newString = newString.toUpperCase();
			System.out.println(newString);
		}
	}
}
