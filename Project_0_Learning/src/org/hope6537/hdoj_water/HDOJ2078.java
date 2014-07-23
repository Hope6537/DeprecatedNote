package org.hope6537.hdoj_water;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ2078 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int t = s.nextInt();
			while (t-- != 0) {
				int n = s.nextInt();
				int m = s.nextInt();
				int[] lessons = new int[n];
				for (int i = 0; i < n; i++) {
					int hards = s.nextInt();
					lessons[i] = hards;
				}
				Arrays.sort(lessons);
				System.out.println(((100 - lessons[0]) * (100 - lessons[0])));
			}
		}

	}
}