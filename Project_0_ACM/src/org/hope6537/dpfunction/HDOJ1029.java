package org.hope6537.dpfunction;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ1029 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int times = (n + 1) / 2;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			Arrays.sort(arr);
			int index = 0;
			for (int i = 0; i < n;) {

				int localT = 0;
				int temp = 0;
				for (int j = i; j < n; j++) {
					if (arr[i] == arr[j]) {
						localT++;
					}
					if (arr[i] != arr[j]) {
						temp = j;
						break;
					}
				}

				if (localT >= times) {
					index = arr[i];
					break;
				}
				i = temp;
			}
			System.out.println(index);
		}
	}
}
