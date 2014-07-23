package org.hope6537.hdoj_water;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ2561 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while(s.hasNext()){
			int C = s.nextInt();
			while (C-- != 0) {
				int n = s.nextInt();
				int[] a = new int[n];
				for (int i = 0; i < n; i++) {
					a[i] = s.nextInt();
				}
				Arrays.sort(a);
				System.out.println(a[1]);
			}
			
		}
	}
}
