package org.hope6537.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ4505 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int C = s.nextInt();
		while (C-- != 0) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			Arrays.sort(arr);
			int now = 0;
			int time = 0;
			for (int i = 0; i < n; i++) {
				int tar = arr[i];
				if (tar == now) {
					time++;
				} else if (tar > now) {
					time += (tar - now) * 6 + 5 + 1;
					now = tar;
				}
			}
			time += now * 4;
			System.out.println(time);
		}
	}

}
