package org.hope6537.tencent;

import java.util.Scanner;

public class HDOJ4509 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			boolean[] minutes = new boolean[1441];
			for (int i = 0; i < n; i++) {
				String start = s.next();
				String end = s.next();
				String[] s1 = start.split(":");
				String[] s2 = end.split(":");
				int shour = Integer.parseInt(s1[0]);
				int smin = Integer.parseInt(s1[1]);
				int ehour = Integer.parseInt(s2[0]);
				int emin = Integer.parseInt(s2[1]);
				for (int j = shour; j <= ehour; j++) {
					int flag = 0;
					for (int k = 0; k <= 60; k++) {
						if (j == shour && flag == 0) {
							k = smin;
							flag = 1;
						}
						if (j == ehour && k == emin) {
							break;
						}
						minutes[j * 60 + k] = true;
					}
				}
			}

			int min = 0;
			for (int j = 0; j < 1440; j++) {
				if (!minutes[j]) {
					min++;
				}
			}
			System.out.println(min);
		}
	}

}
