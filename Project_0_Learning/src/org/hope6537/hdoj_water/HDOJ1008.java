package org.hope6537.hdoj_water;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class HDOJ1008 {

	static Scanner s = new Scanner(new BufferedInputStream(System.in));

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			if(n==0){
				break;
			}
			int floor = 0;
			int time = 0;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = s.nextInt();
			}
			for (int i = 0; i < n; i++) {
				int height = a[i];
				if (floor > height) {
					time += 4 * (floor - height) + 5;
					floor = height;
				} else if (floor < height) {
					time += 6 * (height - floor) + 5;
					floor = height;
				}
				else {
					time += 5;
				}
			}
			System.out.println(time);
		}
	}

}
