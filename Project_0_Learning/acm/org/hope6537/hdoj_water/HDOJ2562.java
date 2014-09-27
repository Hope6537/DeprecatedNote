package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2562 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			while (n-- != 0) {
				String str = s.next();
				String newString = "";
				for (int i = 0; i < str.length()-1; i +=2 ) {
					newString += str.charAt(i + 1) + "" + str.charAt(i) ;
				}
				System.out.println(newString);
			}
		}
	}

}
