package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1021 {

	static Scanner s = new Scanner(System.in);


	public static void main(String[] args) {
		while (s.hasNext()) {
			long n = s.nextLong();
			System.out.println(2==n%4 ? "yes" : "no");
		}
	}
}
