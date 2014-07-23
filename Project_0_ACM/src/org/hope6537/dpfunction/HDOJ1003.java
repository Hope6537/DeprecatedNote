package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1003 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int cases = s.nextInt();
			for (int i = 0; i < cases; i++) {
				int num = s.nextInt();
				int[] a = new int[num + 1];
				for (int j = 1; j <= num; j++) {
					a[j] = s.nextInt();
				}
				int[] res = new int[num + 1];
				// input done
				int start = 1;
				int sum = 0;
				int maxSum = a[1];
				int end = 1;
				int tempS = 1;
				for (int j = 1; j <= num; j++) {
					sum += a[j];
					if (sum > maxSum) {
						maxSum = sum;
						start = tempS;
						end = j;
					}
					if (sum < 0) {
						sum = 0;
						tempS = j + 1;
					}
				}
				System.out.println("Case " + (i + 1) + ":");
				System.out.println(maxSum + " " + start + " " + end);
				if (i < cases - 1) {
					System.out.println();
				}
			}
		}
	}
}
