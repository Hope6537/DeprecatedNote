package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1720 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int numa = s.nextInt(16);
			int numb = s.nextInt(16);
			int c = numa + numb;
			System.out.println(c);
		}
	}
}
