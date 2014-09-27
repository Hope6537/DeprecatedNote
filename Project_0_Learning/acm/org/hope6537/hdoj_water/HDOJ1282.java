package org.hope6537.hdoj_water;

import java.math.BigInteger;
import java.util.Scanner;

public class HDOJ1282 {

	public static boolean isHui(String number) {

		boolean res = true;
		int half = number.length() / 2;
		if (number.length() % 2 != 0) {
			String str1 = number.substring(0, half);
			String str2 = number.substring(half + 1, number.length());
			for (int i = 0, j = str2.length() - 1; i < str1.length() && j >= 0; i++, j--) {
				if (str1.charAt(i) == str2.charAt(j)) {
					;
				} else {
					res = false;
					break;
				}
			}
		} else {
			String str1 = number.substring(0, half);
			String str2 = number.substring(half, number.length());
			for (int i = 0, j = str2.length() - 1; i < str1.length() && j >= 0; i++, j--) {
				if (str1.charAt(i) == str2.charAt(j)) {
					;
				} else {
					res = false;
					break;
				}
			}
		}
		return res;
	}

	public static String daoNumberSum(String number) {
		BigInteger i1 = new BigInteger(number);
		String str2 = "";
		for (int i = number.length() - 1; i >= 0; i--) {
			str2 = str2 + number.charAt(i);
		}
		BigInteger i2 = new BigInteger(str2);
		return (i1.add(i2)) + "";
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			String[] strs = new String[100000];
			String start = s.next();
			int count = 0;
			while (!isHui(start)) {
				count++;
				strs[count] = start;
				start = daoNumberSum(start);
			}
			System.out.println(count);
			strs[count + 1] = start;
			for (int i = 1; i <= count + 1; i++) {
				System.out.print(strs[i]);
				if (i < count + 1) {
					System.out.print("--->");
				}
			}
			System.out.println();
		}
	}

}
