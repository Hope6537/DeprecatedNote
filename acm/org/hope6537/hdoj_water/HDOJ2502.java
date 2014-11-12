package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2502 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int n = s.nextInt();
				int start = 1 << n - 1;
				int end = 1 << (n);
				int count = 0;
				for (int i = start; i <= end; i++) {
					String bin = Integer.toBinaryString(i);
					for (int j = 0; j < bin.length(); j++) {
						if (bin.charAt(j) == '1') {
							count++;
						}
					}
				}
				System.out.println(count-1);
			}
		}

	}

}
