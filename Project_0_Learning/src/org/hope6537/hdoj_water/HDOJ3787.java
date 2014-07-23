package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ3787 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			String a = s.next();
			String b = s.next();
			String[] str1 = a.split(",");
			String[] str2 = b.split(",");
			a = "";
			b = "";
			for (int i = 0; i < str1.length; i++) {
				a += str1[i];
			}
			for (int i = 0; i < str2.length; i++) {
				b += str2[i];
			}
			long num1 = Long.parseLong(a);
			long num2 = Long.parseLong(b);
			System.out.println(num1 + num2);
		}
	}

}
