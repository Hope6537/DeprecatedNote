package org.hope6537.baidu;

import java.util.Scanner;

public class HDOJ4823 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				long N = s.nextLong();
				long M = s.nextLong();
				long V = s.nextLong();
				long K = s.nextLong();
				long count = 0;
				int flag = 1;
				while (M < N) {
					if (M - V < 0) {
						flag = 0;
						System.out.println(-1);
						break;
					} else {
						long temp = M;
						M = (M - V) * K;
						if (temp == M) {
							flag = 0;
							System.out.println(-1);
							break;
						}
						count++;
					}
				}
				if (flag == 1) {
					System.out.println(count);
				}
			}
		}
	}

}
